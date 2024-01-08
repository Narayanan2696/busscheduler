package com.apsrtc.busscheduler.services.handlers;

import com.apsrtc.busscheduler.dao.BusDao;
import com.apsrtc.busscheduler.dto.BusDto;
import com.apsrtc.busscheduler.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusHandlerImplementation implements BusHandler {
  @Autowired
  BusDao busDao;
  @Override
  public Bus insert(BusDto request) {
    Bus bus = new Bus();
    bus.setBusNumber(request.getBusNumber());
    bus.setBusType(request.getBusType());
    bus.setRegistrationNumber(request.getRegistrationNumber());
    bus.setSeats(request.getSeats());

    return busDao.save(bus);
  }

  @Override
  public Bus fetch(int id) {
    return busDao.findById(id).get();
  }

  @Override
  public Bus modify(int id, BusDto request) {
    Bus bus = busDao.findById(id).get();
    if(request.getSeats() != 0) bus.setSeats(request.getSeats());
    if(request.getBusNumber() != null) bus.setBusNumber(request.getBusNumber());
    if(request.getRegistrationNumber() != null) bus.setRegistrationNumber(request.getRegistrationNumber());
    if(request.getBusType() != null) bus.setBusType(request.getBusType());

    return busDao.save(bus);
  }

  @Override
  public boolean destroy(int id) {
    try{
      busDao.deleteById(id);
      return true;
    } catch (Exception e) {
//      throw new RuntimeException(e);
      return false;
    }

  }
}
