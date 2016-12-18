package com.springframework3rd.postprocessor;

import com.springframework3rd.common.IInstanceValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InstanceValidationBeanPostProcessor implements BeanPostProcessor, Ordered {
    private static Logger logger = Logger.getLogger(InstanceValidationBeanPostProcessor.class);
    private int order;

    public InstanceValidationBeanPostProcessor() {
        logger.info("Created InstanceValidationBeanPostProcessor instance");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        logger.info("postProcessBeforeInitialization method invoked");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        logger.info("postProcessAfterInitialization method invoked");
        if(bean instanceof IInstanceValidator) {
            ((IInstanceValidator) bean).validateInstance();
        }
        return bean;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
