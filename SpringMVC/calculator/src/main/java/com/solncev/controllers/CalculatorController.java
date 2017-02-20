package com.solncev.controllers;

import com.solncev.enums.Operator;
import com.solncev.services.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Марат on 19.02.2017.
 */
@Controller
public class CalculatorController {
    CalculatorService calculatorService = new CalculatorService();

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String getIndexPage() {
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String getAnswerPage(@RequestParam("first") String first,
                                @RequestParam("second") String second,
                                @RequestParam("operator") String operator,
                                Model model) {
        model.addAttribute("answer", calculatorService.getResultOfCalculation(Integer.parseInt(first),
                Integer.parseInt(second),
                Operator.valueOf(operator)));
        return "answer";
    }
}
