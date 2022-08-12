package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer acId;
	String acType;
		
	@OneToOne
	@JoinColumn(name = "userId")
	UserBean users;

	public Integer getAcId() {
		return acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public UserBean getUsers() {
		return users;
	}

	public void setUsers(UserBean users) {
		this.users = users;
	}
}
