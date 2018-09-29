package com.rit.cs.model;

/**
 * ResultModel.java
 * 
 * @author Lijitha Govindankutty
 * @author Sahana Murthy
 * @author Prajwal Guthinabail Mar 22, 2018
 */
public class ResultModel {

	private long phoneNo;
	private String name;
	private double latitude;
	private double longitude;
	private String service;
	private String description;

	/**
	 * @param phoneNo
	 * @param name
	 * @param latitude
	 * @param longitude
	 * @param service
	 * @param description
	 */
	public ResultModel(long phoneNo, String name, double latitude,
			double longitude, String service, String description) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.service = service;
		this.description = description;
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
