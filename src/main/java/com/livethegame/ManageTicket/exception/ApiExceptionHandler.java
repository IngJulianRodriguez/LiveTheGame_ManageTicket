package com.livethegame.ManageTicket.exception;


import com.livethegame.ManageTicket.common.StandarizedApiExceptionResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBusinessRuleExceptions(BusinessRuleException ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getCode(),"", ex.getMessage());
        return new ResponseEntity<>(response,  ex.getHttpStatus() != null ? ex.getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleNoContentException(IOException ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Input Ouput Error","erorr-1024",ex.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
