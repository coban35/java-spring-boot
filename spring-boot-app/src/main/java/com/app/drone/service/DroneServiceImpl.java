package com.app.drone.service;

import com.app.ApiResponse;
import com.app.drone.converter.DroneConverter;
import com.app.drone.dto.DroneDTO;
import com.app.drone.dto.RentDTO;
import com.app.drone.exception.DroneAlreadyRentedException;
import com.app.drone.exception.DroneException;
import com.app.drone.exception.DroneIdNotFoundException;
import com.app.drone.repository.DroneRepository;
import com.app.user.exception.UserIdNotFoundException;
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
    public ApiResponse save(DroneDTO droneDTO) {
        try {
            droneRepository.save(DroneConverter.toDrone(droneDTO));
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    @Override
    public ApiResponse saveAll(List<DroneDTO> droneDTOList) {
        try {
            droneRepository.saveAll(droneDTOList.stream().map(DroneConverter::toDrone).collect(Collectors.toList()));
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    @Override
    public ApiResponse update(DroneDTO droneDTO) {
        try {
            droneRepository.save(DroneConverter.toDrone(droneDTO));
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

    @Override
    public List<DroneDTO> getAvailableDroneList() {
        return droneRepository.getAvailableDroneList().stream().map(DroneConverter::toDroneDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse rent(RentDTO rentDTO) {
        if (rentDTO.getDroneId() == null) {
            throw new DroneIdNotFoundException();
        }
        if (rentDTO.getUserId() == null) {
            throw new UserIdNotFoundException();
        }
        try {
            DroneDTO droneDTO = findById(rentDTO.getDroneId());
            if (droneDTO.getUserId() == null) {
                droneDTO.setUserId(rentDTO.getUserId());
                save(droneDTO);
                return createSuccessApiResponse();
            } else {
                throw new DroneAlreadyRentedException();
            }
        } catch (DroneAlreadyRentedException | DroneIdNotFoundException | UserIdNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DroneException();
        }
    }

    @Override
    public List<DroneDTO> droneListByUserId(Long userId) {
        return droneRepository.droneListByUserId(userId).stream().map(DroneConverter::toDroneDTO).collect(Collectors.toList());
    }

    private ApiResponse createSuccessApiResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCreationDate(new Date());
        apiResponse.setCode("200");
        apiResponse.setMessage("Success.");
        return apiResponse;
    }

}
