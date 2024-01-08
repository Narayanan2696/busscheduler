package com.apsrtc.busscheduler.services.handlers;

import com.apsrtc.busscheduler.dto.BusDto;
import com.apsrtc.busscheduler.models.Bus;

public interface BusHandler {
  Bus insert(BusDto request);

  Bus fetch(int id);

  Bus modify(int id, BusDto request);

  boolean destroy(int id);
}
