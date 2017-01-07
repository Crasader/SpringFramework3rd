package com.springframework3rd.postprocessor;

import com.springframework3rd.common.DependencyResolver;
import com.springframework3rd.common.MyApplicationContext;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DependencyResolutionBeanPostProcessor
        implements BeanPostProcessor, Ordered {
    private MyApplicationContext myApplicationContext;
    private int order;
    private static Logger logger
            = Logger.getLogger(DependencyResolutionBeanPostProcessor.class);

    public void setMyApplicationContext(MyApplicationContext myApplicationContext) {
        this.myApplicationContext = myApplicationContext;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        logger.info("postProcessBeforeInitialization method of DependencyResolutionBeanPostProcessor invoked");
        if(bean instanceof DependencyResolver) {
            ((DependencyResolver)bean).resolveDependency(myApplicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        logger.info("postProcessAfterInitialization method of DependencyResolutionBeanPostProcessor invoked");
        return bean;
    }
}
