package com.apsrtc.busscheduler.services;

import com.apsrtc.busscheduler.dao.UserDao;
import com.apsrtc.busscheduler.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsPasswordService implements UserDetailsPasswordService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails updatePassword(UserDetails user, String newPassword) {
    Users users = userDao.findByUsername(user.getUsername());
    users.setPassword(newPassword);
    return User.builder().username(users.getUsername()).password(newPassword).roles(users.getType())
        .build();
  }
}