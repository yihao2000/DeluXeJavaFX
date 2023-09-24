package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import utils.Connect;
import utils.Logger;

public class WishItem implements Model{
	private final static Connect con = Connect.getConnection();
	private int id;
	private User user;
	private Job job;
	
	
	public WishItem(int id, User user, Job job) {
		super();
		this.id = id;
		this.user = user;
		this.job = job;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
	public static ArrayList<WishItem> getApplicationFromJobAndUserId (int userId, int jobId) throws SQLException{
		String sql = String.format("SELECT * FROM `wishitems` WHERE `UserID` = %d AND `JobID` = %d", userId, jobId);
		ArrayList<WishItem> wishList = new ArrayList<>();
		
		 try (ResultSet res = con.executeQuery(sql)) {
	            while (res.next()) {
	                int retWishItemId = res.getInt("WishItemID");
	                int retUserId = res.getInt("UserID");
	                int retJobId = res.getInt("JobID");
	    
					
			
					wishList.add(new WishItem(retWishItemId, (User)new User(0, "", "", "", "", "").get(retUserId), (Job)new Job(0, "", "", 0, null).get(retJobId)));					
	            }
	        }
	        return wishList;
		
	}

	@Override
	public Model get(int id) throws SQLException {
		
		
		String sql = String.format("SELECT * FROM `wishitems` WHERE `UserID` = %d", id);
		int userId = id;
		
		ResultSet res = con.executeQuery(sql);
		
		try {
			if(res.next()) {
				
				int retWishItemId = res.getInt("WishItemID");
				int jobId = res.getInt("JobID");
				
				Logger.log("DB", "Successfully retrieve wish items!");
				Logger.log("DB", jobId+"");
				return new WishItem(retWishItemId, (User)Main.currModel, (Job)new Job(0, "", "", 0, null).get(jobId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	 public static ArrayList<WishItem> getAllWishItemsByUserId(int userId) throws SQLException {
	        String sql = String.format("SELECT * FROM `wishitems` WHERE `UserID` = %d;", userId);
	        ArrayList<WishItem> wishItems = new ArrayList<>();
	        try (ResultSet res = con.executeQuery(sql)) {
	            while (res.next()) {
	                int retId = res.getInt("WishItemID");
	                int retUserId = res.getInt("UserID");
	                int retJobId = res.getInt("JobID");
	                wishItems.add(new WishItem(retId, (User) new User(0, "", "", "", "", "").get(retUserId), (Job) new Job(0, "", "", 0.0, null).get(retJobId)));
	            }
	        }
	        return wishItems;
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
		String sql = String.format("DELETE FROM `wishitems` WHERE `WishItemID` = %d", this.id);
		con.executeUpdate(sql);
		
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
