package com.tiv.lab.blackbox.repository.jpa;

import com.tiv.lab.blackbox.model.payment.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRecordRepository extends JpaRepository<TransactionRecord, Long> {
}
