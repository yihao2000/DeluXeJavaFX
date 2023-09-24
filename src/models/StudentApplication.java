package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import utils.Connect;
import utils.Logger;

public class StudentApplication implements Model{
	private static final Connect con = Connect.getConnection();
	private int id;
	private Timestamp date;
	private String cvDesc;
	private String transcriptDesc;
	private Internship internship;
	private Student student;
	
	
	public StudentApplication(int id, Timestamp date, String cvDesc, String transcriptDesc, Internship internship, Student student) {
		super();
		this.id = id;
		this.date = date;
		this.cvDesc = cvDesc;
		this.transcriptDesc = transcriptDesc;
		this.student = student;
		this.internship = internship;
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
	
	
	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public static ArrayList<StudentApplication> getApplicationFromInternshipId(int internshipId){
		String sql = String.format("SELECT * FROM `studentapplications` WHERE `InternshipID` = %d", internshipId);
		
		ArrayList<StudentApplication> applicationList = new ArrayList<>();
		ResultSet res = con.executeQuery(sql);
		
		try {
			while(res.next()) {
				
					int retStudentApplicationId = res.getInt("StudentApplicationID");
	                int retStudentId = res.getInt("StudentID");
	                int retInternshipId = res.getInt("InternshipID");
	                Timestamp retApplicationDate = res.getTimestamp("StudentApplicationDate");
					String retCvDesc = res.getString("CVDescription");
					String retTranscriptDesc = res.getString("TranscriptDescription");
					
					applicationList.add(new StudentApplication(retStudentApplicationId, retApplicationDate,  retCvDesc, retTranscriptDesc, (Internship)new Internship(0, "", "", null).get(retInternshipId), (Student) new Student(0, "","","","","").get(retStudentId)));
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return applicationList;
	}

	public StudentReport getStudentReportFromStudentApplicationId() {
		String sql = String.format("SELECT * FROM `studentreports` WHERE `StudentApplicationID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				int retApplicationId = res.getInt("StudentApplicationID");
				return (StudentReport)new StudentReport(null).get(retApplicationId);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public Model get(int id) throws SQLException {
		String sql = String.format("SELECT * FROM `studentapplications` WHERE `StudentApplicationID` = %d", id);
		int userId = id;
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				
				int studentApplicationId = res.getInt("StudentApplicationID");
				int studentId = res.getInt("StudentID");
				int internshipId = res.getInt("InternshipID");
				Timestamp studentApplicationDate = res.getTimestamp("StudentApplicationDate");
				String cvDesc = res.getString("CVDescription");
				String transcriptDesc = res.getString("TranscriptDescription");
				
				Logger.log("DB", "Successfully retrieve student application item!");
				return new StudentApplication(studentApplicationId, studentApplicationDate , cvDesc, transcriptDesc, (Internship)new Internship(0, "","",null).get(internshipId), (Student)new Student(0, "", "", "", "", "").get(studentId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void insertAcceptanceReport() {
		String sql = String.format("INSERT INTO `studentreports` VALUES (%d)", this.id);
		con.executeUpdate(sql);
		Logger.log("DB", "Student Report successfully inserted!");
				
	}
	
	public static ArrayList<StudentApplication> getStudentApplicationFromCompanyId(){
		ArrayList<StudentApplication> studentApplicationList = new ArrayList<>();
		
		ArrayList<Integer> jobIdList = new ArrayList<>();
		ArrayList<Integer> internshipIdList = new ArrayList<>();
		
		String sql1 = String.format("SELECT * FROM `jobs` WHERE `CompanyID` = %d", ((Company)Main.currModel).getId());
		
		ResultSet res1 = con.executeQuery(sql1);
		
		try {
			while(res1.next()) {
				int jobId = res1.getInt("JobID");
				
				jobIdList.add(jobId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (Integer integer : jobIdList) {
			String sql2 = String.format("SELECT * FROM `internships` WHERE `JobID` = %d", integer);
			
			ResultSet res2 = con.executeQuery(sql2);
			
			try {
				if(res2.next()) {
					int internshipId = res2.getInt("InternshipID");
					
					internshipIdList.add(internshipId);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (Integer integer : internshipIdList) {
			String sql3 = String.format("SELECT * FROM `studentapplications` WHERE `InternshipID` = %d", integer);
			
			ResultSet res3 = con.executeQuery(sql3);
			
			try {
				while(res3.next()) {
					int studentApplicationId = res3.getInt("StudentApplicationID");
					int studentId = res3.getInt("StudentID");
					int internshipId = res3.getInt("InternshipID");
					Timestamp studentApplicationDate = res3.getTimestamp("StudentApplicationDate");
					String cvDesc = res3.getString("CVDescription");
					String transcriptDesc = res3.getString("TranscriptDescription");
					
					Logger.log("DB", "Successfully retrieve student application item!");
					studentApplicationList.add(new StudentApplication(studentApplicationId, studentApplicationDate , cvDesc, transcriptDesc, (Internship)new Internship(0, "","",null).get(internshipId), (Student)new Student(0, "", "", "", "", "").get(studentId)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return studentApplicationList;
		
		
		
		
		
	}
	
	public Internship getInternshipFromStudentApplicationId() {
		String sql = String.format("SELECT * FROM `studentapplications` WHERE `StudentApplicationID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		int retInternshipId = 0;
		
		try {
			if(res.next()) {
				retInternshipId = res.getInt("InternshipID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return (Internship)new Internship(0, "", "", null).get(retInternshipId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static ArrayList<StudentApplication> getStudentApplicationFromStudentId() {
		String sql = String.format("SELECT * FROM `studentapplications` WHERE `StudentID` = %d", ((Student)Main.currModel).getId());
		ArrayList<StudentApplication> studentApplicationList = new ArrayList<>();
		
		ResultSet res3 = con.executeQuery(sql);
		
		try {
			while(res3.next()) {
				int studentApplicationId = res3.getInt("StudentApplicationID");
				int studentId = res3.getInt("StudentID");
				int internshipId = res3.getInt("InternshipID");
				Timestamp studentApplicationDate = res3.getTimestamp("StudentApplicationDate");
				String cvDesc = res3.getString("CVDescription");
				String transcriptDesc = res3.getString("TranscriptDescription");
				
				Logger.log("DB", "Successfully retrieve student application item!");
				studentApplicationList.add(new StudentApplication(studentApplicationId, studentApplicationDate , cvDesc, transcriptDesc, (Internship)new Internship(0, "","",null).get(internshipId), (Student)new Student(0, "", "", "", "", "").get(studentId)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentApplicationList;
		
		
	}
	

	@Override
	public List<Model> getAll() throws SQLException {
		return null;
	}

	@Override
	public void insert() throws SQLException {
		String sql = String.format("INSERT INTO `studentapplications` (`StudentApplicationID`, `StudentID`, `InternshipID`, `CVDescription`, `TranscriptDescription`) VALUES (0, %d, %d, '%s', '%s')", ((Student)Main.currModel).getId(), internship.getId(), cvDesc,transcriptDesc);
		con.executeUpdate(sql);
		Logger.log("DB", "Student Applications sucessfully inserted!");
		
	}

	@Override
	public void delete() throws SQLException {
		String sql = String.format("DELETE FROM `studentapplications` WHERE `StudentApplicationID` = %d", this.id);
		con.executeUpdate(sql);
		
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

	
}
