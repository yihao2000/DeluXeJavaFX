package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.Logger;

public class Student extends Account implements Model{

	public Student(int id, String name, String email, String password,String phone, String address) {
		super(id, name, email, password, phone, address);
		// TODO Auto-generated constructor stub
	}

	public void register() throws SQLException {
        String sql = String.format("INSERT INTO `students` (`StudentName`, `StudentEmail`, `StudentPassword`, `StudentPhone`, `StudentAddress`) VALUES ('%s', '%s', '%s', '%s', '%s');", this.name,this.email, this.password, this.phone,  this.address);
        con.executeUpdate(sql);
        Logger.log("DB","Inserted new student!");
    }

	@Override
	public Account login() {
		String sql = String.format("SELECT * FROM `students` WHERE `StudentEmail` ='%s' AND `StudentPassword` = '%s'", this.email, this.password);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				String retPassword = res.getString("StudentPassword");
				if(!this.password.equals(retPassword)) {
					return null;
				}
				
				int retId = res.getInt("StudentID");
				String retEmail = res.getString("StudentEmail");
				String retName = res.getString("StudentName");
				String retPhone = res.getString("StudentPhone");
				String retAddress = res.getString("StudentAddress");
				
				Logger.log("DB", "Authenticated Student");
				return new Student(retId, retName, retEmail, retPassword, retPhone, retAddress);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `students` WHERE `StudentID` = %d", id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				
				
				int retId = res.getInt("StudentID");
				String retEmail = res.getString("StudentEmail");
				String retPassword = res.getString("StudentPassword");
				String retName = res.getString("StudentName");
				String retPhone = res.getString("StudentPhone");
				String retAddress = res.getString("StudentAddress");
				
				Logger.log("DB", "Authenticated Student");
				return new Student(retId, retName, retEmail, retPassword, retPhone, retAddress);
				
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
