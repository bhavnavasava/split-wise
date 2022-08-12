package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "friends_table")
public class FriendsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer friendId;
	String friendName;
	Integer mobileNo;
	
	@OneToOne
	@JoinColumn(name = "userId")
	UserBean users;

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	public UserBean getUsers() {
		return users;
	}

	public void setUsers(UserBean users) {
		this.users = users;
	}
}
