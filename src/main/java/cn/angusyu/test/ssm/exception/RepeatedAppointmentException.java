package cn.angusyu.test.ssm.exception;

/**
 * The type Repeated appointment exception.
 *
 * @author AngusYu
 */
public class RepeatedAppointmentException extends RuntimeException{

    public RepeatedAppointmentException(String message){
        super(message);
    }

    public RepeatedAppointmentException(String message, Throwable cause){
        super(message, cause);
    }
}
