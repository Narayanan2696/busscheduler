package com.apsrtc.busscheduler.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class ScheduleResponseDto {
  private String busRegistrationNumber;
  private String viaRoute;
  private LocalTime startTime;
  private LocalTime endTime;

  public ScheduleResponseDto(String busRegistrationNumber, String viaRoute, LocalTime startTime, LocalTime endTime) {
    this.busRegistrationNumber = busRegistrationNumber;
    this.viaRoute = viaRoute;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
