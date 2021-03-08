package com.tiv.lab.blackbox.service.auth;

import com.tiv.lab.blackbox.security.model.User;
import com.tiv.lab.blackbox.security.model.dto.UserDto;
import org.springframework.stereotype.Service;

public interface AuthService {
    User registerUser(UserDto userDto);
}
