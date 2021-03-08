package com.tiv.lab.blackbox.model.profile;

import com.tiv.lab.blackbox.model.AbstractEntity;
import com.tiv.lab.blackbox.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public CustomerProfile() {

    }
}
