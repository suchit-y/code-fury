package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hsbc.entity.RegisterAccount;
import com.hsbc.entity.RegisterCustomer;
import com.hsbc.util.DBConnection;

public class CustomerDao {
	public String custDetails(RegisterCustomer custBean) {

		String CUST_ID = custBean.getCUST_ID();
		String CUSTOMER_NAME= custBean.getCUSTOMER_NAME();
		String PAN = custBean.getPAN();
		String DOB = custBean.getDOB();
		String MOBILE = custBean.getMOBILE();
		String EMAIL = custBean.getEMAIL();
		String ALT_MOBILE = custBean.getALT_MOBILE();
		String ALT_EMAIL = custBean.getALT_EMAIL();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			System.out.println(" customerdao class");
			con = DBConnection.createConnection();
			//String query = "insert into customer values (?,?,?,?,?)";
			String query = "insert into customer(customer_name,pan,dob,mobile,email,alt_mobile,alt_email)  values (?,?,?,?,?,?,?)";
			System.out.println(query);
			preparedStatement  = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
			// of data
			System.out.println("prepare statement");
			//preparedStatement.setString(1, CUST_ID);
			preparedStatement.setString(1, CUSTOMER_NAME);	
			preparedStatement.setString(2, PAN);	
			preparedStatement.setString(3, DOB);
			preparedStatement.setString(4, MOBILE);
			preparedStatement.setString(5, EMAIL);
			preparedStatement.setString(6, ALT_EMAIL);
			preparedStatement.setString(7, ALT_EMAIL);
			

			int i = preparedStatement.executeUpdate();
			//System.out.println( "value of i "+i);

			if (i != 0) // Just to ensure data has been inserted into the database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("exception occured");
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
	}
}
