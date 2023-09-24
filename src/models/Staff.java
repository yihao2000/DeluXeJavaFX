package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.Connect;
import utils.Logger;

public class Staff implements Model{
	private final Connect con;
	private int id;
	private String name;
	private String email;
	private String password;
	private Company company;
	
	
	
	public Staff(int id, String name, String email, String password, Company company) {
		super();
		con = Connect.getConnection();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.company = company;
	}
	
	
	public void register() throws SQLException {
        String sql = String.format("INSERT INTO `staffs` (`CompanyID`, `StaffName`, `StaffEmail`, `StaffPassword`) VALUES (%d, '%s', '%s', '%s');", this.company.getId(), this.name,this.email, this.password);
        con.executeUpdate(sql);
        Logger.log("DB","Inserted new user to companies table");
    }


	public Staff login() {
		String sql = String.format("SELECT * FROM `staffs` WHERE `StaffEmail` ='%s' AND `StaffPassword` = '%s'", this.email, this.password);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				String retPassword = res.getString("StaffPassword");
				if(!this.password.equals(retPassword)) {
					return null;
				}
				
				int retId = res.getInt("StaffID");
				String retEmail = res.getString("StaffEmail");
				String retName = res.getString("StaffName");
				
				Logger.log("DB", "Authenticated Staff");
				return new Staff(retId, retName, retEmail, retPassword, (Company)new Company(0, "", "", "", "","").get(retId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `staffs` WHERE `StaffID` = %d", id);
		
		
		return null;
	}


	@Override
	public List<Model> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert() throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete() throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

}
