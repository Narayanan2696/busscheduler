package com.apsrtc.busscheduler.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Bus {
  @Id
  @GeneratedValue
  private int id;

  @NotNull
  @NotBlank
  private String registrationNumber;

  private String busType;

  private String busNumber;

  private int seats;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "bus")
  private List<BusSchedule> busSchedules;
}
