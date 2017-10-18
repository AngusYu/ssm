package cn.angusyu.test.ssm.exception;

/**
 * The type Out of stock exception.
 *
 * @author AngusYu
 */
public class OutOfStockException extends RuntimeException {

    public OutOfStockException(String message){
        super(message);
    }

    public OutOfStockException(String message, Throwable cause){
        super(message, cause);
    }
}
