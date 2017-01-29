package com.springframework3rd.service;


import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import com.springframework3rd.domain.QFixedDepositDetails;

@Service(value="fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {
    private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);


    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;


    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        logger.info("createFixedDeposit method invoked");
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        logger.info("getFixedDeposit method invoked with fixedDepositId "
                + fixedDepositId);
        return myFixedDepositDao.getFixedDeposit(fixedDepositId);
    }

    @Override
    public List<FixedDepositDetails> getFixedDeposits() {
       return myFixedDepositDao.getFixedDeposits();
    }
}