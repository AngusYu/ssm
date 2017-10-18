package cn.angusyu.test.ssm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author AngusYu
 */
public class Appointment {
  private Long bookId;
  private Long studentId;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date appointTime;
  private Book book;

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Date getAppointTime() {
    return appointTime;
  }

  public void setAppointTime(Date appointTime) {
    this.appointTime = appointTime;
  }

  @Override
  public String toString() {
    return "Appointment{" +
            "bookId=" + bookId +
            ", studentId=" + studentId +
            ", appointTime=" + appointTime +
            '}';
  }
}
