package com.kurovskyiartem.controller;

import com.kurovskyiartem.dto.BillRequestDTO;
import com.kurovskyiartem.dto.BillResponseDTO;
import com.kurovskyiartem.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/{billId}")
    public BillResponseDTO getBillById(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(
                billRequestDTO.getAccountId(),
                billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(),
                billRequestDTO.getOverdraftEnabled());
    }

    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId,
                                     @RequestBody BillRequestDTO billRequestDTO) {
        return new BillResponseDTO(billService.updateBill(
                billId,
                billRequestDTO.getAccountId(),
                billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(),
                billRequestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.deleteBill(billId));
    }

    @GetMapping("/account/{accountId}")
    public List<BillResponseDTO> getBillsByAccountId(@PathVariable Long accountId) {
        return billService.getBillsByAccountId(accountId).stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());
    }
}
