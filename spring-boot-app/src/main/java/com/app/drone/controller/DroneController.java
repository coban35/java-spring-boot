package com.app.drone.controller;

import com.app.ApiResponse;
import com.app.drone.dto.DroneDTO;
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
    public ApiResponse save(@RequestBody DroneDTO droneDTO) {
        return droneService.save(droneDTO);
    }

    @PostMapping(path = "/saveAll")
    @ApiOperation(value = "Drone toplu kaydeden servis.")
    public ApiResponse saveAll(@RequestBody List<DroneDTO> droneDTOList) {
        return droneService.saveAll(droneDTOList);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Drone güncelleyen servis.")
    public ApiResponse update(@RequestBody DroneDTO droneDTO) {
        return droneService.update(droneDTO);
    }

    @PostMapping(path = "/deleteById/{id}")
    @ApiOperation(value = "Id'ye göre drone silen servis.")
    public ApiResponse deleteById(@PathVariable("id") Long id) {
        return droneService.deleteById(id);
    }

}
