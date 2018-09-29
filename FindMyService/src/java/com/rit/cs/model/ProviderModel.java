package com.rit.cs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ProviderModel.java
 * 
 * @author Lijitha Govindankutty
 * @author Sahana Murthy
 * @author Prajwal Guthinabail Mar 20, 2018
 */
public class ProviderModel {
	private long phoneNo;
	private String name;
	private double latitude;
	private double longitude;
	private boolean isOnline;

	/**
	 * @param phoneNo
	 * @param name
	 * @param latitude
	 * @param longitude
	 */
	public ProviderModel(long phoneNo, String name, double latitude,
			double longitude) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.setOnline(true);
	}

	/**
	 * 
	 * @return
	 */
	public boolean addUser() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();

			String sql = "INSERT INTO Provider (NAME,PHONENUMBER,LATITUDE, LONGITUDE, ISONLINE) "
					+ "VALUES ('" + this.name + "'," + this.phoneNo + ","
					+ this.latitude + "," + this.longitude + "," + this.isOnline
					+ ");";
			stmt.executeUpdate(sql);

			sql = "UPDATE Provider set location = ST_POINT(Latitude, Longitude);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		System.out.println("Records created successfully");
		return true;
	}

	/**
	 * @return the phoneNo
	 */
	public long getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the isOnline
	 */
	public boolean isOnline() {
		return isOnline;
	}

	/**
	 * @param isOnline
	 *            the isOnline to set
	 */
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

}
