package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.Logger;

public class User extends Account implements Model{

	public User(int id, String name, String email, String password, String phone, String address) {
		super(id, name, email, password,phone ,address);
		// TODO Auto-generated constructor stub
	}
	
	public void register() throws SQLException {
        String sql = String.format("INSERT INTO `users` (`UserName`, `UserEmail`, `UserPassword`, `UserPhone`, `UserAddress`) VALUES ('%s', '%s', '%s', '%s', '%s');", this.name,this.email, this.password, this.phone,  this.address);
        con.executeUpdate(sql);
        Logger.log("DB","Inserted new user to companies table");
    }

	@Override
	public Account login() {
		String sql = String.format("SELECT * FROM `users` WHERE `UserEmail` ='%s' AND `UserPassword` = '%s'", this.email, this.password);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				String retPassword = res.getString("UserPassword");
				if(!this.password.equals(retPassword)) {
					return null;
				}
				
				int retId = res.getInt("UserID");
				String retEmail = res.getString("UserEmail");
				String retName = res.getString("UserName");
				String retPhone = res.getString("UserPhone");
				String retAddress = res.getString("UserAddress");
				
				Logger.log("DB", "Authenticated User");
				return new User(retId, retName, retEmail, retPassword, retPhone, retAddress);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `users` WHERE `UserID` = %d", id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				
				
				int retId = res.getInt("UserID");
				String retEmail = res.getString("UserEmail");
				String retPassword = res.getString("UserPassword");
				String retName = res.getString("UserName");
				String retPhone = res.getString("UserPhone");
				String retAddress = res.getString("UserAddress");
				
				Logger.log("DB", "Authenticated User");
				return new User(retId, retName, retEmail, retPassword, retPhone, retAddress);
				
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
