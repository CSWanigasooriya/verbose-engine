package com.engine.verbose.accountsmanager.service;

import com.engine.verbose.accountsmanager.dto.BankDTO;
import com.engine.verbose.accountsmanager.entity.Bank;
import com.engine.verbose.accountsmanager.mapper.BankMapper;
import com.engine.verbose.accountsmanager.repository.BankRepository;
import com.engine.verbose.accountsmanager.util.BeanUtilsHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankService {
    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    @Autowired
    public BankService(BankRepository bankRepository, BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }

    // Method to create a new bank
    public BankDTO createBank(BankDTO bankDTO) {
        Bank bank = bankMapper.toBank(bankDTO);
        Bank savedBank = bankRepository.save(bank);
        return bankMapper.toBankDTO(savedBank);
    }

    // Method to get all banks with pagination
    public Page<BankDTO> getAllBanks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Bank> bankPage = bankRepository.findAll(pageable);
        return bankPage.map(bankMapper::toBankDTO);
    }

    public BankDTO getBankById(UUID bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> new EntityNotFoundException("Bank not found with id %s".formatted(bankId)));
        return bankMapper.toBankDTO(bank);
    }

    public BankDTO patchBank(UUID bankId, BankDTO bankDTO) {
        Bank existingBank = bankRepository.findById(bankId).orElseThrow(() -> new EntityNotFoundException("Bank not found with id %s".formatted(bankId)));

        // Use the utility class to copy non-null properties
        BeanUtilsHelper.copyNonNullProperties(bankDTO, existingBank);

        Bank updatedBank = bankRepository.save(existingBank);
        return bankMapper.toBankDTO(updatedBank);
    }

    public void deleteBank(UUID bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> new EntityNotFoundException("Bank not found with id %s".formatted(bankId)));

        bankRepository.delete(bank);
    }

}