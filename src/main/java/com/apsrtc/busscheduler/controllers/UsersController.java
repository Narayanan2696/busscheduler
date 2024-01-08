package com.apsrtc.busscheduler.controllers;

import com.apsrtc.busscheduler.dto.UsersDto;
import com.apsrtc.busscheduler.models.Users;
import com.apsrtc.busscheduler.services.handlers.UsersHandler;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

  @Autowired
  UsersHandler usersHandler;

  @PostMapping(path = "/registration")
  public ResponseEntity<Users> register(@RequestBody UsersDto usersDto) {
     return new ResponseEntity<>(usersHandler.insert(usersDto), HttpStatus.CREATED);
  }
}
