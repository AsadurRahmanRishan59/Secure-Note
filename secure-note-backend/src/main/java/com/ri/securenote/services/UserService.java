package com.ri.securenote.services;

import com.ri.securenote.dtos.UserDTO;
import com.ri.securenote.models.User;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);
    List<User> getAllUsers();
    UserDTO getUserById(Long userId);
    User findByUsername(String  username);
}
