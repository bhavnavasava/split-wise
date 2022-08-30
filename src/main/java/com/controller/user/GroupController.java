package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.GroupBean;
import com.bean.UserBean;
import com.repository.GroupRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class GroupController {
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/addgroup")
	public ResponseEntity<?> addGroup(@RequestBody GroupBean group ){
		UserBean user= userRepository.findByUserId(1);
		group.setUsers(user);
		groupRepository.save(group);
		
		return ResponseEntity.ok(group);
	}
	
	
	@GetMapping("/allgroups")
	public ResponseEntity<?> getAllGroups(){
		return ResponseEntity.ok(groupRepository.findAll());
	}
}
