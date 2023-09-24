package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.Connect;

public class StudentReport implements Model{
	private Connect con = Connect.getConnection();
	private StudentApplication application;

	
	
	public StudentReport(StudentApplication application) {
		super();
		this.application = application;
	}


	
	

	public StudentApplication getApplication() {
		return application;
	}





	public void setApplication(StudentApplication application) {
		this.application = application;
	}





	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `studentreports` WHERE `StudentApplicationID` = %d", id);
		
		ResultSet res = con.executeQuery(sql);
		if(res.next()) {
			int retApplicationId = res.getInt("StudentApplicationID");


			return new StudentReport((StudentApplication)new StudentApplication(0, null, "","",null,null).get(retApplicationId));
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
