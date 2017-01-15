package com.springframework3rd.repository;

import com.springframework3rd.domain.BankAccountDetails;
import com.springframework3rd.domain.FixedDepositDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BankAccountRepository
        extends JpaRepository<BankAccountDetails, Integer>/*,
        QueryDslPredicateExecutor<FixedDepositDetails>,
        BankAccountRepositoryCustom*/ {

}
