package com.app.user.service;

import com.app.ApiResponse;
import com.app.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    ApiResponse save(UserDTO userDTO);

    ApiResponse saveAll(List<UserDTO> userDTOList);

    ApiResponse update(UserDTO userDTO);

    ApiResponse deleteById(Long id);

}
