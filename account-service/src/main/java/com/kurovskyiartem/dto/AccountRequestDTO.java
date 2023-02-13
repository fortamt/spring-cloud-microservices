package com.kurovskyiartem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class AccountRequestDTO {

    private String email;
    private String name;
    private String phone;
    private List<Long> bills;
    private OffsetDateTime creationDate;
}
