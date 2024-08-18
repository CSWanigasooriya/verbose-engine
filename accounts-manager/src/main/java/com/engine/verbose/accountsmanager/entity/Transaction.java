package com.engine.verbose.accountsmanager.entity;

import com.engine.verbose.accountsmanager.entity.meta.BaseEntity;
import com.engine.verbose.accountsmanager.model.TransactionStatus;
import com.engine.verbose.accountsmanager.model.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AttributeOverride(name = "instanceId", column = @Column(name = "transaction_id"))
public class Transaction extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String transactionReference;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
}