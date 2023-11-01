package com.EstoqueTL.Data.DTO;

import com.EstoqueTL.Data.Models.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
