package web.Exception;

/**
 * 用户异常类
 */
public class UserException extends Exception {
    /**
     * 此类无参构造访问父类无参构造
     */
    public UserException(){
        super();
    }
    /**
     * 以下都是子类有参访问父类
     */
    public UserException(String message,Throwable cause){
        super(message,cause);
    }
    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
