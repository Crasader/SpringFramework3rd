package com.springframework3rd.dao;

public class FixedDepositDaoFactory {
    private FixedDepositDaoFactory() {}

    public static IFixedDepositDao getFixedDepositDao(String daoType) {
        if("jdbc".equalsIgnoreCase(daoType)) {
            return new FixedDepositJdbcDao();
        }
        if("hibernate".equalsIgnoreCase(daoType)) {
            return new FixedDepositHibernateDao();
        }
        return null;
    }
}
