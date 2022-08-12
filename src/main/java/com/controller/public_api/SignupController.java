package com.controller.public_api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.AccountRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class SignupController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPassword;

	@PostMapping("/signup")
	public ResponseEntity<ResponseBean<UserBean>> addUser(@RequestBody UserBean user) {
		
		UserBean dbUser=userRepository.findByEmail(user.getEmail());
		ResponseBean<UserBean> res = new ResponseBean<>();
		if(dbUser==null) {
			
			RoleBean role = roleRepository.findByRoleName("user");
			user.setRole(role);
			String encPassword= bCryptPassword.encode(user.getPassword());
			user.setPassword(encPassword);
			userRepository.save(user);
			res.setData(user);
			res.setMsg("sign up done");
			return ResponseEntity.ok(res);
		}else {
			res.setMsg("Duplicate Email");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ResponseBean<UserBean>> removeUser(@PathVariable("userId") Integer userId) {
			UserBean user=userRepository.findByUserId(userId);
			ResponseBean<UserBean> res = new ResponseBean<>();

			if(user==null) {
				res.setMsg("invalid user ");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
			}else {
				userRepository.deleteById(userId);
				res.setData(user);
				res.setMsg("User removed");
				return ResponseEntity.ok(res);
			}		
	}

	@GetMapping("/user")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok(userRepository.findAll());
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginBean login) {
		UserBean user = userRepository.findByEmail(login.getEmail());

		if (user == null || !bCryptPassword.matches(login.getPassword(), user.getPassword())) {
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		} else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(user);
			res.setMsg("Login done...");
			return ResponseEntity.ok(res);
		}
	}
}
