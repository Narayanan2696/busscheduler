package com.apsrtc.busscheduler.dao;

import com.apsrtc.busscheduler.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteDao extends JpaRepository<Route, Integer> {
}
