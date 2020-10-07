package com.hsbc.codefury.errorKnights.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hsbc.codefury.errorKnights.app.entity.Account;
import com.hsbc.codefury.errorKnights.app.entity.Customer;
import com.hsbc.codefury.errorKnights.app.exceptions.AccountNotFoundException;
import com.hsbc.codefury.errorKnights.app.exceptions.TransactionFailedException;

public class CustomerDaoImpl implements CustomerDao {

	List<Account> accList = new ArrayList<>();
	Connection con = null;

	@Override
	public String accountRequest(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerRegister(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String customerLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewProfile(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doTransaction(String senderAccId, String receiverAccId, double amount) {
		Iterator<Account> itr = accList.iterator();
		Account sender = null, receiver = null;
		try {
			while (itr.hasNext()) {
				if (sender.getAccId().equals(senderAccId)) {
					sender.setAccId(senderAccId);
				} else if (receiver.getAccId().equals(receiverAccId)) {
					receiver.setAccId(receiverAccId);
				}
			}
			if (sender == null || receiver == null) {
				throw new AccountNotFoundException();
			}

			boolean success = false;

			sender.setBalance(sender.getBalance() - amount);
			receiver.setBalance(receiver.getBalance() + amount);
			success = true;
			if (success) {
				throw new TransactionFailedException();
			}
			return true;

		} catch (AccountNotFoundException e1) {
			throw e1;
		}

		catch (TransactionFailedException e2) {
			throw e2;
		}
	}

	@Override
	public String viewTransactions(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection() throws SQLException  {
		
	try {

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		con = DriverManager.getConnection("jdbc:derby://localhost:1527/bankdb");

	} catch (ClassNotFoundException e) {
		System.out.println("Derby Driver could not be Found...");

	} catch (SQLException ex) {
		System.out.println("Exception : " + ex);
		ex.printStackTrace();
		throw ex;
	}
	return con;

	}
	
}
