package com.tiv.lab.blackbox.model;

import com.tiv.lab.blackbox.model.AbstractEntity;
import com.tiv.lab.blackbox.model.payment.TransactionProfile;
import com.tiv.lab.blackbox.model.profile.CreditProfile;
import com.tiv.lab.blackbox.model.profile.CustomerProfile;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
public class Customer extends AbstractEntity {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    private String name;

//    @OneToOne
//    private CustomerProfile customerProfile;
//
//    @OneToOne
//    private CreditProfile creditProfile;

//    @OneToMany(mappedBy = "transaction_profile_uuid")
//    private List<TransactionProfile> transactionProfiles;


}
