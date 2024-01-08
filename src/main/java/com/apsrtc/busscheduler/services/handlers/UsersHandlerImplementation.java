package com.apsrtc.busscheduler.services.handlers;

import com.apsrtc.busscheduler.dao.UserDao;
import com.apsrtc.busscheduler.dto.UsersDto;
import com.apsrtc.busscheduler.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersHandlerImplementation implements UsersHandler{

  private final PasswordEncoder passwordEncoder;
  private final UserDao usersDao;

  @Autowired
  public UsersHandlerImplementation(PasswordEncoder passwordEncoder, UserDao usersDao) {
    this.passwordEncoder = passwordEncoder;
    this.usersDao = usersDao;
  }

  @Override
  public Users insert(UsersDto usersDto) {
    Users user = new Users();
    String encodedPassword = passwordEncoder.encode(usersDto.getPassword());
    user.setUsername(usersDto.getUsername());
    user.setPassword(encodedPassword);
    user.setType(usersDto.getType());

    return usersDao.save(user);
  }
}
