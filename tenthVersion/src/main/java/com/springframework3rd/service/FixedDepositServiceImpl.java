package com.springframework3rd.service;


import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;
import java.util.List;

//import com.springframework3rd.domain.QFixedDepositDetails;

@Service(value="fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {
    private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;


    @Override
    @Transactional(transactionManager = "jmsTxManager")
    @CacheEvict(cacheNames = {"fixedDepositList"}, allEntries = true, beforeInvocation = true)
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        logger.info("createFixedDeposit method invoked");
        jmsTemplate.send("emailQueueDestination", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(fdd.getEmail());
                return textMessage;
            }
        });

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage();
                message.setObject(fdd);
                return message;
            }
        });
    }

    @Override
    @CachePut(cacheNames = { "fixedDeposit" }, key = "#fixedDepositId")
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        logger.info("getFixedDeposit method invoked with fixedDepositId "
                + fixedDepositId);
        return myFixedDepositDao.getFixedDeposit(fixedDepositId);
    }

    @Override
    @Cacheable(cacheNames = { "fixedDeposit" }, key = "#fixedDepositId")
    public FixedDepositDetails getFixedDepositFromCache(int fixedDepositId) {
        logger.info("getFixedDepositFromCache method invoked with fixedDepositId "
                + fixedDepositId);
        throw new RuntimeException(
                "This method throws exception because FixedDepositDetails object must come from the cache");
    }

    @Cacheable(cacheNames = { "fixedDepositList" })
    public List<FixedDepositDetails> findFixedDepositsByBankAccount(
            int bankAccountId) {
        logger.info("findFixedDepositsByBankAccount method invoked");
        return myFixedDepositDao.findFixedDepositsByBankAccount(bankAccountId);
    }
}