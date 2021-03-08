package com.tiv.lab.blackbox.controller.auth;

import com.tiv.lab.blackbox.security.model.User;
import com.tiv.lab.blackbox.security.model.dto.UserDto;
import com.tiv.lab.blackbox.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/user")
    @ResponseBody
    public User registerUser(@RequestBody UserDto userDto) {
        return authService.registerUser(userDto);
    }
}
