package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import utils.Connect;
import utils.Logger;

public class Advertisement implements Model{
	private final Connect con = Connect.getConnection();
	private int id;
	private String title;
	private String desc;
	private Company company;
	
	
	
	public Advertisement(int id, String title, String desc, Company company) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.company = company;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	public ArrayList<Advertisement> getAdvertisementByCompanyId(int companyId){
		String sql = String.format("SELECT * FROM `advertisements` WHERE `CompanyID` = %d", companyId);
		ArrayList<Advertisement> advertisementList = new ArrayList<>();
		try (ResultSet res = con.executeQuery(sql)) {
            while (res.next()) {
                int retAdvertisementId = res.getInt("AdvertisementID");
                int retCompanyId = res.getInt("CompanyID");
                String retAdvertisementTitle = res.getString("AdvertisementTitle");
                String retAdvertisementDesc = res.getString("AdvertisementDescription");
                

				advertisementList.add(new Advertisement(retAdvertisementId, retAdvertisementTitle, retAdvertisementDesc, (Company)new Company(0, "", "", "", "","").get(retCompanyId) ));
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return advertisementList;
		
	}

	
	public ArrayList<Advertisement> getAdvertisementByCompanyIdLimit5(int companyId){
		String sql = String.format("SELECT * FROM `advertisements` WHERE `CompanyID` = %d LIMIT 5", companyId);
		ArrayList<Advertisement> advertisementList = new ArrayList<>();
		try (ResultSet res = con.executeQuery(sql)) {
            while (res.next()) {
                int retAdvertisementId = res.getInt("AdvertisementID");
                int retCompanyId = res.getInt("CompanyID");
                String retAdvertisementTitle = res.getString("AdvertisementTitle");
                String retAdvertisementDesc = res.getString("AdvertisementDescription");
                

				advertisementList.add(new Advertisement(retAdvertisementId, retAdvertisementTitle, retAdvertisementDesc, (Company)new Company(0, "", "", "", "","").get(retCompanyId) ));
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return advertisementList;
		
	}

	@Override
	public Model get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> getAll() throws SQLException {
		 String sql = "SELECT * FROM `advertisements`";
	        List<Model> advertisementList = new ArrayList<>();
	        try (ResultSet res = con.executeQuery(sql)) {
	            while (res.next()) {
	                int retAdvertisementId = res.getInt("AdvertisementID");
	                int retCompanyId = res.getInt("CompanyID");
	                String retAdvertisementTitle = res.getString("AdvertisementTitle");
	                String retAdvertisementDesc = res.getString("AdvertisementDescription");
	                

					advertisementList.add(new Advertisement(retAdvertisementId, retAdvertisementTitle, retAdvertisementDesc, (Company)new Company(0, "", "", "", "","").get(retCompanyId) ));
	            }
	        }
	        return advertisementList;
		
	}

	@Override
	public void insert() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() throws SQLException {
		String sql = String.format("DELETE FROM `advertisements` WHERE `AdvertisementID` = %d ", this.id);
		con.executeUpdate(sql);
		
		
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
