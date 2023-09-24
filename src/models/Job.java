package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import utils.Connect;
import utils.Logger;

public class Job implements Model{
	private final Connect con;
	private int id;
	private String name;
	private String description;
	private double salary;
	private Company company;
	
	
	
	public Job(int id, String name, String description, double salary, Company company) {
		super();
		con = Connect.getConnection();
		this.id = id;
		this.name = name;
		this.description = description;
		this.salary = salary;
		this.company = company;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	public void addToUserWishList() {
		String sql = String.format("INSERT INTO `wishitems`(`WishItemID`, `UserID`, `JobID`) VALUES (0,%d,%d)", ((User)Main.currModel).getId(), this.id);
		con.executeUpdate(sql);
	}
	
	public ArrayList<Job> getJobFromOtherCompany(int companyId){
		String sql = String.format("SELECT * FROM `jobs` WHERE `CompanyID` != %d", companyId);
		ArrayList<Job> jobList = new ArrayList<>();
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			while(res.next()) {
				int retJobId = res.getInt("JobID");
				int retCompanyId = res.getInt("CompanyID");
				String retJobName= res.getString("JobName");
				String retJobDesc = res.getString("JobDescription");
				double retJobSalary = res.getDouble("JobSalary");
				
				Logger.log("DB", "Authenticated Company");
				jobList.add(new Job(retJobId, retJobName, retJobDesc, retJobSalary, (Company)new Company(0, "", "", "", "","").get(retCompanyId)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobList;
	}
	
	

	public Company getCompanyFromJobId() {
		String sql = String.format("SELECT * FROM `jobs` WHERE `JobID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		
		int retCompanyId = 0;
		
		try {
			if(res.next()) {
				retCompanyId = res.getInt("CompanyID");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return (Company)new Company(0, "", "", "", "", "").get(retCompanyId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Internship getInternshipByJobId() {
		String sql = String.format("SELECT * FROM `internships` WHERE `JobID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				int retInternshipId = res.getInt("InternshipID");
				
				return (Internship)new Internship(0, "", "", null).get(retInternshipId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean checkInternship() {
		String sql = String.format("SELECT * FROM `internships` WHERE `JobID` = %d", this.id);
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public ArrayList<Job> getJobFromOtherCompanyLimit2(int companyId){
		String sql = String.format("SELECT * FROM `jobs` WHERE `CompanyID` != %d LIMIT 2", companyId);
		ArrayList<Job> jobList = new ArrayList<>();
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			while(res.next()) {
				int retJobId = res.getInt("JobID");
				int retCompanyId = res.getInt("CompanyID");
				String retJobName= res.getString("JobName");
				String retJobDesc = res.getString("JobDescription");
				double retJobSalary = res.getDouble("JobSalary");
				
				Logger.log("DB", "Authenticated Company");
				jobList.add(new Job(retJobId, retJobName, retJobDesc, retJobSalary, (Company)new Company(0, "", "", "", "","").get(retCompanyId)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobList;
	}

	@Override
	public Model get(int id) throws SQLException {
		// TODO Auto-generated method stub
				String sql = String.format("SELECT * FROM `jobs` WHERE `JobID` = %d", id);
				
				ResultSet res = con.executeQuery(sql);
				
				try {
					if(res.next()) {
						int retJobId = res.getInt("JobID");
						int retCompanyId = res.getInt("CompanyID");
						String retJobName= res.getString("JobName");
						String retJobDesc = res.getString("JobDescription");
						double retJobSalary = res.getDouble("JobSalary");
						
						Logger.log("DB", "Authenticated Company");
						return new Job(retJobId, retJobName, retJobDesc, retJobSalary, (Company)new Company(0, "", "", "", "","").get(retCompanyId));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
	}
	
	public ArrayList<Job> getJobFromCompanyIdLimit2(int companyId){
		String sql = String.format("SELECT * FROM `jobs` WHERE `CompanyID` = %d LIMIT 2", companyId);
		ArrayList<Job> jobList = new ArrayList<>();
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			while(res.next()) {
				int retJobId = res.getInt("JobID");
				int retCompanyId = res.getInt("CompanyID");
				String retJobName= res.getString("JobName");
				String retJobDesc = res.getString("JobDescription");
				double retJobSalary = res.getDouble("JobSalary");
				
				Logger.log("DB", "Authenticated Company");
				jobList.add(new Job(retJobId, retJobName, retJobDesc, retJobSalary, (Company)new Company(0, "", "", "", "","").get(retCompanyId)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobList;
	}
	
	public ArrayList<Job> getJobFromCompanyId(int companyId){
		String sql = String.format("SELECT * FROM `jobs` WHERE `CompanyID` = %d", companyId);
		ArrayList<Job> jobList = new ArrayList<>();
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			while(res.next()) {
				int retJobId = res.getInt("JobID");
				int retCompanyId = res.getInt("CompanyID");
				String retJobName= res.getString("JobName");
				String retJobDesc = res.getString("JobDescription");
				double retJobSalary = res.getDouble("JobSalary");
				
				Logger.log("DB", "Authenticated Company");
				jobList.add(new Job(retJobId, retJobName, retJobDesc, retJobSalary, (Company)new Company(0, "", "", "", "","").get(retCompanyId)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobList;
	}

	@Override
	public List<Model> getAll() throws SQLException {
		 String sql = "SELECT * FROM `jobs`";
	        List<Model> jobList = new ArrayList<>();
	        try (ResultSet res = con.executeQuery(sql)) {
	            while (res.next()) {
	                int retJobId = res.getInt("JobID");
	                int retCompanyId = res.getInt("CompanyID");
	                String retJobName= res.getString("JobName");
					String retJobDesc = res.getString("JobDescription");
					double retJobSalary = res.getDouble("JobSalary");
	                

					jobList.add(new Job(retJobId, retJobName, retJobDesc, retJobSalary, (Company)new Company(0, "", "", "", "","").get(retCompanyId)));
	            }
	        }
	        return jobList;
	}

	@Override
	public void insert() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM `jobs` WHERE `JobID` = %d", this.id);
		con.executeUpdate(sql);
		
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
