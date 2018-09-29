package com.rit.cs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * RequestModel.java
 * 
 * @author Lijitha Govindankutty
 * @author Sahana Murthy
 * @author Prajwal Guthinabail Mar 22, 2018
 */
public class RequestModel {

	private String service;
	private double latitude;
	private double longitude;
	private double distance;

	/**
	 * @param service
	 * @param latitude
	 * @param longitude
	 * @param distance
	 */
	public RequestModel(String service, double latitude, double longitude,
			double distance) {
		super();
		this.service = service;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
	}

	/**
	 * 
	 * @return
	 */
	public List<ResultModel> queryDB() {
		Connection c = null;
		Statement stmt = null;
		List<ResultModel> resultArr = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();

			String sql = "select * from provider where phonenumber in (select phonenumber from service where keyword ='"
					+ this.service + "' );";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("Name");
				long phone = rs.getLong("Phonenumber");
				double lati = rs.getDouble("Latitude");
				double longi = rs.getDouble("Longitude");
				ResultModel res = new ResultModel(phone, name, lati, longi,
						service, "Dummy");
				resultArr.add(res);
			}
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

		}
		System.out.println("Queried Successfully");

		return resultArr;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
