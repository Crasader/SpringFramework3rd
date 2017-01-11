package com.springframework3rd.dao;

import com.springframework3rd.domain.BankAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;


@Repository("bankAccountDao")
public class BankAccountDao implements IBankAccountDao {
    private SimpleJdbcInsert insertBankAccountDetail;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.insertBankAccountDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("bank_account_details")
                .usingGeneratedKeyColumns("account_id");
    }

    @Override
    public int createBankAccount(final BankAccountDetails bankAccountDetails) {
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("balance_amount", bankAccountDetails.getBalanceAmount());
        parameters.put("last_transaction_ts",
                new Date(bankAccountDetails.getLastTransactionTimestamp().getTime()));
        Number key = insertBankAccountDetail.executeAndReturnKey(parameters);
        return key.intValue();
    }

    public void subtractFromAccount(int bankAccountId, int amount) {
        jdbcTemplate.update("UPDATE bank_account_details SET " +
                "balance_amount = ? WHERE account_id = ?",
                amount, bankAccountId);
    }
}
