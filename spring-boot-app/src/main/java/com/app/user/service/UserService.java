package com.app.user.service;


import com.app.ApiResponse;
import com.app.user.dto.UserDTO;
import com.app.user.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    ApiResponse save(User user);

    ApiResponse saveAll(List<User> userList);

    ApiResponse update(User user);

    ApiResponse deleteById(Long id);

}
