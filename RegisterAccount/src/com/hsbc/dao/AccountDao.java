package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hsbc.entity.RegisterAccount;
import com.hsbc.util.DBConnection;

public class AccountDao {
	public String openAccount(RegisterAccount registerBean) {

		String customerId = registerBean.getCustomerId();
		String accountId = registerBean.getAccountId();
		String acctype = registerBean.getAcctype();
		String inDeposit = registerBean.getInDeposit();
		String minBalance = registerBean.getMinBalance();
		String overdraftAmount = registerBean.getOverdraftAmount();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			System.out.println("dao class");
			con = DBConnection.createConnection();
			//String query = "insert into openaccount(ACCOUNTID,CUSTOMERID,INDEPOSIT,MINBALANCE,OVERDRAFTAMOUNT) values (?,?,?,?,?)";
			String query = "insert into openaccount values (?,?,?,?,?,?)";
			System.out.println(query);
			preparedStatement  = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
			// of data
			System.out.println("prepare statement");
			preparedStatement.setString(1, accountId);
			preparedStatement.setString(2, customerId);	
			preparedStatement.setString(3, acctype);	
			preparedStatement.setString(4, inDeposit);
			preparedStatement.setString(5, minBalance);
			preparedStatement.setString(6, overdraftAmount);

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
