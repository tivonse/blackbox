package com.tiv.lab.blackbox.model.profile;

import com.tiv.lab.blackbox.model.payment.TransactionProfile;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
public class Customer implements Serializable {

    private UUID customerId;

    private String name;



    @OneToOne
    private CustomerProfile customerProfile;

    @OneToMany(mappedBy = "transaction_profile_uuid")
    private List<TransactionProfile> transactionProfiles;


}
