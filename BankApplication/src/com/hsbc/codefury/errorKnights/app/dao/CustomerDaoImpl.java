package com.hsbc.codefury.errorKnights.app.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hsbc.codefury.errorKnights.app.entity.Account;
import com.hsbc.codefury.errorKnights.app.entity.Customer;
import com.hsbc.codefury.errorKnights.app.exceptions.AccountNotFoundException;
import com.hsbc.codefury.errorKnights.app.exceptions.TransactionFailedException;

public class CustomerDaoImpl implements CustomerDao {

	List<Account> accList = new ArrayList<>();

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

}
