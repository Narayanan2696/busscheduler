package com.apsrtc.busscheduler.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class BusSchedule {

  @Id
  @GeneratedValue
  private int id;

  @ManyToOne
  private Bus bus;

  @ManyToOne
  private Route route;

  private LocalTime startTime;

  private LocalTime endTime;
}
