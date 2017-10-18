package cn.angusyu.test.ssm.dao;

import cn.angusyu.test.ssm.entity.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * The interface Appointment dao.
 * @author AngusYu
 */
public interface AppointmentDao {

    /**
     * Insert appointment int.
     *
     * @param bookId    the book id
     * @param studentId the student id
     * @return the int
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * Query by keys with book appointment.
     *
     * @param bookId    the book id
     * @param studentId the student id
     * @return the appointment
     */
    Appointment queryByKeysWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
