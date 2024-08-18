package com.engine.verbose.accountsmanager.mapper;

import com.engine.verbose.accountsmanager.dto.BankDTO;
import com.engine.verbose.accountsmanager.entity.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BankMapper {

    @Mapping(source = "instanceId", target = "bankId")
    BankDTO toBankDTO(Bank bank);

    Bank toBank(BankDTO bankDTO);

}