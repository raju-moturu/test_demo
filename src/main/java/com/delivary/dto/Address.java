package com.delivary.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

      private String doorNo;
      private String street;
      private String area;
      private String village;
      private String distric;
      private String state;
      private String pincode;
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDistric() {
		return distric;
	}
	public void setDistric(String distric) {
		this.distric = distric;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
}
