package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class ExpenseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Integer expenseId;
	 String expense;
	 String date;
	 String time;
	 String category;
	 
	 @OneToOne
		@JoinColumn(name = "userId")
		UserBean users;
	 
	 
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public UserBean getUsers() {
		return users;
	}
	public void setUsers(UserBean users) {
		this.users = users;
	}
	 
}
