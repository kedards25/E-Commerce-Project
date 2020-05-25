package com.ecommerceproj.jsoncommunication.services;

import java.sql.*;
import java.util.*;

import com.ecommerceproj.jsoncommunication.models.UserModel;

public class IDAO_Impl implements IDAO {

	String user = "sa";
	String pwd = "";
	String url = "jdbc:h2:tcp://localhost/~/test";

	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	String query = null;

	UserModel model;
	int id;
	String name;
	String addr;
	String pass;

	private boolean isDbConnected() {
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
			if (connection != null) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("isDB_Connected->ClassNotFoundException : " + e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("isDB_Connected->SQLException : " + e);
		}
		return false;
	}

	public List<UserModel> getAllUsers() {

		List<UserModel> userList = new ArrayList<UserModel>();

		if (isDbConnected()) {
			query = "select * "
					+ "from userdata";
			try {
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					id = resultSet.getInt("id");
					name = resultSet.getString("name");
					addr = resultSet.getString("addr");
					pass = resultSet.getString("pass");
					model = new UserModel(id, name, addr, pass);

					userList.add(model);

				}
			} catch (SQLException e) {
				System.out.println("getAllUsers->SQLException : " + e);
			}

		}

		return userList;
	}

	public int insertUser(UserModel model) {
		int rowsAffected = 0;
		if (isDbConnected()) {

			id = model.getUserId();
			name = model.getUserName();
			addr = model.getUserAddress();
			pass = model.getUserPass();

			query = "insert into userdata values(?,?,?,?)";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, addr);
				preparedStatement.setString(4, pass);
				rowsAffected = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rowsAffected;
	}

	public int updateUser(int id, UserModel model) {
		int rowsAffected = 0;
		if (isDbConnected()) {

			id = model.getUserId();
			name = model.getUserName();
			addr = model.getUserAddress();
			pass = model.getUserPass();

			query = "update userdata set name=?,"
					+ "addr=?,"
					+ "pass=?"
					+ "where id=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(4, id);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, addr);
				preparedStatement.setString(3, pass);
				rowsAffected = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rowsAffected;
	}

	public int deleteUser(int id) {
		int rowsAffected = 0;
		if (isDbConnected()) {
			
			query = "delete userdata "
					+ "where id=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				rowsAffected = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rowsAffected;
	}

}
