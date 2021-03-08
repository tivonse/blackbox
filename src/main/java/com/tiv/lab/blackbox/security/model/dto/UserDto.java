package com.tiv.lab.blackbox.security.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private String userId;
    private String username;
    private String password;
    private String salt;
    private Boolean enabled;
    private List<UserUserAuthority> userAuthorities;

    @Data
    public static class UserUserAuthority {
        private String userAuthorityId;
        private String authority;
    }
}
