package com.apsrtc.busscheduler.controllers;

import com.apsrtc.busscheduler.dto.BusDto;
import com.apsrtc.busscheduler.models.Bus;
import com.apsrtc.busscheduler.services.handlers.BusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buses")
public class BusController {
  @Autowired
  BusHandler busHandler;
  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  @PostMapping
  public ResponseEntity<Bus> create(@RequestBody BusDto request) {
    return new ResponseEntity<Bus>(busHandler.insert(request), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  @GetMapping(path = "/{id}")
  public ResponseEntity<Bus> show(@PathVariable int id) {
    return new ResponseEntity<Bus>(busHandler.fetch(id), HttpStatus.OK);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PatchMapping(path = "/{id}")
  public ResponseEntity<Bus> update(@PathVariable int id, @RequestBody BusDto request) {
    return new ResponseEntity<Bus>(busHandler.modify(id, request), HttpStatus.OK);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    boolean deleted = busHandler.destroy(id);
    return new ResponseEntity<>("deleted successfully?" + deleted, HttpStatus.OK);
  }
}
