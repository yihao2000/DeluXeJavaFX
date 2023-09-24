package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import utils.Connect;
import utils.Logger;

public class Application implements Model{
	private static final Connect con = Connect.getConnection();
	private int id;
	private Timestamp date;
	private String cvDesc;
	private String transcriptDesc;
	private Job job;
	private User user;
	
	
	public Application(int id, Timestamp date, String cvDesc, String transcriptDesc, Job job, User user) {
		super();
		this.id = id;
		this.date = date;
		this.cvDesc = cvDesc;
		this.transcriptDesc = transcriptDesc;
		this.job = job;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getCvDesc() {
		return cvDesc;
	}
	public void setCvDesc(String cvDesc) {
		this.cvDesc = cvDesc;
	}
	public String getTranscriptDesc() {
		return transcriptDesc;
	}
	public void setTranscriptDesc(String transcriptDesc) {
		this.transcriptDesc = transcriptDesc;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void insertAcceptanceReport() {
		String sql2 = String.format("INSERT INTO `reports` VALUES (%d)", this.id);
		con.executeUpdate(sql2);
		Logger.log("DB", "Regular Report successfully inserted!");
	}
	
	public static ArrayList<Application> getStudentApplicationFromCurrentCompany() throws SQLException{
		String sql1 = String.format("SELECT * FROM `jobs` WHERE `CompanyID` = %d", ((Company)Main.currModel).getId());
		ArrayList<Integer> jobIdList = new ArrayList<>();
		ArrayList<Application> applicationList = new ArrayList<>();
		
		ResultSet res1 = con.executeQuery(sql1);
		
		while(res1.next()) {
			int retJobId = res1.getInt("JobID");
			
			jobIdList.add(retJobId);
		}
		for (Integer num : jobIdList) {
			Logger.log("Test", num+"");
		}
		
		for (Integer integer : jobIdList) {
			String sql = String.format("SELECT * FROM `studentapplications` WHERE `JobID` = %d", integer);
			
			
			 try (ResultSet res = con.executeQuery(sql)) {
		            while (res.next()) {
		                int retApplicationId = res.getInt("ApplicationID");
		                int retUserId = res.getInt("UserID");
		                int retJobId = res.getInt("JobID");
		                Timestamp retApplicationDate = res.getTimestamp("ApplicationDate");
						String retCvDesc = res.getString("CVDescription");
						String retTranscriptDesc = res.getString("TranscriptDescription");
						
				
						applicationList.add(new Application(retApplicationId, retApplicationDate,  retCvDesc, retTranscriptDesc, (Job)new Job(0, "", "", 0, null).get(retJobId), (User)new User(0, "", "", "", "", "").get(retUserId)));					
		            }
		        }
		}
		
	
		
		
	        return applicationList;
		
	}
	
	public static ArrayList<Application> getApplicationFromCurrentCompany() throws SQLException{
		String sql1 = String.format("SELECT * FROM `jobs` WHERE `CompanyID` = %d", ((Company)Main.currModel).getId());
		ArrayList<Integer> jobIdList = new ArrayList<>();
		ArrayList<Application> applicationList = new ArrayList<>();
		
		ResultSet res1 = con.executeQuery(sql1);
		
		while(res1.next()) {
			int retJobId = res1.getInt("JobID");
			
			jobIdList.add(retJobId);
		}
		for (Integer num : jobIdList) {
			Logger.log("Test", num+"");
		}
		
		for (Integer integer : jobIdList) {
			String sql = String.format("SELECT * FROM `applications` WHERE `JobID` = %d", integer);
			
			
			 try (ResultSet res = con.executeQuery(sql)) {
		            while (res.next()) {
		                int retApplicationId = res.getInt("ApplicationID");
		                int retUserId = res.getInt("UserID");
		                int retJobId = res.getInt("JobID");
		                Timestamp retApplicationDate = res.getTimestamp("ApplicationDate");
						String retCvDesc = res.getString("CVDescription");
						String retTranscriptDesc = res.getString("TranscriptDescription");
						
				
						applicationList.add(new Application(retApplicationId, retApplicationDate,  retCvDesc, retTranscriptDesc, (Job)new Job(0, "", "", 0, null).get(retJobId), (User)new User(0, "", "", "", "", "").get(retUserId)));					
		            }
		        }
		}
		
	
		
		
	        return applicationList;
	}
	
	public Report getReportFromApplicationId() {
		String sql = String.format("SELECT * FROM `reports` WHERE `ApplicationID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				int retApplicationId = res.getInt("ApplicationID");
				return (Report)new Report(null).get(retApplicationId);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public static ArrayList<Application> getApplicationFromJobAndUserId(int userId, int jobId) throws SQLException {
		String sql = String.format("SELECT * FROM `applications` WHERE `UserID` = %d ", userId);
		ArrayList<Application> applicationList = new ArrayList<>();
		
		 try (ResultSet res = con.executeQuery(sql)) {
	            while (res.next()) {
	                int retApplicationId = res.getInt("ApplicationID");
	                int retUserId = res.getInt("UserID");
	                int retJobId = res.getInt("JobID");
	                Timestamp retApplicationDate = res.getTimestamp("ApplicationDate");
					String retCvDesc = res.getString("CVDescription");
					String retTranscriptDesc = res.getString("TranscriptDescription");
					
			
					applicationList.add(new Application(retApplicationId, retApplicationDate,  retCvDesc, retTranscriptDesc, (Job)new Job(0, "", "", 0, null).get(retJobId), (User)Main.currModel));					
	            }
	        }
	        return applicationList;
	}
	
	
	 public static ArrayList<Application> getAllWishItemsByUserId(int userId) throws SQLException {
	        String sql = String.format("SELECT * FROM `applications` WHERE `UserID` = %d;", userId);
	        ArrayList<Application> applicationList = new ArrayList<>();
	        try (ResultSet res = con.executeQuery(sql)) {
	            while (res.next()) {
	                int retApplicationId = res.getInt("ApplicationID");
	                int retUserId = res.getInt("UserID");
	                int retJobId = res.getInt("JobID");
	                Timestamp retApplicationDate = res.getTimestamp("ApplicationDate");
					String retCvDesc = res.getString("CVDescription");
					String retTranscriptDesc = res.getString("TranscriptDescription");
					
					applicationList.add(new Application(retApplicationId, retApplicationDate,  retCvDesc, retTranscriptDesc, (Job)new Job(0, "", "", 0, null).get(retJobId), (User)Main.currModel));
	            }
	        }
	        return applicationList;
	    }
	 
	 
	public Application getApplicationByApplicationId(int id) {
		String sql = String.format("SELECT * FROM `applications` WHERE `ApplicationID` = %d", id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				
				int applicationId = res.getInt("ApplicationID");
				int userId = res.getInt("UserID");
				int jobId = res.getInt("JobID");
				Timestamp applicationDate = res.getTimestamp("ApplicationDate");
				String cvDesc = res.getString("CVDescription");
				String transcriptDesc = res.getString("TranscriptDescription");
				
				Logger.log("DB", "Successfully retrieve application item!");
				return new Application(applicationId, applicationDate,  cvDesc, transcriptDesc, (Job)new Job(0, "", "", 0, null).get(jobId), (User)new User(0, "","","","","").get(userId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `applications` WHERE `UserID` = %d", id);
		int userId = id;
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				
				int applicationId = res.getInt("ApplicationID");
				int jobId = res.getInt("JobID");
				Timestamp applicationDate = res.getTimestamp("ApplicationDate");
				String cvDesc = res.getString("CVDescription");
				String transcriptDesc = res.getString("TranscriptDescription");
				
				Logger.log("DB", "Successfully retrieve application item!");
				return new Application(applicationId, applicationDate,  cvDesc, transcriptDesc, (Job)new Job(0, "", "", 0, null).get(jobId), (User)new User(0, "","","","","").get(userId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<Application> getApplicationFromJobId(int jobId){
		String sql = String.format("SELECT * FROM `applications` WHERE `JobID` = %d", jobId);
		
		ArrayList<Application> applicationList = new ArrayList<>();
		ResultSet res = con.executeQuery(sql);
		
		try {
			while(res.next()) {
				
				 int retApplicationId = res.getInt("ApplicationID");
	                int retUserId = res.getInt("UserID");
	                int retJobId = res.getInt("JobID");
	                Timestamp retApplicationDate = res.getTimestamp("ApplicationDate");
					String retCvDesc = res.getString("CVDescription");
					String retTranscriptDesc = res.getString("TranscriptDescription");
					
					applicationList.add(new Application(retApplicationId, retApplicationDate,  retCvDesc, retTranscriptDesc, (Job)new Job(0, "", "", 0, null).get(retJobId), (User)new User(0, "","","","","").get(retUserId)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return applicationList;
	}

	

	@Override
	public void insert() throws SQLException {
		String sql = String.format("INSERT INTO `applications`(`ApplicationID`, `UserID`, `JobID`, `ApplicationDate`, `CVDescription`, `TranscriptDescription`) VALUES (0, %d, %d, NULL, '%s', '%s')", this.user.id, this.job.getId(), this.cvDesc, this.transcriptDesc);
		
		con.executeUpdate(sql);	
	}

	@Override
	public void delete() throws SQLException {
		String sql = String.format("DELETE FROM `applications` WHERE `ApplicationID` = %d", this.id);
		con.executeUpdate(sql);
		
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Model> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
