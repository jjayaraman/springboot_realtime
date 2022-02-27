package com.wh.sportsbook.sportsbook.controller.exception.handler;

import com.wh.sportsbook.sportsbook.controller.exception.ApiError;
import com.wh.sportsbook.sportsbook.controller.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Slf4j
public class SportsRestResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ApiError otherErrors(Exception ex) {
        log.error(ex.getMessage());
        return new ApiError(HttpStatus.EXPECTATION_FAILED, "A System exception occurred, please contact Helpdesk");
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiError scoreNotFoundHandler(EntityNotFoundException ex) {
        return new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
