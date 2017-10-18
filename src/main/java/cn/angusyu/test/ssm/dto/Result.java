package cn.angusyu.test.ssm.dto;

/**
 * The type Result.
 *
 * @param <T> the type parameter
 * @author AngusYu
 */
public class Result<T> {

    private boolean success;
    private String error;

    private T data;


    /**
     * appoint success Result.
     *
     * @param success the success
     * @param data    the data
     */
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    /**
     * appoint fail Result.
     *
     * @param success the success
     * @param error   the error
     */
    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}
