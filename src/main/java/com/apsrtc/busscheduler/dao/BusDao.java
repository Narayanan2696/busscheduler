package com.apsrtc.busscheduler.dao;

import com.apsrtc.busscheduler.models.Bus;
import com.apsrtc.busscheduler.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusDao extends JpaRepository<Bus, Integer> {
  Bus findByRegistrationNumber(String busRegistrationNumber);
}
