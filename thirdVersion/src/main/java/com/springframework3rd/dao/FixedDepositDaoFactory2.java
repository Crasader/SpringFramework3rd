package com.springframework3rd.dao;

/**
 * Instance factory
 */
public class FixedDepositDaoFactory2 {
    public FixedDepositDaoFactory2() {}

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
