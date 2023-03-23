package com.app.user.service;

import com.app.user.converter.UserConverter;
import com.app.user.dto.UserDTO;
import com.app.user.entity.User;
import com.app.user.exception.UserIdNotFoundException;
import com.app.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserConverter::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return UserConverter.toUserDTO(userRepository.findById(id).orElseThrow(UserIdNotFoundException::new));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveAll(List<User> userList) {
        userRepository.saveAll(userList);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
