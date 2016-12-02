package com.springframework3rd.controller;


import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import com.springframework3rd.dao.IFixedDepositDao;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");
    }

    @Test
    public void testInstances() {
        IFixedDepositController controller1
                = (IFixedDepositController)context.getBean("controller");
        IFixedDepositController controller2
                = (IFixedDepositController)context.getBean("controller");
        assertSame("Different FixedDepositController instances",
                controller1, controller2);
    }

    @Test
    public void testReference() {
        IFixedDepositController controller
                = (IFixedDepositController)context.getBean("controller");
        IFixedDepositDao fixedDepositDao
                = controller.getFixedDepositServiceImpl().getFixedDepositDao();
        IFixedDepositDao fixedDepositDao1
                = (IFixedDepositDao)context.getBean("dao");
        assertSame("Different FixedDepositController instances",
                fixedDepositDao, fixedDepositDao1);
    }
    @Test
    public void testSingletonScope() {
        ApplicationContext anotherContext
                = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
        IFixedDepositController controller1
                = (IFixedDepositController)context.getBean("controller");
        IFixedDepositController controller2
                = (IFixedDepositController)anotherContext.getBean("controller");
        assertNotSame("Same FixedDepositController instances",
                controller1, controller2);
    }

}
