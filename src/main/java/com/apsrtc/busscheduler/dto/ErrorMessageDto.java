package com.apsrtc.busscheduler.dto;

import lombok.Data;

import java.util.Date;

public class ErrorMessageDto {
  private Date timestamp;
  private String message;
  private StackTraceElement[] stackTrace;

  public ErrorMessageDto(Exception e) {
    this.timestamp = new Date();
    this.message = e.getMessage();
    this.stackTrace = e.getStackTrace();
  }
}
