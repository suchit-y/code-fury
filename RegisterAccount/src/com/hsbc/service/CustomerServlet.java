package com.hsbc.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import com.hsbc.dao.AccountDao;
import com.hsbc.dao.CustomerDao;
import com.hsbc.entity.RegisterAccount;
import com.hsbc.entity.RegisterCustomer;
	 
	public class CustomerServlet extends HttpServlet {
	 
	     public CustomerServlet() {
	     }
	 
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //Copying all the input parameters in to local variables
	         String CUST_ID = request.getParameter("CUST_ID");
	         String CUSTOMER_NAME = request.getParameter("CUSTOMER_NAME");
	         String PAN= request.getParameter("PAN");
	         String DOB= request.getParameter("DOB");
	         String MOBILE= request.getParameter("MOBILE");
	         String EMAIL= request.getParameter("EMAIL");
	         String ALT_MOBILE= request.getParameter("ALT_MOBILE");
	         String ALT_EMAIL= request.getParameter("ALT_EMAIL");
	         
	         
	         RegisterCustomer custBean = new  RegisterCustomer();
	        
	         custBean.setCUST_ID(CUST_ID);
	         custBean.setCUSTOMER_NAME(CUSTOMER_NAME);
	         custBean.setPAN(PAN);
	         custBean.setDOB(DOB);
	         custBean.setMOBILE(MOBILE); 
	         custBean.setEMAIL(EMAIL); 
	         custBean.setALT_MOBILE( ALT_MOBILE);  
	         custBean.setALT_EMAIL(ALT_EMAIL); 
	         
	         CustomerDao custDao = new   CustomerDao();
	           
	         
	        //The core Logic of the open account application is present here. We are going to insert user data in to the database.
	         String customerRegistered = custDao.custDetails(custBean);
	         
	         if(customerRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
	            request.getRequestDispatcher("/Register.jsp").forward(request, response);
	         }
	         else   //On Failure, display a meaningful message to the User.
	         {System.out.println("customer db eerror");
	            request.setAttribute("errMessage", customerRegistered);
	            //request.getRequestDispatcher("/").forward(request, response);
	         }
	     }
	}



