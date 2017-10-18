package cn.angusyu.test.ssm.dao;

import cn.angusyu.test.ssm.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Book dao.
 * @author AngusYu
 */
public interface BookDao {


    /**
     * Query by id book.
     *
     * @param id the id
     * @return the book
     */
    Book queryById(long id);

    /**
     * Query all list.
     *
     * @param offset the offset
     * @param limit  the limit
     * @return the list
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * Reduce number int.
     *
     * @param id the id
     * @return the int
     */
    int reduceAmount(long id);
}
