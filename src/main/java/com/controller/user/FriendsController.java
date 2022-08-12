package com.controller.user;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.FriendsBean;
import com.bean.UserBean;
import com.repository.FriendsRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/friends")
public class FriendsController {
	
	@Autowired
	FriendsRepository friendsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/addfriend")
	public ResponseEntity<?> addFriend(@RequestBody FriendsBean friend){
		
		Optional<UserBean> users=userRepository.findById(1);
		friend.setUsers(users.get());
		friendsRepository.save(friend);
		return ResponseEntity.ok(friend);
	}
	
	@GetMapping("/friends")
	public ResponseEntity<?> getAllFriends(FriendsBean friends){
		
		List<FriendsBean> friend =friendsRepository.findAll();
		return ResponseEntity.ok(friend);
	}

}
