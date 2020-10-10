<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
      pageEncoding="ISO-8859-1"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <%@page import="java.sql.*" %>  
 <html>  
   <head>  
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
     <title>Insert title here</title>  
   </head>  
   <body>  
     <%  
       String consultant = request.getParameter("search").toString();  
       String buff1 = "<div id='hint'>";  
       String buff2 = "<input type='text' name='CUSTOMER_NAME' value=''>";  
       String buff3 = "<input type='text' name='PAN' value=''>";  
       String buff4 = "<input type='text' name='DOB' value=''>";  
       String buff5 = "<input type='text' name='MOBILE' value=''>";  
       String buff6 = "<input type='text' name='EMAIL' value=''>"; 
       String buff7 = "<input type='text' name='ALT_MOBILE' value=''>"; 
       String buff8 = "<input type='text' name='ALT_EMAIL' value=''>"; 
       try {  
         Class.forName("org.apache.derby.jdbc.ClientDriver");  
         Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/bankdata");  
         Statement stmt = conn.createStatement();  
         ResultSet rs = stmt.executeQuery("Select * from customer where CUST_ID='" + consultant +"'");  
         while (rs.next()) {  
           buff1 = "customer already exists" + "<br>";  
           buff2 = "<input type='text' name='CUSTOMER_NAME' value='" + rs.getString(2) + "'>";  
           buff3 = "<input type='text' name='PAN' value='" + rs.getString(3) + "'>";  
           buff4 = "<input type='text' name='DOB' value='" + rs.getString(4) + "'>";  
           buff5 = "<input type='text' name='MOBILE' value='" + rs.getString(5) + "'>";  
           buff6 = "<input type='text' name='EMAIL' value='" + rs.getString(6) + "'>";  
           buff7 = "<input type='text' name='ALT_MOBILE' value='" + rs.getString(7) + "'>";  
           buff8 = "<input type='text' name='ALT_EMAIL' value='" + rs.getString(8) + "'>";  
         }  
         System.out.println(buff1);
         buff1 = buff1 + "</div>";  
         buff2 = buff2 + "</input></div>";  
         buff3 = buff3 + "</input>";  
         buff4 = buff4 + "</input>";  
         buff5 = buff5 + "</input>";  
         buff6 = buff6 + "</input>";
         buff7 = buff7 + "</input>";
         buff8 = buff8 + "</input>";
         
         response.getWriter().println(buff1 + "brk" + buff2 + "brk" + buff3 + "brk" + buff4 + "brk" + buff5+ "brk" + buff6+ "brk" + buff7+ "brk" + buff8);  
       } catch (Exception e) {  
         System.out.println(e);  
       }  
     %>  
   </body>  
 </html>  