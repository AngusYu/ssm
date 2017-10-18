package cn.angusyu.test.ssm.dto;

import cn.angusyu.test.ssm.entity.Appointment;
import cn.angusyu.test.ssm.util.enums.AppointStateEnum;

/**
 * @author AngusYu
 *
 */
public class AppointExecution {

    private long bookId;
    private int state;
    private String stateInfo;

    private Appointment appointment;

    /**
     * failed Appoint execution.
     *
     * @param bookId           the book id
     * @param appointStateEnum the appoint state enum
     */
    public AppointExecution(long bookId, AppointStateEnum appointStateEnum){
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
    }

    /**
     * Success Appoint execution.
     *
     * @param bookId           the book id
     * @param appointStateEnum the appoint state enum
     * @param appointment      the appointment
     */
    public AppointExecution(long bookId, AppointStateEnum appointStateEnum, Appointment appointment){
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
        this.appointment = appointment;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
