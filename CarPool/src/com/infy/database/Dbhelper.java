package com.infy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.infy.entity.Add;
import com.infy.entity.User;
import com.infy.entity.VehicleDetails;

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
			logger.error("setUser:Dbhelper.java have errors: "
					+ ex.getMessage());
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

	public String setVehicleDetails(List<VehicleDetails> listVehicleDetails) {

		Connection con = null;
		PreparedStatement psInsertVehicleDetails = null;
		Dbhelper helper = new Dbhelper();
		int retcode = 0;
		try {
			con = helper.dbconnection();

			System.out.println("size of the list:" + listVehicleDetails.size());

			for (VehicleDetails vehicleDetails : listVehicleDetails) {

				String insertVehidleDetails = "insert into \"VehicleDetails\" values ('"
						+ vehicleDetails.getCarNumber()
						+ "','"
						+ vehicleDetails.getCarModel()
						+ "','"
						+ vehicleDetails.getCarColor()
						+ "','"
						+ vehicleDetails.getOwner() + "')";
				psInsertVehicleDetails = con
						.prepareStatement(insertVehidleDetails);
				retcode = psInsertVehicleDetails.executeUpdate();
			}

			if (retcode != 0) {
				return "Success";
			} else {
				return "Failure";
			}

		} catch (Exception ex) {
			logger.error("setVehicleDetails:Dbhelper.java have errors: "
					+ ex.getMessage());
		}
		return "Failure";

	}

	public String setAdvertise(Add advertise) {

		Connection con = null;
		PreparedStatement psInsertAdd = null;
		Dbhelper helper = new Dbhelper();
		int retcode = 0;
		String via1 = null;
		String via2 = null;
		String via3 = null;
		String via4 = null;
		try {
			con = helper.dbconnection();
			
			if(advertise.getVia().size()==0){
				via1 = null;
				via2 = null;
				via3 = null;
				via4 = null;
			}else if(advertise.getVia().size()==1){
				via1 = advertise.getVia().get(0);
				via2 = null;
				via3 = null;
				via4 = null;
			}else if(advertise.getVia().size()==2){
				via1 = advertise.getVia().get(0);
				via2 = advertise.getVia().get(1);
				via3 = null;
				via4 = null;
			}else if(advertise.getVia().size()==3){
				via1 = advertise.getVia().get(0);
				via2 = advertise.getVia().get(1);
				via3 = advertise.getVia().get(2);
				via4 = null;
			}else if(advertise.getVia().size()==4){
				via1 = advertise.getVia().get(0);
				via2 = advertise.getVia().get(1);
				via3 = advertise.getVia().get(2);
				via4 = advertise.getVia().get(3);
			}
			

			String insertAdvertisement = "insert into \"Add\" values ('"
					+ advertise.getDate() + "','" + advertise.getTripCost()
					+ "','" + advertise.getStartLocation() + "','"
					+ advertise.getDestination() + "','"
					+ via1 + "','"+via2+"','"+via3+"','"
					+ via4 + "','" + advertise.getOwner()
					+ "')";
			
			System.out.println("query: " +insertAdvertisement);

			psInsertAdd = con.prepareStatement(insertAdvertisement);
			retcode = psInsertAdd.executeUpdate();

			if (retcode != 0) {
				return "Success";
			} else {
				return "Failure1";
			}

		} catch (Exception ex) {
			System.out.println("setAdvertise:Dbhelper.java have errors: "
					+ ex.getMessage());
			logger.error("setVehicleDetails:Dbhelper.java have errors: "
					+ ex.getMessage());
		}
		return "Failure2";
	}

}
