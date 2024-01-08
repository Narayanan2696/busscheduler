package com.apsrtc.busscheduler.services.handlers;

import com.apsrtc.busscheduler.dao.BusDao;
import com.apsrtc.busscheduler.dao.BusScheduleDao;
import com.apsrtc.busscheduler.dao.RouteDao;
import com.apsrtc.busscheduler.dto.BusScheduleDto;
import com.apsrtc.busscheduler.dto.ScheduleResponseDto;
import com.apsrtc.busscheduler.models.Bus;
import com.apsrtc.busscheduler.models.BusSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusScheduleHandlerImplementation implements BusScheduleHandler{
  @Autowired
  BusScheduleDao busScheduleDao;
  @Autowired
  BusDao busDao;
  @Autowired
  RouteDao routeDao;
  @Override
  public BusSchedule insert(BusScheduleDto request) {
    BusSchedule busSchedule = new BusSchedule();

    if(validSchedule(request) && busAlreadyRunning(request)) {
      busSchedule.setBus(busDao.findById(request.getBusId()).get());
      busSchedule.setRoute(routeDao.findById(request.getRouteId()).get());
      busSchedule.setStartTime(request.getStartTime());
      busSchedule.setEndTime(request.getEndTime());

      return busScheduleDao.save(busSchedule);
    } else {
      throw new RuntimeException("Bus is already running in the given route for the scheduled time");
    }
  }

  @Override
  public List<ScheduleResponseDto> busDetailsByRegistrationNumber(String busRegistrationNumber) {
    Bus bus = busDao.findByRegistrationNumber(busRegistrationNumber);
    List<ScheduleResponseDto> busSchedules = new ArrayList<>();
    for(BusSchedule busSchedule: bus.getBusSchedules()) {
      busSchedules.add(new ScheduleResponseDto(bus.getRegistrationNumber(), busSchedule.getRoute().getVia(), busSchedule.getStartTime(), busSchedule.getEndTime()));
    }
    return busSchedules;
  }

  // Given bus is starting at the same schedule as of another bus
  private boolean busAlreadyRunning(BusScheduleDto busScheduleDto) {
    return busScheduleDao.findByRouteIdAndStartTime(busScheduleDto.getRouteId(), busScheduleDto.getStartTime()) == null;
  }

  // Given bus is already running on a route for the given schedule
  private boolean validSchedule(BusScheduleDto busScheduleDto) {
    return busScheduleDao.findByScheduleBetweenStartAndEndTime(busDao.findById(busScheduleDto.getBusId()).get(), busScheduleDto.getStartTime(), busScheduleDto.getEndTime()) == null;
  }
}
