package com.app.drone.converter;

import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;

public class DroneConverter {

    public static DroneDTO toDroneDTO(Drone drone) {
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setId(drone.getId());
        droneDTO.setMark(drone.getMark());
        droneDTO.setModel(drone.getModel());
        droneDTO.setPrice(drone.getPrice());
        return droneDTO;
    }

    public static Drone toDrone(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setId(droneDTO.getId());
        drone.setMark(droneDTO.getMark());
        drone.setModel(droneDTO.getModel());
        drone.setPrice(droneDTO.getPrice());
        return drone;
    }

}
