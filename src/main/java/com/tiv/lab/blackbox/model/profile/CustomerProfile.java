package com.tiv.lab.blackbox.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "customer_profiles")
@AllArgsConstructor
public class CustomerProfile implements Serializable {


    private byte[] profileAvatar;
}
