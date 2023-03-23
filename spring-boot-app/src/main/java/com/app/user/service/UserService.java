package com.app.user.service;


import com.app.user.dto.UserDTO;
import com.app.user.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    void save(User user);

    void saveAll(List<User> userList);

    void update(User user);

    void deleteById(Long id);

}
