package cn.angusyu.test.ssm.service;

import cn.angusyu.test.ssm.BaseTest;
import cn.angusyu.test.ssm.dto.AppointExecution;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1000;
        long studentId = 12345678910L;
        AppointExecution appointExecution = bookService.appoint(bookId, studentId);
        System.out.println(appointExecution);
    }
}
