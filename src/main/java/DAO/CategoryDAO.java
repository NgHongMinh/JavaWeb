package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MyConnection.MyConnection;
import model.Category;

public class CategoryDAO {
	private Connection connection;
	private static final String SELECT_ALL_CATEGORY = "select * from category where status = 0;";
	private static final String SELECT_BY_ID = "select * from category where id = ?;";
	private static final String SEARCH_CATEGORY = "select * from category where name like ?";
	private static final String INSERT_INTO = "insert into category(name, status) value (?,?);";
	private static final String UPDATE_BY_ID = "update category set name = ? where id = ?;";
	
	public CategoryDAO() {
		connection = MyConnection.getConnection();
	}
	
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				categories.add(new Category(id, name, status));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	public Category findById(int id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int idDb = rs.getInt("id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				return new Category(idDb, name, status);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Category> searchCategory(String search) {
		List<Category> categories = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CATEGORY);) {
			preparedStatement.setString(1, "%" + search + "%");
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				categories.add(new Category(id, name, status));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	public void create(Category category) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);) {
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, 0);
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int id, Category category) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);) {
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
