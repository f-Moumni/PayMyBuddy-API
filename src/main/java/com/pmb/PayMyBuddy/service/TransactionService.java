package com.pmb.PayMyBuddy.service;

import com.pmb.PayMyBuddy.DTO.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
@Transactional
@Slf4j
public class TransactionService {

    @Autowired
    PaymentService paymentService;
    @Autowired
    TransferService transferService;


    public Set<TransactionDTO> getAllTransactions(String email) {
        return Stream.concat(paymentService.getAllPayments(email).stream(),transferService.getAllTransfers(email).stream()
        ).collect(Collectors.toSet());
    }
}
