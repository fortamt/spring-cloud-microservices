package com.kurovskyiartem.controller;

import com.kurovskyiartem.dto.AccountRequestDTO;
import com.kurovskyiartem.dto.AccountResponseDTO;
import com.kurovskyiartem.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccount(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping("/")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(
                accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(),
                accountRequestDTO.getBills());
    }

    @PutMapping("/{accountId}")
    public AccountResponseDTO updateAccount(@PathVariable Long accountId,
                                            @RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDTO(accountService.updateAccount(
                accountId,
                accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(),
                accountRequestDTO.getBills()
        ));
    }

    @DeleteMapping("/{accountId}")
    public AccountResponseDTO deleteAccount(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.deleteAccount(accountId));
    }
}
