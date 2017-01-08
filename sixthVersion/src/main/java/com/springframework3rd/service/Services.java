package com.springframework3rd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Services {
    @Autowired
    @Qualifier("service")
    private Set<IMyService> services;

    public Set<IMyService> getServices() {
        return services;
    }
}
