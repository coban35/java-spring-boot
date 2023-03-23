package com.app.user.controller;

import com.app.user.dto.UserDTO;
import com.app.user.entity.User;
import com.app.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/findAll")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findById/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PostMapping("/saveAll")
    public void saveAll(@RequestBody List<User> userList) {
        userService.saveAll(userList);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @PostMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
