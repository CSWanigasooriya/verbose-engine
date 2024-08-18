package com.engine.verbose.accountsmanager.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class BranchDTO {

    @NotNull
    private UUID bankId;

    @NotNull
    @Size(min = 1, max = 20)
    private String code;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 200)
    private String address;

    // Getters and Setters
}