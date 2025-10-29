package com.ri.securenote.dtos;

import com.ri.securenote.models.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDTO(
        Long userId,
        String userName,
        String email,
        boolean accountNonLocked,
        boolean accountNonExpired,
        boolean credentialsNonExpired,
        boolean enabled,
        LocalDate credentialsExpiryDate,
        LocalDate accountExpiredDate,
        String twoFactorSecret,
        boolean isTwoFactorEnabled,
        String signUpMethod,
        Role role,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
