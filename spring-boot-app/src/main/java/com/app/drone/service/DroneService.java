package com.app.drone.service;

import com.app.ApiResponse;
import com.app.drone.dto.DroneDTO;

import java.util.List;

public interface DroneService {

    List<DroneDTO> findAll();

    DroneDTO findById(Long id);

    ApiResponse save(DroneDTO droneDTO);

    ApiResponse saveAll(List<DroneDTO> droneDTOList);

    ApiResponse update(DroneDTO droneDTO);

    ApiResponse deleteById(Long id);

}
