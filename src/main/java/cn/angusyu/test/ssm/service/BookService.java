package cn.angusyu.test.ssm.service;

import cn.angusyu.test.ssm.dto.AppointExecution;
import cn.angusyu.test.ssm.entity.Book;

import java.util.List;

/**
 * The interface Book service.
 *
 * @author AngusYu
 */
public interface BookService {

    /**
     * Gets by id.
     *
     * @param bookId the book id
     * @return the by id
     */
    Book getBookById(long bookId);

    /**
     * Gets list.
     *
     * @return the list
     */
    List<Book> listBooks();

    /**
     * Appoint appoint execution.
     *
     * @param bookId    the book id
     * @param studentId the student id
     * @return the appoint execution
     */
    AppointExecution appoint(long bookId, long studentId);
}
