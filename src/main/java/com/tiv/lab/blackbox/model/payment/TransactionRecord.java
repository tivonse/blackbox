package com.tiv.lab.blackbox.model.payment;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "TRANSACTION_RECORD")
public class TransactionRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    private Date transactionDate;

//    private TransactionCategorySpec transactionCategorySpec;

    private String location;

    private String item;

    private int amount;

    private BigDecimal cost;

//    private BigDecimal dayLimitOffset;
//
//    private boolean isExceedingPerDayLimit;

    public TransactionRecord() {

    }

}
