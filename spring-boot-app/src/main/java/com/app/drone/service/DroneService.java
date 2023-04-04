package com.app.drone.service;

import com.app.ApiResponse;
import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;

import java.util.List;

public interface DroneService {

    List<DroneDTO> findAll();

    DroneDTO findById(Long id);

    ApiResponse save(Drone drone);

    ApiResponse saveAll(List<Drone> drone);

    ApiResponse update(Drone drone);

    ApiResponse deleteById(Long id);

}
