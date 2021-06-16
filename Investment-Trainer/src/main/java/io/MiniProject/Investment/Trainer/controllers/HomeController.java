package io.MiniProject.Investment.Trainer.controllers;

import io.MiniProject.Investment.Trainer.services.InvestmentTrainerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    InvestmentTrainerDataService investmentTrainerDataService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("StocksStats",investmentTrainerDataService.getCompanyStats());
        return "home";
    }
}
