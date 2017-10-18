package cn.angusyu.test.ssm.dao;

import cn.angusyu.test.ssm.BaseTest;
import cn.angusyu.test.ssm.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception{
        long bookId=1000;
        long studentId=12345678910L;
        int insert=appointmentDao.insertAppointment(bookId,studentId);
        System.out.println("Insert:"+insert);
    }

    @Test
    public void testQueryByBookIdWithStudentId() throws Exception{
        long bookId=1000;
        long studentId=12345678910L;
        Appointment appointment=appointmentDao.queryByKeysWithBook(bookId,studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook().toString());
    }
}
