package com.apsrtc.busscheduler.services;

import com.apsrtc.busscheduler.dao.UserDao;
import com.apsrtc.busscheduler.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = userDao.findByUsername(username);
    UserDetails userDetails = User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getType())
        .build();
    return userDetails;
  }
}
