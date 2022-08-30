package com.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class UserBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;
	String firstName;
	String email;
	String password;
	String gender;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	RoleBean role;

	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<AccountBean> accounts;
	
	@ManyToMany(mappedBy = "users")
	Set<FriendsBean> friends;

	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<ExpenseBean> expenses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<GroupBean> groups;
	
	String authToken;

	public List<AccountBean> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountBean> accounts) {
		this.accounts = accounts;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	public List<ExpenseBean> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseBean> expenses) {
		this.expenses = expenses;
	}


	public Set<FriendsBean> getFriends() {
		return friends;
	}

	public void setFriends(Set<FriendsBean> friends) {
		this.friends = friends;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	
	

	
}
