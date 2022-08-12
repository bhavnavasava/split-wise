package com.controller.public_api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.repository.AccountRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public_api")
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/account")
	public ResponseEntity<?> addAccount(@RequestBody AccountBean account) {
		try {
			Optional<UserBean> users=userRepository.findById(1);
			account.setUsers(users.get());
			accountRepository.save(account);
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(account);
	}

	@DeleteMapping("/account/{acId}")
	public ResponseEntity<?> removeAccount(@PathVariable("acId") Integer acId) {
		try {
			accountRepository.deleteById(acId);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok("Account Removed");
	}

	@GetMapping("/account")
	public ResponseEntity<?> getAllAccounts() {
		return ResponseEntity.ok(accountRepository.findAll());
	}
	
}
