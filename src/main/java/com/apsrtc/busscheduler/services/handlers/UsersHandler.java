package com.apsrtc.busscheduler.services.handlers;

import com.apsrtc.busscheduler.dto.UsersDto;
import com.apsrtc.busscheduler.models.Users;

public interface UsersHandler {
  Users insert(UsersDto usersDto);
}
