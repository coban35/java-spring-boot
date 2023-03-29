package com.app.drone.service;

import com.app.drone.converter.DroneConverter;
import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;
import com.app.drone.exception.DroneIdNotFoundException;
import com.app.drone.repository.DroneRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;


    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public List<DroneDTO> findAll() {
        return droneRepository.findAll().stream().map(DroneConverter::toDroneDTO).collect(Collectors.toList());
    }

    @Override
    public DroneDTO findById(Long id) {
        return DroneConverter.toDroneDTO(droneRepository.findById(id).orElseThrow(DroneIdNotFoundException::new));
    }

    @Override
    public void save(Drone drone) {
        droneRepository.save(drone);
    }

    @Override
    public void saveAll(List<Drone> drone) {
        droneRepository.saveAll(drone);
    }

    @Override
    public void update(Drone drone) {
        droneRepository.save(drone);
    }

    @Override
    public void deleteById(Long id) {
        try {
            droneRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DroneIdNotFoundException();
        }
    }

}
