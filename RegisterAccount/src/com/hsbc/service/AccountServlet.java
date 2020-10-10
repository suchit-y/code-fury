package com.hsbc.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import com.hsbc.dao.AccountDao;
import com.hsbc.entity.RegisterAccount;
	 
	public class AccountServlet extends HttpServlet {
	 
	     public AccountServlet() {
	     }
	 
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //Copying all the input parameters in to local variables
	         String customerId = request.getParameter("customerId");
	         String accountId = request.getParameter("accountId");
	         String acctype= request.getParameter("acctype");
	         String inDeposit = request.getParameter("inDeposit");
	         String minBalance= request.getParameter("minBalance");
	         String overdraftAmount= request.getParameter("overdraftAmount");
	         
	         
	         RegisterAccount registerBean = new  RegisterAccount();
	        
	         registerBean.setCustomerId(customerId);
	         registerBean.setAccountId(accountId);
	         registerBean.setAcctype(acctype);
	         registerBean.setInDeposit(inDeposit);
	         registerBean.setMinBalance(minBalance); 
	         registerBean.setOverdraftAmount(overdraftAmount); 
	         
	         AccountDao registerDao = new   AccountDao();
	           
	         
	        //The core Logic of the open account application is present here. We are going to insert user data in to the database.
	         String userRegistered = registerDao.openAccount(registerBean);
	         
	         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
	            request.getRequestDispatcher("/Home.jsp").forward(request, response);
	         }
	         else   //On Failure, display a meaningful message to the User.
	         {System.out.println("open account eerror");
	            request.setAttribute("errMessage", userRegistered);
	            request.getRequestDispatcher("/Register.jsp").forward(request, response);
	         }
	     }
	}



