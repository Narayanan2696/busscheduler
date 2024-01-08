package com.apsrtc.busscheduler.dao;

import com.apsrtc.busscheduler.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, Integer> {
  Users findByUsername(String username);
}
