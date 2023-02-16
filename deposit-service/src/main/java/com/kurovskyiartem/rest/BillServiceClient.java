package com.kurovskyiartem.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bill-service")
public interface BillServiceClient {

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    BillResponseDTO getBillById(@PathVariable Long billId);

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    BillResponseDTO updateBill(@PathVariable Long billId,
                               @RequestBody BillRequestDTO billRequestDTO);

    @RequestMapping(value = "/account/{accountId}" , method = RequestMethod.GET)
    List<BillResponseDTO> getBillsByAccountId(@PathVariable Long accountId);
}
