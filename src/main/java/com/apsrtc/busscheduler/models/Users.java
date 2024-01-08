package com.apsrtc.busscheduler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {
  @Id
  @GeneratedValue
  private int id;

  @NotNull
  private String type;

  private String username;

  private String password;

}
