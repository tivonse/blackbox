package com.tiv.lab.blackbox.model;

import com.tiv.lab.blackbox.model.AbstractEntity;
import com.tiv.lab.blackbox.model.payment.TransactionProfile;
import com.tiv.lab.blackbox.model.profile.CreditProfile;
import com.tiv.lab.blackbox.model.profile.CustomerProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractEntity {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private CustomerProfile customerProfile;

    @OneToOne(fetch = FetchType.LAZY)
    private CreditProfile creditProfile;

//    @OneToMany(mappedBy = "transaction_profile_uuid")
//    private List<TransactionProfile> transactionProfiles;

}
