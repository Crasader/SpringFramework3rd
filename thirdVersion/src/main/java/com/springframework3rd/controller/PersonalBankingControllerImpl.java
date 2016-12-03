package com.springframework3rd.controller;

import com.springframework3rd.domain.BankStatement;
import com.springframework3rd.service.IPersonalBankingService;

/**
 * Created by Dimon on 04.12.2016.
 */
public class PersonalBankingControllerImpl implements IPersonalBankingController {
    private IPersonalBankingService personalBankingService;

    public void setPersonalBankingService(
            IPersonalBankingService personalBankingService) {
        this.personalBankingService = personalBankingService;
    }

    @Override
    public BankStatement getMiniStatement() {
        return personalBankingService.getMiniStatement();
    }
}
