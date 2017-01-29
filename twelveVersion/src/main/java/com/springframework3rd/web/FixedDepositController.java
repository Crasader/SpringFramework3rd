package com.springframework3rd.web;

import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/fixedDeposit")
public class FixedDepositController {
    @Autowired
    private FixedDepositService fixedDepositService;

    @RequestMapping(path="/list", method = RequestMethod.GET)
    public ModelAndView listFixedDeposits() {
        Map<String, List<FixedDepositDetails>> modelData = new HashMap<String, List<FixedDepositDetails>>();
        modelData.put("fdList", fixedDepositService.getFixedDeposits());
        return new ModelAndView("fixedDepositList", modelData);
    }

    @RequestMapping("/sayhello")
    public ModelAndView sayHello() {
        Map<String, String> modelData = new HashMap<>();
        modelData.put("msg", "Hello world!!");
        return new ModelAndView("helloworld", modelData);
    }
}
