package org.best.alpha.exception;

import org.best.alpha.base.BaseException;

/**
 * @author: BG336672
 * @create: 2018-09-27 11:34
 * @description:
 **/
public class DataPersistenceException extends BaseException{

    public DataPersistenceException(String message) {
        super(message);
    }

    @Override
    public Integer getExceptionCode() {
        return 403;
    }
}
