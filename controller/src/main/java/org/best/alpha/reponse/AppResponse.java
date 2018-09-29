package org.best.alpha.reponse;

import org.best.alpha.base.BaseException;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:15
 * @description:
 **/
public class AppResponse {

    private Boolean success;

    private Integer code;

    private String message;

    private Object date;

    private AppResponse(Boolean success, Integer code, String message, Object date) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public static AppResponse success() {
        return success(null);
    }

    public static AppResponse success(Object date){
        Integer code = 200;
        String message = "OK";
        return success(code, message, date);
    }

    public static AppResponse success(Integer code, String message, Object date) {
        return new AppResponse(true, code, message, date);
    }

    public static AppResponse failure() {
        return failure((Object) null);
    }

    public static AppResponse failure(Object date) {
        Integer code = 500;
        String message = "Failure";
        return failure(code, message, date);
    }

    public static AppResponse failure(String message) {
        Integer code = 500;
        return AppResponse.failure(code, message);
    }

    public static AppResponse failure(BaseException e) {
        return AppResponse.failure(e, null);
    }

    public static AppResponse failure(BaseException e, Object date) {
        return AppResponse.failure(e.getCode(), e.getMessage(), date);
    }

    public static AppResponse failure(Integer code, String message) {
        return AppResponse.failure(code, message, null);
    }

    public static AppResponse failure(Integer code, String message, Object date) {
        return new AppResponse(false, code, message, date);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
