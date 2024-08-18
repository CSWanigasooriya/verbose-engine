package com.engine.verbose.accountsmanager.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountDTO {
    private UUID branchId;
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal initialBalance;
}