package com.hsbc.entity;

public class RegisterCustomer {
	private String CUST_ID;
	private String CUSTOMER_NAME ;
	private String  PAN;
	private String DOB ;
	private String MOBILE;
	private String EMAIL  ;
	private String  ALT_MOBILE;
	private String  ALT_EMAIL;
	public String getCUST_ID() {
		return CUST_ID;
	}
	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getALT_MOBILE() {
		return ALT_MOBILE;
	}
	public void setALT_MOBILE(String aLT_MOBILE) {
		ALT_MOBILE = aLT_MOBILE;
	}
	public String getALT_EMAIL() {
		return ALT_EMAIL;
	}
	public void setALT_EMAIL(String aLT_EMAIL) {
		ALT_EMAIL = aLT_EMAIL;
	}
	public RegisterCustomer(String cUST_ID, String cUSTOMER_NAME, String pAN, String dOB, String mOBILE, String eMAIL,
			String aLT_MOBILE, String aLT_EMAIL) {
		
		CUST_ID = cUST_ID;
		CUSTOMER_NAME = cUSTOMER_NAME;
		PAN = pAN;
		DOB = dOB;
		MOBILE = mOBILE;
		EMAIL = eMAIL;
		ALT_MOBILE = aLT_MOBILE;
		ALT_EMAIL = aLT_EMAIL;
	}
	public RegisterCustomer() {
		
	}
	
	
	
	
}
