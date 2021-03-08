package com.tiv.lab.blackbox.model.profile;

import com.tiv.lab.blackbox.model.AbstractEntity;
import com.tiv.lab.blackbox.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "credit_profiles")
@Data
@AllArgsConstructor
public class CreditProfile extends AbstractEntity {

    @GeneratedValue
    @Column(name = "credit_profile_id")
    private Long creditProfileId;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public CreditProfile() {

    }
}
