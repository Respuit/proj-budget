package com.budgyeti.budgyeti.controller.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.budgyeti.budgyeti.controller.dashboard.model.Budget;
import com.budgyeti.budgyeti.controller.dashboard.repository.BudgetRepository;

import jakarta.transaction.Transactional;

@Controller
public class DashboardController {
	

    @Autowired
    private BudgetRepository budgetRepository;
    
    @Transactional
    @GetMapping("/dashboard")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	List<Budget> budget = budgetRepository.findAll();
        System.out.println("Presupuestos encontrados: " + budget.size());
        model.addAttribute("budgets", budget);  
        return "dashboard/dashboard";
    }
}
