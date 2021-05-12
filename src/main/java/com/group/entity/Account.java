package com.group.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
//@Data: This annotation is a shortcut annotation and bundles @ToString, @Getter, @Setter, @EqualsAndHashCode and @RequiredArgsConstructor
public class Account {
	@Id
	@GeneratedValue
	@Column(name = "accountid")
	private int accountId;
	@Column(name = "accountname")
	private String accountName;
	@Column(name = "description")
	private String description;
	@Column(name = "username")
	private String userName;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AccountStatus status;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}
}
