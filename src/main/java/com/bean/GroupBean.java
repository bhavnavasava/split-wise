package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class GroupBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer groupId;
	String groupName;
	

	@OneToOne
	@JoinColumn(name = "userId")
	UserBean users;
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public UserBean getUsers() {
		return users;
	}
	public void setUsers(UserBean users) {
		this.users = users;
	}
	
}
