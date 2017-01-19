package com.springframework3rd.service;

import com.springframework3rd.domain.FixedDepositDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;

    FixedDepositDetails getFixedDeposit(int fixedDepositId);

    List<FixedDepositDetails> findFixedDepositsByBankAccount(int bankAccountId);

    FixedDepositDetails getFixedDepositFromCache(int fixedDepositId);
}