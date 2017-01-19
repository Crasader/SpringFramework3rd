package com.springframework3rd.jms;

import com.springframework3rd.dao.BankAccountDao;
import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class FixedDepositMessageListener implements MessageListener {
    private static Logger logger = Logger.getLogger(FixedDepositMessageListener.class);

    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao fixedDepositDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Transactional(transactionManager="dbTxManager")
    public int createFixedDeposit(FixedDepositDetails fdd) {
        bankAccountDao.subtractFromAccount(fdd.getBankAccountId(), fdd.getFdAmount());
        return fixedDepositDao.createFixedDeposit(fdd);
    }

    @Override
    public void onMessage(Message message) {
        logger.info("FixedDepositMessageListener onMessage() invoked");
        ObjectMessage objectMessage = (ObjectMessage)message;
        FixedDepositDetails fdd = null;
        try {
            fdd = (FixedDepositDetails)objectMessage.getObject();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        if(fdd != null)
            createFixedDeposit(fdd);
    }
}
