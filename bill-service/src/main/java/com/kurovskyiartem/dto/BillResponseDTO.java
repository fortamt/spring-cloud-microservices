package com.kurovskyiartem.dto;

import com.kurovskyiartem.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class BillResponseDTO {

    private Long billId;
    private Long accountId;
    private BigDecimal amount;
    private Boolean isDefault;
    private OffsetDateTime offsetDateTime;
    private Boolean overdraftEnabled;

    public BillResponseDTO(Bill bill) {
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getIsDefault();
        offsetDateTime = bill.getOffsetDateTime();
        overdraftEnabled = bill.getOverdraftEnabled();
    }
}
