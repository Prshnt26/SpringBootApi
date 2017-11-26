package io.userResource.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDetails {
	
	private String id;
	private String fName;
	private String lName;
	private String email;
	private String pinCode;
	//private String address;
	private boolean isActive;
	private String birthDate;
	
	
	public UserDetails()
	{}
	
	public UserDetails(String id, String fName, String lName, String email, String pinCode,
		String birthDate) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pinCode = pinCode;
		this.isActive = true;
		this.birthDate = birthDate;
	}
	/*public UserDetails(String id, String fName, String lName, String email, String pinCode,
			Date birthDate) {
			super();
			this.id = id;
			this.fName = fName;
			this.lName = lName;
			this.email = email;
			this.pinCode = pinCode;
			this.isActive = true;
			this.birthDate = birthDate;
		}*/
	public UserDetails(String id, String fName, String lName, String email, String pinCode,
			String birthDate,boolean isActive) {

		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pinCode = pinCode;
		this.isActive = isActive;
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/*public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}*/
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
	

}
