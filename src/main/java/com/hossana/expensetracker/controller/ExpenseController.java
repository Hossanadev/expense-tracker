package com.hossana.expensetracker.controller;

import com.hossana.expensetracker.dto.ExpenseRequest;
import com.hossana.expensetracker.entity.Expense;
import com.hossana.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;
    @PostMapping("/create")
    public String createExpense(@RequestBody ExpenseRequest expenseRequest) {
        if (expenseRequest.getCategory().isEmpty()) {
            return "Category is required.";
        }
        if (expenseRequest.getAmount() == null) {
            return "Amount is required.";
        }
        if (expenseRequest.getStatus().isEmpty()) {
            return "Expense is required.";
        }
        if (expenseRequest.getDescription().isEmpty()) {
            return "Description is required.";
        }
        Expense expense = Expense.builder()
                .category(expenseRequest.getCategory())
                .status(expenseRequest.getStatus())
                .amount(expenseRequest.getAmount())
                .description(expenseRequest.getDescription())
                .build();
        expenseRepository.save(expense);
        return "Expense created successfully.";
    }
}
