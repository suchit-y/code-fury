package com.hsbc.codefury.errorKnights.app.service;

import com.hsbc.codefury.errorKnights.app.dao.CustomerDao;

public class BankAppService {

	CustomerDao custDao = null;

	public BankAppService(CustomerDao custDao) {
		this.custDao = custDao;
	}

	public String transaction(String senderAccId, String receiverAccId, double amt) {
		try {
			if (custDao.doTransaction(senderAccId, receiverAccId, amt))
				return "success";
			else
				return "failure";
		} catch (Exception e) {
			return "failure";
		}
	}
}
