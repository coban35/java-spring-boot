package com.app.drone.controller;

import com.app.drone.dto.DroneDTO;
import com.app.drone.entity.Drone;
import com.app.drone.service.DroneService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Tüm drone listesini getiren servis.")
    public List<DroneDTO> findAll() {
        return droneService.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    @ApiOperation(value = "Id'ye göre drone getiren servis.")
    public DroneDTO findById(@PathVariable("id") Long id) {
        return droneService.findById(id);
    }

    @PostMapping(path = "/save")
    @ApiOperation(value = "Drone kaydeden servis.")
    public void save(@RequestBody Drone drone) {
        droneService.save(drone);
    }

    @PostMapping(path = "/saveAll")
    @ApiOperation(value = "Drone toplu kaydeden servis.")
    public void saveAll(@RequestBody List<Drone> drone) {
        droneService.saveAll(drone);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Drone güncelleyen servis.")
    public void update(@RequestBody Drone drone) {
        droneService.update(drone);
    }

    @PostMapping(path = "/deleteById/{id}")
    @ApiOperation(value = "Id'ye göre drone silen servis.")
    public void deleteById(@PathVariable("id") Long id) {
        droneService.deleteById(id);
    }

}
