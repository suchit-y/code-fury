package com.hsbc.entity;

public class RegisterAccount {  
	private String customerId;
	private String accountId;
	//private String currentBal;
	private String acctype;
	private String inDeposit ;
	private String minBalance;
	private String overdraftAmount;
	
	
	public RegisterAccount() {
		
	}
	public RegisterAccount(String customerId, String accountId,  String acctype, String inDeposit, String minBalance,
			String overdraftAmount) {
		
		this.customerId = customerId;
		this.accountId = accountId;
		//this.currentBal = currentBal;
		this.inDeposit = inDeposit;
		this.acctype = acctype;
		this.minBalance = minBalance;
		this.overdraftAmount = overdraftAmount;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getInDeposit() {
		return inDeposit;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public void setInDeposit(String inDeposit) {
		this.inDeposit = inDeposit;
	}
	public String getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(String minBalance) {
		this.minBalance = minBalance;
	}
	public String getOverdraftAmount() {
		return overdraftAmount;
	}
	public void setOverdraftAmount(String overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
	

}
