package org.best.alpha.exception;

import org.best.alpha.base.BaseException;

/**
 * @author: BG336672
 * @create: 2018-09-27 11:14
 * @description:
 **/
public class NullPointException extends BaseException{

    public NullPointException(String message) {
        super(message);
    }

    @Override
    public Integer getExceptionCode() {
        return 402;
    }
}
