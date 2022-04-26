//IT20270360
package com.paf.model;

public class User {

	private String Id;
	private String Name;
	private String Address;
	private String PhoneNo;
	private String Email;
	private String AccountNo;

	public User() {

	}

	public User(String Id, String Name, String Address, String PhoneNo, String Email, String AccountNo) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.Address = Address;
		this.PhoneNo = PhoneNo;
		this.Email = Email;
		this.AccountNo = AccountNo;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String PhoneNo) {
		this.PhoneNo = PhoneNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String AccountNo) {
		this.AccountNo = AccountNo;
	}

}
