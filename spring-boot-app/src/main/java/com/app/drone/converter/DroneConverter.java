package com.app.drone.converter;

import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;
import com.app.user.entity.User;

public class DroneConverter {

    public static DroneDTO toDroneDTO(Drone drone) {
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setId(drone.getId());
        if (drone.getUser() != null) {
            droneDTO.setUserId(drone.getUser().getId());
        } else {
            droneDTO.setUserId(null);
        }
        droneDTO.setMark(drone.getMark());
        droneDTO.setModel(drone.getModel());
        droneDTO.setPrice(drone.getPrice());
        return droneDTO;
    }

    public static Drone toDrone(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setId(droneDTO.getId());
        if (droneDTO.getUserId() != null) {
            User user = new User();
            user.setId(droneDTO.getUserId());
            drone.setUser(user);
        } else {
            drone.setUser(null);
        }
        drone.setMark(droneDTO.getMark());
        drone.setModel(droneDTO.getModel());
        drone.setPrice(droneDTO.getPrice());
        return drone;
    }

}
