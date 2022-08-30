package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.repository.ExpenseRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class ExpenseController {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/addexpense")
	public ResponseEntity<?> addExpense(@RequestBody ExpenseBean expense){
		
		UserBean users=userRepository.findByUserId(1);
		expense.setUsers(users);
		expenseRepository.save(expense);
		return ResponseEntity.ok(expense);
	}
	
	@GetMapping("/expenses")
	public ResponseEntity<?> getAllExpenses() {
		return ResponseEntity.ok(expenseRepository.findAll());
	}
}
