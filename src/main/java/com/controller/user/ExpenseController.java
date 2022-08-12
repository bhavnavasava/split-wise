package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ExpenseBean;
import com.repository.ExpenseRepository;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	ExpenseRepository expenseRepository;

	@PostMapping("/addexpense")
	public ResponseEntity<?> addExpense(@RequestBody ExpenseBean expense){
		
		expenseRepository.save(expense);
		return ResponseEntity.ok(expense);
	}
	
	@GetMapping("/expenses")
	public ResponseEntity<?> getAllExpenses() {
		return ResponseEntity.ok(expenseRepository.findAll());
	}
	
}
