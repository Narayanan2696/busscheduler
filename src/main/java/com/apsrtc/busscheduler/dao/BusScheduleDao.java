package com.apsrtc.busscheduler.dao;

import com.apsrtc.busscheduler.models.Bus;
import com.apsrtc.busscheduler.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;

public interface BusScheduleDao extends JpaRepository<BusSchedule, Integer> {
  BusSchedule findByRouteIdAndStartTime(int routeId, LocalTime startTime);

  @Query("SELECT bs FROM BusSchedule bs WHERE bs.bus = ?1 AND bs.startTime <= ?2 AND bs.endTime >= ?3")
  BusSchedule findByScheduleBetweenStartAndEndTime(Bus bus, LocalTime startTime, LocalTime endTime);
}
