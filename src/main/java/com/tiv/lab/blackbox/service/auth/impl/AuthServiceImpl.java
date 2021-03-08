package com.tiv.lab.blackbox.service.auth.impl;

import com.tiv.lab.blackbox.security.model.User;
import com.tiv.lab.blackbox.security.model.UserAuthority;
import com.tiv.lab.blackbox.security.model.dto.UserDto;
import com.tiv.lab.blackbox.security.repository.UserAuthorityRepository;
import com.tiv.lab.blackbox.security.repository.UserRepository;
import com.tiv.lab.blackbox.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        User entry = new User();
        entry.setUsername(userDto.getUsername());
        entry.setPassword(encodedPassword);
        entry.setSalt(userDto.getSalt());
        entry.setEnabled(Boolean.TRUE);
        User savedUser = userRepository.save(entry);

        List<UserAuthority> userAuthorities = new ArrayList<>();
        if (!userDto.getUserAuthorities().isEmpty()) {
            userDto.getUserAuthorities().forEach(a -> {
                UserAuthority ua = new UserAuthority();
                ua.setAuthority(a.getAuthority());
                ua.setUser(savedUser);
                userAuthorities.add(ua);
            });
        } else {
            UserAuthority ua = new UserAuthority();
            ua.setAuthority("BOARD");
            ua.setUser(savedUser);
        }

        userAuthorityRepository.saveAll(userAuthorities);
        savedUser.setUserAuthorities(userAuthorities);
        return userRepository.save(savedUser);
    }

}
