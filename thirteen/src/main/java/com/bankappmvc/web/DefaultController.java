package com.bankappmvc.web;

import com.bankappmvc.domain.FixedDepositDetails;
import com.bankappmvc.service.FixedDepositService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fixedDeposit")
@SessionAttributes(names = {"newFixedDepositDetails", "editableFixedDepositDetails"})
public class DefaultController {
    private static Logger logger = Logger.getLogger(DefaultController.class);

    @Autowired
    private FixedDepositService fixedDepositService;

    @Autowired
    private Validator validator;

    @RequestMapping("/list")
    @ModelAttribute(name= "fdList")
    public List<FixedDepositDetails> listFixedDeposits() {
        logger.info("listFixedDeposits() methid: GEtting list of fixed deposits");
        return fixedDepositService.getFixedDeposits();
    }

    @ModelAttribute(name = "newFixedDepositDetails")
    public FixedDepositDetails getNewFixedDepositDetals() {
        FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
        fixedDepositDetails.setEmail("You must enter a valid email");
        logger.info("getNewFixedDepositDetals() method: Returning a new instance of FixedDepositDetails");
        return fixedDepositDetails;
    }

    @RequestMapping(params="fdAction=createFDForm")
    public ModelAndView showOpenFixedDepositForm() {
        FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
        fixedDepositDetails.setEmail("You must enter a valid email");
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute(fixedDepositDetails);
        return new ModelAndView("createFixedDepositForm", modelMap);
    }

    @RequestMapping(params="fdAction=create", method = RequestMethod.POST)
    public String openFixedDeposit(
            @ModelAttribute(name = "newFixedDepositDetails") FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult) {
        validator.validate(fixedDepositDetails, bindingResult);

        if(bindingResult.hasErrors()) {
            logger.info("openFixedDeposit() method: Validation errors - re-displaying form for opening a new fixed deposit");
            return "createFixedDepositForm";
        } else {
            fixedDepositService.saveFixedDeposit(fixedDepositDetails);
            logger.info("openFixedDeposit() method: Fixed deposit details successfully saved. Redirecting to show the list of fixed deposits.");
            return "redirect:/fixedDeposit/list";
        }
    }

    @RequestMapping(params = "fdAction=edit", method = RequestMethod.POST)
    public String editFixedDeposit(
            @Valid @ModelAttribute("editableFixedDepositDetails") FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult, SessionStatus sessionStatus
    ) {
        logger.info("editFixedDeposit");
        logger.info(fixedDepositDetails);
        if(bindingResult.hasErrors()) {
            logger.info("editFixedDeposit() method: Validation errors - re-displaying form for editing a fixed deposit");
            return "editFixedDepositForm";
        } else  {
            fixedDepositService.editFixedDeposit(fixedDepositDetails);
            sessionStatus.setComplete();
            logger.info("editFixedDeposit() method: Fixed deposit details successfully changed. Redirecting to show the list of fixed deposits.");
            return "redirect:/fixedDeposit/list";
        }
    }

    @RequestMapping(params = "fdAction=view", method = RequestMethod.GET)
    public ModelAndView viewFixedDepositDetails(
            @RequestParam(name = "fixedDepositId") int fixedDepositId
    ) {
        FixedDepositDetails fixedDepositDetails = fixedDepositService.getFixedDeposit(fixedDepositId);
        logger.info(fixedDepositDetails);
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("editableFixedDepositDetails", fixedDepositDetails);
        logger.info("viewFixedDepositDetails() method: Fixed deposit details loaded from data store. Showing form for editing the loaded fixed deposit.");
        return new ModelAndView("editFixedDepositForm", modelMap);
    }
}
