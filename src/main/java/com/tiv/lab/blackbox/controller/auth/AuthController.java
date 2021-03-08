package com.tiv.lab.blackbox.controller.auth;

import com.tiv.lab.blackbox.security.model.User;
import com.tiv.lab.blackbox.security.model.dto.UserDto;
import com.tiv.lab.blackbox.service.auth.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.POST)
    public String login() {
        log.debug("called login() api...");
        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        log.debug("called logout() api...");
        return "/logout";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody UserDto userDto) {
        return authService.registerUser(userDto);
    }
}
