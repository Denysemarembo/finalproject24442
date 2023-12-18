package com.Denyse.Final.Project.services;

import com.Denyse.Final.Project.dto.UserDto;
import com.Denyse.Final.Project.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
