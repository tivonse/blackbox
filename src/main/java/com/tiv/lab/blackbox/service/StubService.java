package com.tiv.lab.blackbox.service;

import com.tiv.lab.blackbox.model.Stub;
import com.tiv.lab.blackbox.repository.jpa.StubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StubService {

    private final static Logger logger = LoggerFactory.getLogger(StubService.class);

    @Autowired(required = false)
    private StubRepository stubRepository;

    @Cacheable("queryAllStubs")
    public List<Stub> queryAllStubs() {
        logger.info("queryAllStubs() method is called");
        return stubRepository.findAll();
    }

    public Stub addStub(Stub stub) {
        return stubRepository.save(stub);
    }

    @Cacheable(value = "getStubById", key = "#id")
    public Stub getStubById(Long id) {
        logger.info("getStubById() method is called");
        return stubRepository.findById(id).orElse(null);
    }
}
