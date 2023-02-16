package com.kurovskyiartem.controller;

import com.kurovskyiartem.dto.DepositRequestDTO;
import com.kurovskyiartem.dto.DepositResponseDTO;
import com.kurovskyiartem.service.DepositService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @PostMapping("/deposits")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO depositRequestDTO) {
        return depositService.deposit(
                depositRequestDTO.getAccountId(),
                depositRequestDTO.getBillId(),
                depositRequestDTO.getAmount());
    }
}
