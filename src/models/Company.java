package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.Logger;

public class Company extends Account implements Model{

	public Company(int id, String name, String email, String password, String phone, String address) {
		super(id, name, email, password,phone, address);
	}


	@Override
	public Account login() {
		String sql = String.format("SELECT * FROM `companies` WHERE `CompanyEmail` ='%s' AND `CompanyPassword` = '%s'", this.email, this.password);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				String retPassword = res.getString("CompanyPassword");
				if(!this.password.equals(retPassword)) {
					return null;
				}
				
				int retId = res.getInt("CompanyID");
				String retEmail = res.getString("CompanyEmail");
				String retName = res.getString("CompanyName");
				String retPhone = res.getString("CompanyPhone");
				String retAddress = res.getString("CompanyAddress");
				
				Logger.log("DB", "Authenticated Company");
				return new Company(retId, retName, retEmail, retPassword, retPhone, retAddress);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	


	@Override
	public Model get(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM `companies` WHERE `CompanyID` = %d",id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				int retId = res.getInt("CompanyID");
				String retEmail = res.getString("CompanyEmail");
				String retName = res.getString("CompanyName");
				String retPassword = res.getString("CompanyPassword");
				String retPhone = res.getString("CompanyPhone");
				String retAddress = res.getString("CompanyAddress");
				
				Logger.log("DB", "Authenticated Company");
				return new Company(retId, retName, retEmail, retPassword, retPhone, retAddress);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		 String sql = String.format("INSERT INTO `companies` (`CompanyName`, `CompanyEmail`, `CompanyPassword`, `CompanyPhone`, `CompanyAddress`) VALUES ('%s', '%s', '%s', '%s', '%s');", this.name,this.email, this.password, this.phone,  this.address);
	       con.executeUpdate(sql);
	        Logger.log("DB","Inserted new company!");
		
	}

	@Override
	public void delete() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void register() throws SQLException {
		 String sql = String.format("INSERT INTO `companies` (`CompanyID`, `CompanyName`, `CompanyEmail`, `CompanyPassword`, `CompanyPhone`, `CompanyAddress`) VALUES (%d, '%s', '%s', '%s', '%s', '%s');", this.id,this.name, this.email, this.password,  this.phone, this.address);
	        con.executeUpdate(sql);
	        Logger.log("DB","Inserted new user to companies table");
		
	}
	
	
	
	
	
	
	
}