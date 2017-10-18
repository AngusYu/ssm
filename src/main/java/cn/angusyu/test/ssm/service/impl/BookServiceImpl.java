package cn.angusyu.test.ssm.service.impl;

import cn.angusyu.test.ssm.dao.AppointmentDao;
import cn.angusyu.test.ssm.dao.BookDao;
import cn.angusyu.test.ssm.dto.AppointExecution;
import cn.angusyu.test.ssm.entity.Appointment;
import cn.angusyu.test.ssm.entity.Book;
import cn.angusyu.test.ssm.exception.OutOfStockException;
import cn.angusyu.test.ssm.exception.RepeatedAppointmentException;
import cn.angusyu.test.ssm.exception.SystemErrorException;
import cn.angusyu.test.ssm.service.BookService;
import cn.angusyu.test.ssm.util.enums.AppointStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author AngusYu
 */
@Service
public class BookServiceImpl implements BookService{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;


    @Override
    public Book getBookById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.queryAll(0,Short.MAX_VALUE);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            int update = bookDao.reduceAmount(bookId);
            if (update <= 0) {
                throw new OutOfStockException("Out of Stock");
            }else{
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {
                    throw new RepeatedAppointmentException("Repeated Appointment");
                } else {
                    Appointment appointment = appointmentDao.queryByKeysWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (OutOfStockException e1) {
            throw e1;
        } catch (RepeatedAppointmentException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SystemErrorException("System Error:"+e.getMessage());
        }
    }
}
