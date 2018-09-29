package org.best.alpha.advice;

import org.best.alpha.reponse.AppResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:16
 * @description:
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(Exception.class)
    public AppResponse exception(Exception e) {
        return AppResponse.failure(e.getMessage());
    }

}
