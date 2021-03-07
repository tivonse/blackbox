package com.tiv.lab.blackbox.security.credential;

import com.tiv.lab.blackbox.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "portal_users")
public class PortalUser extends AbstractEntity {

    @Column(name = "portal_user_id")
    private UUID portalUserId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "enabled")
    private Boolean enabled;

}
