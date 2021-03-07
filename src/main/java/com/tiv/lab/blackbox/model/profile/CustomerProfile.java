package com.tiv.lab.blackbox.model.profile;

import com.tiv.lab.blackbox.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "customer_profiles")
@AllArgsConstructor
public class CustomerProfile extends AbstractEntity {

    @GeneratedValue
    @Column(name = "customer_profile_id")
    private Long customerProfileId;

    @Column(name = "name")
    private String name;

    private byte[] profileAvatar;


}
