package models;

import java.sql.SQLException;

import utils.Connect;

public abstract class Account {
	protected final Connect con;
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected String phone;
	protected String address;
	
	
	
	public Account(int id, String name, String email, String password,  String phone, String address) {
		
		super();
		this.con = Connect.getConnection();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public abstract void register() throws SQLException;
	public abstract Account login();
	
	


	

}
