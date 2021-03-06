package com.tiv.lab.blackbox.service.payment;

import com.tiv.lab.blackbox.model.payment.TransactionRecord;

import java.util.List;

public interface TransactionRecordService {
    TransactionRecord createTransactionRecord(TransactionRecord transactionRecord);
    TransactionRecord getTransactionRecordById(Long id) throws Exception;
    List<TransactionRecord> getAllTransactionRecords();
    TransactionRecord updateTransactionRecord(TransactionRecord transactionRecord) throws Exception;
    void deleteTransactionRecordById(Long id);
}
