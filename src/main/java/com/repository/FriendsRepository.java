package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.FriendsBean;

@Repository
public interface FriendsRepository extends CrudRepository<FriendsBean , Integer> {

	List<FriendsBean>  findAll();
}
