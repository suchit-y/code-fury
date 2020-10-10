<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
      pageEncoding="ISO-8859-1"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>  
   <head>  
     
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
     <title>Insert title here</title>  
   </head>  
   <body>  
     <form method="post" action="CustomerServlet">  
       <table> 
       <tr>  
           <td> Customer Id:</td>  
           <td><div id="CUST_ID"><input type="text" name="CUST_ID"   ></div></td>  
           
         </tr>   
       <tr>  
           <td> Customer Name:</td>  
           <td><div id="CUSTOMER_NAME"><input type="text" name="CUSTOMER_NAME" ></div></td>  
          
         </tr>  
         <tr>  
           <td>  PAN:</td>  
           <td><div id=" PAN"><input type="text" name=" PAN"></div></td>  
         </tr>
         <tr>  
           <td>  DOB:</td>  
           <td><div id=" DOB"><input type="text" name="DOB"></div></td>  
         </tr>  
         <tr> 
         <tr>  
           <td> Mobile No:</td>  
           <td><div id="MOBILE"><input type="text" name="MOBILE"></div></td>  
         </tr>  
         <tr>  
         <tr>  
           <td> Email Id:</td>  
           <td><div id="EMAIL"><input type="text" name="EMAIL" ></div></td>  
            
         </tr>  
         <tr>  
           <td>ALT_MOBILE:</td>  
           <td><div id="ALT_MOBILE"><input type="text" name="ALT_MOBILE"></div></td>  
         </tr>  
         <tr>  
           <td> ALT_EMAIL:</td>  
           <td><div id="ALT_EMAIL"><input type="text" name="ALT_EMAIL"></div></td>  
         </tr>  
         <td><input type="submit"  value=" Submit"></input><br/ ></td>
          
           
       </table>  
     </form>  
   </body>  
 </html>  