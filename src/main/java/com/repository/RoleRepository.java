package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;


@Repository
public interface RoleRepository extends CrudRepository<RoleBean, Integer> {
	List<RoleBean> findAll();

	RoleBean findByRoleName(String roleName);
	
	//@Query(value="select * from role where role_id=?",nativeQuery=true)
	
	
}