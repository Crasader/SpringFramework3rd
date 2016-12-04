package com.springframework3rd.controller;


import com.springframework3rd.base.ServiceTemplate;
import com.springframework3rd.domain.Request;

public class UserRequestControllerImpl implements IUserRequestController{
    private ServiceTemplate serviceTemplate;

    public UserRequestControllerImpl(ServiceTemplate serviceTemplate) {
        this.serviceTemplate = serviceTemplate;
    }

    @Override
    public void submitRequest(Request request) {
        serviceTemplate.getJmsMessageSender();
    }

}
