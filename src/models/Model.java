package models;

import java.sql.SQLException;
import java.util.List;

public interface Model {
	public Model get(int id) throws SQLException;
	public List<Model> getAll() throws SQLException;
	public void insert() throws SQLException;
	public void delete() throws SQLException;
	public void update() throws SQLException;
	

}
