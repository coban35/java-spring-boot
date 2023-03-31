package com.app.user.service;

import com.app.ApiResponse;
import com.app.user.converter.UserConverter;
import com.app.user.dto.UserDTO;
import com.app.user.entity.User;
import com.app.user.exception.UserException;
import com.app.user.exception.UserIdNotFoundException;
import com.app.user.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public ApiResponse save(User user) {
        try {
            userRepository.save(user);
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new UserException();
        }
    }

    @Override
    public ApiResponse saveAll(List<User> userList) {
        try {
            userRepository.saveAll(userList);
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new UserException();
        }
    }

    @Override
    public ApiResponse update(User user) {
        try {
            userRepository.save(user);
            return createSuccessApiResponse();
        } catch (Exception e) {
            throw new UserException();
        }
    }

    @Override
    public ApiResponse deleteById(Long id) {
        try {
            userRepository.deleteById(id);
            return createSuccessApiResponse();
        } catch (EmptyResultDataAccessException e) {
            throw new UserIdNotFoundException();
        } catch (Exception e) {
            throw new UserException();
        }
    }

    private ApiResponse createSuccessApiResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCreationDate(new Date());
        apiResponse.setCode("200");
        apiResponse.setMessage("Success.");
        return apiResponse;
    }

}
