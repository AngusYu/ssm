package cn.angusyu.test.ssm.dao;

import cn.angusyu.test.ssm.BaseTest;
import cn.angusyu.test.ssm.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() throws Exception{
        //Book ID
        long id=1000;
        Book book=bookDao.queryById(id);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Book> books=bookDao.queryAll(0,4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceAmount() throws Exception{
        long bookId=1000;
        int update=bookDao.reduceAmount(bookId);
        System.out.println("Update:"+update);
    }
}
