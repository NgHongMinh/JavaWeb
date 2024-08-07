package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MyConnection.MyConnection;
import model.Account;

public class AccountDAO {
	private Connection connection;
	private static final String LOGIN= "select * from account where user = ? and pass = ?";
	private static final String CHECKING = "select * from account where user = ?";
	private static final String SIGN_UP = "insert into account(user, pass, isSell, isAdmin) value (?,?,0,0);";
	
	public AccountDAO() {
		connection = MyConnection.getConnection();
	}
	
	public void create(String user, String pass) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(SIGN_UP);) {
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account Checking(String user) {
		Account account = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(CHECKING);) {
			preparedStatement.setString(1, user);
	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            if (rs.next()) {
	                int id = rs.getInt("id");
	                String pass = rs.getString("pass");
	                account = new Account(id, user, pass);
	            }
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public Account Login(String user, String pass) {
		Account account = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);) {
			preparedStatement.setString(1, user);
	        preparedStatement.setString(2, pass);
	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            if (rs.next()) {
	                int id = rs.getInt("id");
	                int isSell = rs.getInt("isSell");
	                int isAdmin = rs.getInt("isAdmin");
	                account = new Account(id, user, pass, isSell, isAdmin);
	            }
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
}
