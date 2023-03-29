package com.app.drone.service;

import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;

import java.util.List;

public interface DroneService {

    List<DroneDTO> findAll();

    DroneDTO findById(Long id);

    void save(Drone drone);

    void saveAll(List<Drone> drone);

    void update(Drone drone);

    void deleteById(Long id);

}
