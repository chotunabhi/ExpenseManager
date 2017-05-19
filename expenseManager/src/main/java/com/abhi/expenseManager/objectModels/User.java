package com.abhi.expenseManager.objectModels;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author abhi
 */
@Entity(name="user_details")
@XmlRootElement(name="user")
@NamedQuery(name="byId",query="select u.emailId,u.phoneNumber,u.age,u.gender from user_details u where u.emailId =:emailId and u.active=true")
public class User {
	private String name;
	@Id
	@Column(name="email_id")
	private String emailId;
	private String password;
	@Column(name="phone_number")
	private String phoneNumber;
	private int age;
	private String gender;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="primary_account_id",foreignKey=@ForeignKey(name="FK_account_id"))
	private Account primaryAccount;
	@Column(name="is_active")
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public Account getPrimaryAccount() {
		return primaryAccount;
	}
	public void setPrimaryAccount(Account primaryAccount) {
		this.primaryAccount = primaryAccount;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString(){
		return this.emailId+" "+this.age+" "+this.gender;
	}
}
