package com.engine.verbose.accountsmanager.entity.meta;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID instanceId;

    @Column(nullable = false)
    private LocalDateTime lastUpdatedDate;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        lastUpdatedDate = LocalDateTime.now();
    }
}
