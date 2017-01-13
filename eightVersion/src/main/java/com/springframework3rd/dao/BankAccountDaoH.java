package com.springframework3rd.dao;

import com.springframework3rd.domain.BankAccountDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("bankAccountDaoH")
public class BankAccountDaoH implements IBankAccountDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int createBankAccount(final BankAccountDetails bankAccountDetails) {
        System.out.println("Hibernate");
        sessionFactory.getCurrentSession().save(bankAccountDetails);
        return bankAccountDetails.getAccountId();
    }

    @Override
    public void subtractFromAccount(int bankAccountId, int amount) {
        String hql = "from BankAccountDetails as bankAccountDetails " +
                "where bankAccountDetails.accountId = " + bankAccountId;
        BankAccountDetails bankAccountDetails = (BankAccountDetails)sessionFactory
                .getCurrentSession().createQuery(hql).uniqueResult();
        bankAccountDetails.setBalanceAmount(bankAccountDetails.getBalanceAmount() - amount);
        sessionFactory.getCurrentSession().merge(bankAccountDetails);
    }

}
