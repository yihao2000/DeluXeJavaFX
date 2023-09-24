package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.Connect;
import utils.Logger;

public class Internship implements Model{
	private final Connect con;
	private int id;
	private String name;
	private String desc;
	private Job job;
	
	
	
	public Internship(int id, String name, String desc, Job job) {
		super();
		con = Connect.getConnection();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.job = job;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
	
	public Job getJobFromInternshipId() {
		String sql = String.format("SELECT * FROM `internships` WHERE `InternshipID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		
		int retJobId = 0;
		try {
			if(res.next()) {
				retJobId = res.getInt("JobID");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return (Job)new Job(0, "", "", 0 , null).get(retJobId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Override
	public Model get(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM `internships` WHERE `InternshipID` = %d", id);
		
		ResultSet res = con.executeQuery(sql);
		
	
		try {
			if(res.next()) {
				int retInternshipId = res.getInt("InternshipID");
				int retJobId = res.getInt("JobID");
				String retInternshipName= res.getString("InternshipName");
				String retInternshipDesc = res.getString("InternshipDescription");
				
				
				Logger.log("DB", "Authenticated Internship");
				return new Internship(retInternshipId, retInternshipName, retInternshipDesc, (Job)new Job(0, "", "", 0, null).get(retJobId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Model> getAll() throws SQLException {
		List<Model> internshipList = new ArrayList<>();
		
		String sql = "SELECT * FROM `internships`";
		
		ResultSet res = con.executeQuery(sql);
		
		while(res.next()) {
			int retInternshipId = res.getInt("InternshipID");
			int retJobId = res.getInt("JobID");
			String retInternshipName= res.getString("InternshipName");
			String retInternshipDesc = res.getString("InternshipDescription");
			
			
			Logger.log("DB", "Authenticated Internship");
			internshipList.add(new Internship(retInternshipId, retInternshipName, retInternshipDesc, (Job)new Job(0, "", "", 0, null).get(retJobId)));
			
		}
		
		return internshipList;
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
