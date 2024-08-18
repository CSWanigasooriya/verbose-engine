package com.engine.verbose.accountsmanager.controller;

import com.engine.verbose.accountsmanager.dto.BankDTO;
import com.engine.verbose.accountsmanager.service.BankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/banks")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    // Endpoint to create a new bank
    @PostMapping
    public ResponseEntity<BankDTO> createBank(@Valid @RequestBody BankDTO bankDTO) {
        BankDTO createdBank = bankService.createBank(bankDTO);
        return new ResponseEntity<>(createdBank, HttpStatus.CREATED);
    }

    // Endpoint to get all banks with pagination
    @GetMapping
    public ResponseEntity<Page<BankDTO>> getAllBanks(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<BankDTO> banks = bankService.getAllBanks(page, size);
        return ResponseEntity.ok(banks);
    }

    @GetMapping("/{bankId}")
    public ResponseEntity<BankDTO> getBankById(@PathVariable UUID bankId) {
        BankDTO bankDTO = bankService.getBankById(bankId);
        return ResponseEntity.ok(bankDTO);
    }

    @PatchMapping("/{bankId}")
    public ResponseEntity<BankDTO> patchBank(@PathVariable UUID bankId, @RequestBody BankDTO bankDTO) {
        BankDTO updatedBank = bankService.patchBank(bankId, bankDTO);
        return ResponseEntity.ok(updatedBank);
    }

    @DeleteMapping("/{bankId}")
    public ResponseEntity<Void> deleteBank(@PathVariable UUID bankId) {
        bankService.deleteBank(bankId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}