package com.ri.securenote.controllers;

import com.ri.securenote.dtos.UserDTO;
import com.ri.securenote.models.User;
import com.ri.securenote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    UserService userService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update-role")
    public ResponseEntity<String> updateRole(@RequestParam Long userId, @RequestParam String roleName) {
        userService.updateUserRole(userId, roleName);
        return ResponseEntity.ok("User role updated successfully");
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}
