package com.infy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.infy.entity.User;

public class Dbhelper {

	private final static Logger logger = Logger.getLogger(Dbhelper.class);
	
	
	public String setUser(User user) {

		Connection con = null;
		PreparedStatement psInsertUser = null;
		Dbhelper helper = new Dbhelper();
		try {
			con = helper.dbconnection();

			String insertUser = "insert into \"UserProfile\" values ('"
					+ user.getUserName() + "','" + user.getPassword() + "')";

			psInsertUser = con.prepareStatement(insertUser);

			int retcode = psInsertUser.executeUpdate();

			if (retcode != 0) {
				return "Success";
			} else {
				return "Failure";
			}

		} catch (Exception ex) {
			logger.error("setUser:Dbhelper.java have errors: "+ex.getMessage());
		}
		return "Failure";
	}

	public Connection dbconnection() {
		// TODO Auto-generated method stub
		Connection con = null;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/CarPoolDB", "nishant",
					"nishant");
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException");
			e1.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException");
			e.printStackTrace();
		}

		return con;
	}

}
