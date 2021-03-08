package com.tiv.lab.blackbox.security.model;

import com.tiv.lab.blackbox.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAuthorityId")
    private List<UserAuthority> userAuthorities;

    public User() {

    }

}
