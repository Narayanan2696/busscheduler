package com.apsrtc.busscheduler.services.handlers;

import com.apsrtc.busscheduler.dto.BusScheduleDto;
import com.apsrtc.busscheduler.dto.ScheduleResponseDto;
import com.apsrtc.busscheduler.models.BusSchedule;

import java.util.List;

public interface BusScheduleHandler {
  BusSchedule insert(BusScheduleDto request);

  List<ScheduleResponseDto> busDetailsByRegistrationNumber(String busRegistrationNumber);
}
