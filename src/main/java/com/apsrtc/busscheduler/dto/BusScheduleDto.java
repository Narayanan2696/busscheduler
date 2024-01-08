package com.apsrtc.busscheduler.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BusScheduleDto {
  private int busId;
  private int routeId;
  private LocalTime startTime;
  private LocalTime endTime;
}
