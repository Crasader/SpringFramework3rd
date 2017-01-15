package com.springframework3rd.repository;

import com.springframework3rd.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositRepositoryCustom {
    List<FixedDepositDetails> findByTenure(int tenure);
}
