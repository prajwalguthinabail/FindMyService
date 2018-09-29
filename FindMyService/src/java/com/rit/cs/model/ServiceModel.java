package com.rit.cs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ServiceModel.java
 * 
 * @author Lijitha Govindankutty
 * @author Sahana Murthy
 * @author Prajwal Guthinabail Mar 20, 2018
 */
public class ServiceModel {

	private long phoneNo;
	private String service;
	private String description;

	/**
	 * @param phoneNo
	 * @param service
	 * @param description
	 */
	public ServiceModel(long phoneNo, String service, String description) {
		super();
		this.phoneNo = phoneNo;
		this.service = service;
		this.description = description;
	}

	/**
	 * @param phoneNo
	 * @param service
	 */
	public ServiceModel(long phoneNo, String service) {
		super();
		this.phoneNo = phoneNo;
		this.service = service;
	}

	public boolean add() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();

			String sql = "INSERT INTO Service (PHONENUMBER,KEYWORD, DESCRIPTION) "
					+ "VALUES (" + this.phoneNo + ",'" + this.service + "','"
					+ this.description + "');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		System.out.println("Added successfully");
		return true;

	}

	public boolean remove() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/vgs", "postgres", "root");
			c.setAutoCommit(false);

			stmt = c.createStatement();

			String sql = "DELETE FROM Service " + "WHERE KEYWORD='"
					+ this.service + "';";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		System.out.println("Deleted successfully");
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
