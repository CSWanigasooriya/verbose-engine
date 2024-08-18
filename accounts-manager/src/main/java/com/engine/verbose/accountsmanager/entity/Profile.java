package com.engine.verbose.accountsmanager.entity;

import com.engine.verbose.accountsmanager.entity.meta.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "instanceId", column = @Column(name = "profile_id"))
public abstract class Profile extends BaseEntity {
    @Column()
    private String name;

    @Column()
    private String nic;
}
