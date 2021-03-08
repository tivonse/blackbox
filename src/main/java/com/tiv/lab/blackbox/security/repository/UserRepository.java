package com.tiv.lab.blackbox.security.repository;

import com.tiv.lab.blackbox.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
