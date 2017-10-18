package cn.angusyu.test.ssm.exception;

/**
 * The type System error exception.
 *
 * @author AngusYu
 */
public class SystemErrorException extends RuntimeException{

    public SystemErrorException(String message){
        super(message);
    }

    public SystemErrorException(String message, Throwable cause){
        super(message, cause);
    }
}
