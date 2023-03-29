package com.app.drone.controller;

import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;
import com.app.drone.service.DroneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/drone")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping(path = "/findAll")
    public List<DroneDTO> findAll() {
        return droneService.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    public DroneDTO findById(@PathVariable("id") Long id) {
        return droneService.findById(id);
    }

    @PostMapping(path = "/save")
    public void save(@RequestBody Drone drone) {
        droneService.save(drone);
    }

    @PostMapping(path = "/saveAll")
    public void saveAll(@RequestBody List<Drone> drone) {
        droneService.saveAll(drone);
    }

    @PostMapping("/update")
    public void update(@RequestBody Drone drone) {
        droneService.update(drone);
    }

    @PostMapping(path = "/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        droneService.deleteById(id);
    }

}
