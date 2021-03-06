package com.tiv.lab.blackbox.controller.payment;

import com.tiv.lab.blackbox.model.payment.TransactionRecord;
import com.tiv.lab.blackbox.service.payment.TransactionRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TransactionRecordController {

    private final static Logger logger = LoggerFactory.getLogger(TransactionRecordController.class);

    @Autowired
    private TransactionRecordService transactionRecordService;

    @RequestMapping(value = "/transactionRecords", method = RequestMethod.POST)
    public ResponseEntity<TransactionRecord> createTransactionRecord(@RequestBody TransactionRecord transactionRecord) {
//    public ResponseEntity<TransactionRecord> createTransactionRecord(@RequestBody HttpServletRequest httpServletRequest) {
//        httpServletRequest.get
//        logger.info("HttpServletRequest context: " + httpServletRequest);
        logger.info("TransactionRecord context: " + transactionRecord);
        TransactionRecord result = transactionRecordService.createTransactionRecord(new TransactionRecord());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "transactionRecords", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionRecord>> getAllTransactionRecords() {
        return new ResponseEntity<>(transactionRecordService.getAllTransactionRecords(), HttpStatus.OK);
    }


}
