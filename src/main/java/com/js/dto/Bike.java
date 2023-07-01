package com.js.dto;

public class Bike {

	private int bike_no;
	private String bike_name;
	private String owner_name;

	public int getBike_no() {
		return bike_no;
	}

	public void setBike_no(int bike_no) {
		this.bike_no = bike_no;
	}

	public String getBike_name() {
		return bike_name;
	}

	public void setBike_name(String bike_name) {
		this.bike_name = bike_name;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	@Override
	public String toString() {
		return "Bike [bike_no=" + bike_no + ", bike_name=" + bike_name + ", owner_name=" + owner_name + "]";
	}

}
