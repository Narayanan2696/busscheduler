package com.apsrtc.busscheduler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Route {
  @Id
  @GeneratedValue
  private int id;

  private String via;
}
