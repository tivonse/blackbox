package com.tiv.lab.blackbox.security.model;

import com.tiv.lab.blackbox.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_authorities")
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthority extends AbstractEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_authority_id")
    private Long userAuthorityId;

    @Column(name = "authority", unique = true, nullable = false)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    private User user;
}
