package com.springframework3rd.controller;

import com.springframework3rd.domain.FixedDepositDetails;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotSame;

public class PrototypeTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
    }

    @Test
    public void testInstance() {
        FixedDepositDetails fixedDepositDetails1
                = (FixedDepositDetails)context.getBean("fixedDepositDetails");
        FixedDepositDetails fixedDepositDetails2
                = (FixedDepositDetails)context.getBean("fixedDepositDetails");
        assertNotSame("Same FixedDepositDetails instances",
                fixedDepositDetails1, fixedDepositDetails2);
    }
}
