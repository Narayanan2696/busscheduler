package com.apsrtc.busscheduler.controllers.exception;

import com.apsrtc.busscheduler.dto.ErrorMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(value = {Exception.class, RuntimeException.class})
  public ResponseEntity<ErrorMessageDto> handleAnyExceptions(Exception e, WebRequest request) {
    return new ResponseEntity<>(new ErrorMessageDto(e), new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
