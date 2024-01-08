package com.apsrtc.busscheduler.controllers;

import com.apsrtc.busscheduler.dto.BusScheduleDto;
import com.apsrtc.busscheduler.dto.ScheduleResponseDto;
import com.apsrtc.busscheduler.models.BusSchedule;
import com.apsrtc.busscheduler.services.handlers.BusScheduleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus-schedules")
public class BusScheduleController {

  @Autowired
  BusScheduleHandler busScheduleHandler;

  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  @PostMapping
  public ResponseEntity<BusSchedule> create(@RequestBody BusScheduleDto request) {
    return new ResponseEntity<>(busScheduleHandler.insert(request), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  @GetMapping
  public ResponseEntity<List<ScheduleResponseDto>> busDetails(@RequestParam String busRegistrationNumber) {
    List<ScheduleResponseDto> busSchedule = busScheduleHandler.busDetailsByRegistrationNumber(busRegistrationNumber);
    return new ResponseEntity<>(busSchedule, HttpStatus.OK);
  }
}
