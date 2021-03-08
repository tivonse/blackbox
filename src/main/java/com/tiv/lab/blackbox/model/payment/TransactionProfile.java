package com.tiv.lab.blackbox.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "transaction_profiles")
@AllArgsConstructor
public class TransactionProfile {

    @Id
    private Long id;

    public TransactionProfile() {

    }

//    @ManyToOne
//    @JoinColumn
//    private UUID transactionProfileUuid;
}
