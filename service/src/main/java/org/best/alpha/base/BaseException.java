package org.best.alpha.base;

/**
 * @author: BG336672
 * @create: 2018-09-27 10:53
 * @description:
 **/
public abstract class BaseException extends RuntimeException{

    private Integer code;

    private String message;

    public BaseException(String message) {
        super(message);
        this.code = getExceptionCode();
        this.message = message;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public abstract Integer getExceptionCode();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
