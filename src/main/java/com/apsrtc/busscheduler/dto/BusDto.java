package com.apsrtc.busscheduler.dto;

import lombok.Data;

@Data
public class BusDto {
  private String registrationNumber;
  private String busType;
  private String busNumber;
  private int seats;
}
