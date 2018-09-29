package com.rit.cs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * UpdaterModel.java
 * 
 * @author Prajwal Guthinabail Mar 22, 2018
 */
public class UpdaterModel {
	private long phoneNo;
	private double latitude;
	private double longitude;
	private boolean isOnline;

	/**
	 * 
	 * @param phoneNo
	 */
	public UpdaterModel(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @param phoneNo
	 * @param latitude
	 * @param longitude
	 */
	public UpdaterModel(long phoneNo, double latitude, double longitude) {
		super();
		this.phoneNo = phoneNo;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @param phoneNo
	 * @param isOnline
	 */
	public UpdaterModel(long phoneNo, boolean isOnline) {
		super();
		this.phoneNo = phoneNo;
		this.isOnline = isOnline;
	}

	/**
	 * 
	 * @return
	 */
	public boolean verifyProvider() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "select name from provider where phonenumber = "
					+ this.phoneNo + ";";

			ResultSet result = stmt.executeQuery(sql);
			if (result.next()) {
				c.commit();
				stmt.close();
				c.close();

				System.out.println("Verified successfully");
				return true;
			} else {

				c.commit();
				stmt.close();
				c.close();
				return false;
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}

	}

	/**
	 * 
	 * @return
	 */
	public boolean updateLocation() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "UPDATE Provider set latitude = " + this.latitude
					+ ", longitude = " + this.longitude + " where phonenumber='"
					+ this.phoneNo + "';";
			stmt.executeUpdate(sql);

			sql = "UPDATE Provider set location = ST_POINT(Latitude, Longitude) where phonenumber = '"
					+ this.phoneNo + "';";
			stmt.executeUpdate(sql);

			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		System.out.println("Location update done successfully");
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean updateAvailability() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "UPDATE Provider set ISONLINE = " + this.isOnline
					+ " WHERE phonenumber = " + this.phoneNo + ";";
			stmt.executeUpdate(sql);

			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("update done successfully");
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
