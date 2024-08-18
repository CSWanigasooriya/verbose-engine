package com.engine.verbose.accountsmanager.mapper;

import com.engine.verbose.accountsmanager.dto.BankDTO;
import com.engine.verbose.accountsmanager.entity.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BankMapper {

    @Mapping(target = "bankId", source = "instanceId")
    @Mapping(target = "branches", ignore = true)
    BankDTO toBankDTO(Bank bank);

    @Mapping(target = "instanceId", source = "bankId")
    @Mapping(target = "lastUpdatedDate", ignore = true)
    @Mapping(target = "branches", ignore = true)
    Bank toBank(BankDTO bankDTO);
}