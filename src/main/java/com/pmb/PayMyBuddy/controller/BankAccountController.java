package com.pmb.PayMyBuddy.controller;


import com.pmb.PayMyBuddy.DTO.BankAccountDTO;
import com.pmb.PayMyBuddy.DTO.Response;
import com.pmb.PayMyBuddy.exceptions.DataNotFoundException;

import com.pmb.PayMyBuddy.security.PrincipalUser;
import com.pmb.PayMyBuddy.service.IBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * BankAccountController class allows to do CRUD operations for BankAccount
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bankAccount")
public class BankAccountController {
    @Autowired
    IBankAccountService bankAccountService;

    /**
     * the end point to get BankAccount
     * @return response with BankAccount
     * @throws DataNotFoundException
     */
    @GetMapping
    public ResponseEntity<Response> getBankAccount() throws DataNotFoundException {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(Map.of("bankAccount", bankAccountService.getBankAccount()))
                        .message("Bank Account retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    /**
     * the end point to save new BankAccount
     * @param bAccountToAdd (per of swift and Iban)
     * @return response with true if saved
     */
    @PostMapping
    public ResponseEntity<Response> saveBankAccount(@RequestBody BankAccountDTO bAccountToAdd) {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(Map.of("bankAccount", bankAccountService.addBankAccount(bAccountToAdd)))
                        .message("Bank Account saved")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build());
    }

    /**
     * end point to update a given BankAccount
     * @param bAccount (per of swift and Iban)
     * @return response with true is BankAccount Saved
     */
    @PutMapping
    public ResponseEntity<Response> updateBankAccount(@RequestBody BankAccountDTO bAccount) {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(Map.of("bankAccount", bankAccountService.updateBankAccount(bAccount)))
                        .message("Bank Account updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
}
