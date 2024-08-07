package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MyConnection.MyConnection;
import model.Product;
import model.Category;

public class ProductDAO {
	private Connection connection;
	private CategoryDAO categoryDAO;
	private static final String SELECT_ALL_PRODUCT = "select * from product where status = 0;";
	private static final String SELECT_BY_ID = "select * from product where id = ?;";
	private static final String SEARCH_BY_NAME = "select * from product where name like ?";
	private static final String SELECT_BY_CATEGORY = "select * from product where c_id = ?;";
	private static final String DELETE_BY_ID = "delete from product where id = ?;";
	private static final String INSERT_INTO = "insert into product(name,price,quantity,image,description,c_id,status) value (?,?,?,?,?,?,?);";
	private static final String UPDATE_BY_ID = "update product set name = ?, price = ?, quantity = ?, image = ?, description = ?, c_id = ? where id = ?;";
	
	public ProductDAO() {
		connection = MyConnection.getConnection();
		categoryDAO = new CategoryDAO();
	}
	
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String description = rs.getString("description");
				int status = rs.getInt("status");
				int cId = rs.getInt("c_id");
				Category category = categoryDAO.findById(cId);
				products.add(new Product(id, name, price, quantity, image, description, category, status));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public Product findById(String id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int idDb = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String description = rs.getString("description");
				int status = rs.getInt("status");
				int cId = rs.getInt("c_id");
				Category category = categoryDAO.findById(cId);
				return new Product(idDb, name, price, quantity, image, description, category, status);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> searchByName(String search) {
		List<Product> categories = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);) {
			preparedStatement.setString(1, "%" + search + "%");
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String description = rs.getString("description");
				int status = rs.getInt("status");
				int cId = rs.getInt("c_id");
				Category category = categoryDAO.findById(cId);
				categories.add(new Product(id, name, price, quantity, image, description, category, status));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	public List<Product> findByCategory(String cateId) {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CATEGORY);) {
			preparedStatement.setString(1, cateId);
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String description = rs.getString("description");
				int status = rs.getInt("status");
				int cId = rs.getInt("c_id");
				Category category = categoryDAO.findById(cId);
				products.add(new Product(id, name, price, quantity, image, description, category, status));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public void deleteById(String pid) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);) {
			preparedStatement.setString(1, pid);
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void create(Product product) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setString(4, product.getImage());
			preparedStatement.setString(5, product.getDescription());
			preparedStatement.setInt(6, product.getCategory().getId());
			preparedStatement.setInt(7, 0);
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int id, Product product) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setString(4, product.getImage());
			preparedStatement.setString(5, product.getDescription());
			preparedStatement.setInt(6, product.getCategory().getId());		
			preparedStatement.setInt(7, id);
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
