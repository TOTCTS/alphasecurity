package org.best.alpha.exception;

import org.best.alpha.base.BaseException;

/**
 * @author: BG336672
 * @create: 2018-09-27 11:09
 * @description:
 **/
public class ParameterException extends BaseException{

    public ParameterException(String message) {
        super(message);
    }

    @Override
    public Integer getExceptionCode() {
        return 401;
    }

}
