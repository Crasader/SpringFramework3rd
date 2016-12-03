package com.springframework3rd.dao;

/**
 * Instance factory
 */
public class FixedDepositDaoFactory3 {
    public FixedDepositDaoFactory3() {}

    public IFixedDepositDao getFixedDepositDao(String daoType) {
        if("jdbc".equalsIgnoreCase(daoType)) {
            return new FixedDepositJdbcDao();
        }
        if("hibernate".equalsIgnoreCase(daoType)) {
            return new FixedDepositHibernateDao();
        }
        return null;
    }
}
