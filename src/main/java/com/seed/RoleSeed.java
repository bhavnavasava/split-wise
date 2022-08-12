package com.seed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.RoleBean;
import com.repository.RoleRepository;

@Component
public class RoleSeed {

	@Autowired
	RoleRepository roleRepository;

	@PostConstruct
	void createRoles() {

		RoleBean role = roleRepository.findByRoleName("user");
		if (role == null) {
			RoleBean role1 = new RoleBean();
			role1.setRoleName("user");
			roleRepository.save(role1);

			RoleBean role2 = new RoleBean();
			role2.setRoleName("admin");
			roleRepository.save(role2);
			System.out.println("Role Added successfully");

		} else {
			System.out.println("Role Already Added");
		}
	}

}
