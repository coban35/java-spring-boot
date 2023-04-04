package com.app.drone.service;

import com.app.ApiResponse;
import com.app.drone.converter.DroneConverter;
import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;
import com.app.drone.exception.DroneException;
import com.app.drone.exception.DroneIdNotFoundException;
import com.app.drone.repository.DroneRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public ApiResponse save(Drone drone) {
        try {
            droneRepository.save(drone);
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    @Override
    public ApiResponse saveAll(List<Drone> drone) {
        try {
            droneRepository.saveAll(drone);
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    @Override
    public ApiResponse update(Drone drone) {
        try {
            droneRepository.save(drone);
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    @Override
    public ApiResponse deleteById(Long id) {
        try {
            droneRepository.deleteById(id);
            return createSuccessApiResponse();
        } catch (EmptyResultDataAccessException e) {
            throw new DroneIdNotFoundException();
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    private ApiResponse createSuccessApiResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCreationDate(new Date());
        apiResponse.setCode("200");
        apiResponse.setMessage("Success.");
        return apiResponse;
    }

}
