package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.Connect;
import utils.Logger;

public class Report implements Model{
	private Connect con = Connect.getConnection();
	private Application application;

	
	
	public Report(Application application) {
		super();
		this.application = application;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	

	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `reports` WHERE `ApplicationID` = %d", id);
		
		ResultSet res = con.executeQuery(sql);
		if(res.next()) {
			int retApplicationId = res.getInt("ApplicationID");


			return new Report((Application)new Application(0, null, "","",null,null).getApplicationByApplicationId(retApplicationId));
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
