package com.engine.verbose.accountsmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID bankId;

    @NotNull
    @Size(min = 1, max = 20)
    private String code;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;
}