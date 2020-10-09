package com.hsbc.codefury.errorKnights.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.*;

import com.hsbc.codefury.errorKnights.app.entity.Account;
import com.hsbc.codefury.errorKnights.app.entity.Customer;
import com.hsbc.codefury.errorKnights.app.exceptions.AccountNotFoundException;
import com.hsbc.codefury.errorKnights.app.exceptions.TransactionFailedException;

public class CustomerDaoImpl implements CustomerDao {

	private Connection con = null;
	private Statement st = null;
	private PreparedStatement ps = null;

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
		try {
			con = getConnection();
			st = con.createStatement();

			String query = "SELECT COUNT(*) AS TOT_ACCTS FROM ACCOUNTS WHERE ACCOUNT_ID IN(" + senderAccId + ","
					+ receiverAccId + ")";

			ResultSet rs = st.executeQuery(query);
			rs.next();
			int count = rs.getInt("TOT_ACCTS");

			if (count != 2) {
				System.out.println("Account doesn't exist");
				return false;// throw AccounNotFoundException
			}

			String query1 = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID = " + senderAccId;
			String query2 = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID = " + receiverAccId;
			String query3 = "INSERT INTO TRANSACTIONS(ACCOUNT_ID, AMOUNT, TRANS_TYPE, TRANS_TIME, REMARKS) VALUES(?,?,?,?,?)";

			ps = con.prepareStatement(query3);

			rs = st.executeQuery(query1);

			Double receiverBal = 0.0, senderBal = 0.0;

			if (rs.next()) {
				senderBal = rs.getDouble("BALANCE");
			}

			rs = st.executeQuery(query2);
			if (rs.next()) {
				receiverBal = rs.getDouble("BALANCE");
			}

			senderBal -= amount;
			receiverBal += amount;

			try {
				// Transaction update

				con.setAutoCommit(false);

				Statement st = con.createStatement();
				st.addBatch("UPDATE ACCOUNTS SET BALANCE=" + senderBal + "WHERE ACCOUNT_ID=" + senderAccId);
				st.addBatch("UPDATE ACCOUNTS SET BALANCE=" + receiverBal + "WHERE ACCOUNT_ID=" + receiverAccId);

				st.executeBatch();

				System.out.println("acct table updated");

				Date d1 = new Date();
				Timestamp timeStamp = new Timestamp(d1.getTime());

				ps.setString(1, senderAccId);
				ps.setDouble(2, amount);
				ps.setString(3, "DEBIT");
				ps.setTimestamp(4, timeStamp);
				ps.setString(5, "SUCCESS");

				ps.addBatch();

				ps.setString(1, receiverAccId);
				ps.setDouble(2, amount);
				ps.setString(3, "CREDIT");
				ps.setTimestamp(4, timeStamp);
				ps.setString(5, "SUCCESS");

				ps.addBatch();

				ps.executeBatch();
				con.commit();

				System.out.println("trans table updated");
				return true;

			} catch (SQLException e) {
				try {
					e.printStackTrace();
					// Rollback update

					con.rollback();

					throw new TransactionFailedException();

				} catch (TransactionFailedException e1) {
					throw e1;
				} catch (SQLException e1) {

					System.out.println("Could not rollback updates " + e1.getMessage());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public String viewTransactions(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Connection getConnection() throws SQLException {

		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");

			con = DriverManager.getConnection("jdbc:derby://localhost:1527/bankdb");

		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
			System.out.println("Derby Driver could not be Found...");

		} catch (SQLException ex) {
			System.out.println("Exception : " + ex);
			ex.printStackTrace();
			throw ex;
		}
		return con;
	}

}
