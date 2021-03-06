package com.tiv.lab.blackbox.service.payment.impl;

import com.tiv.lab.blackbox.model.payment.TransactionRecord;
import com.tiv.lab.blackbox.repository.jpa.TransactionRecordRepository;
import com.tiv.lab.blackbox.service.payment.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionRecordServiceImpl implements TransactionRecordService {

    @Autowired(required = false)
    private TransactionRecordRepository transactionRecordRepository;

    @Override
    public TransactionRecord createTransactionRecord(TransactionRecord transactionRecord) {
        return null;
    }

    @Override
    public TransactionRecord getTransactionRecordById(Long id) throws Exception {
        Optional<TransactionRecord> getResult = transactionRecordRepository.findById(id);
        if (getResult.isEmpty())
            throw new Exception("Transaction record's id is not defined");
        return getResult.get();
    }

    @Override
    public List<TransactionRecord> getAllTransactionRecords() {
        return transactionRecordRepository.findAll();
    }

    @Override
    public TransactionRecord updateTransactionRecord(TransactionRecord transactionRecord) throws Exception {
        Long updateId = transactionRecord.getId();
        if (!transactionRecordRepository.existsById(updateId))
            throw new Exception("Transaction record is not defined");
        return transactionRecordRepository.save(transactionRecord);
    }

    @Override
    public void deleteTransactionRecordById(Long id) {
        transactionRecordRepository.deleteById(id);
    }
}
