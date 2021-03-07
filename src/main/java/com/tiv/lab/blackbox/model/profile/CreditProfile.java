package com.tiv.lab.blackbox.model.profile;

import com.tiv.lab.blackbox.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "credit_profiles")
@Data
@AllArgsConstructor
public class CreditProfile extends AbstractEntity {

    @GeneratedValue
    @Column(name = "credit_profile_id")
    private Long creditProfileId;


}
