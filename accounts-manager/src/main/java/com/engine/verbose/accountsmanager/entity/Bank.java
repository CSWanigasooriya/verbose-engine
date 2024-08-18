package com.engine.verbose.accountsmanager.entity;

import com.engine.verbose.accountsmanager.entity.meta.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AttributeOverride(name = "instanceId", column = @Column(name = "bank_id"))
public class Bank extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches;
}