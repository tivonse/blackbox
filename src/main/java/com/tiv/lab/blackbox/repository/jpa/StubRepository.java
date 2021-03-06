package com.tiv.lab.blackbox.repository.jpa;

import com.tiv.lab.blackbox.model.Stub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StubRepository extends JpaRepository<Stub, Long> {
}
