<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>account</title>
<script type="text/javascript"> 
function validate()
{ 
     var custid = document.form.customerId.value;
     var accid = document.form.accountId.value;
     var acctype = document.form.acctype.value;
     var initdeposit = document.form.inDeposit.value;
     var minbal = document.form.minBalance.value;
     var overdraft = document.form.overdraftAmount.value;
     
     
     if (custid==null || custid=="")
     { 
     alert("Customer id  can't be blank"); 
     document.form.custid.focus();
     return false; 
     }
     if (accid==null || accid=="")
     { 
     alert("Account id  can't be blank");
     document.form.accid.focus(); 
     return false; 
     }
     if (acctype==null || acctype=="")
     { 
     alert("Account type can't be blank"); 
     return false;
     }
     if (initdeposit==null || initdeposit=="")
     { 
     alert("Initial Deposit can't be blank"); 
     return false; 
     }
     if (minbal==null || minbal=="")
     { 
     alert("Minimum Balance can't be blank"); 
     return false;
     }
      if (overdraft==null || overdraft=="")
     { 
     alert("OverDraft Amount can't be blank"); 
     return false;
     }
     if(custid.length>12 ||custid.length<12)
     { 
     alert("custmor id  must be 12 characters long."); 
     return false; 
     } 
      
     } 
 } 
</script> 
</head>
<body>
<center><h2>Open Account Form  </h2></center>
    <form name="form" action="AccountServlet" method="post">
        <table align="center">
         <tr>
         <td>Customer Id</td>
         <td><input type="text" name="customerId" /></td>
         </tr>
         <tr>
         <td>Account Id</td>
         <td><input type="password" name="accountId" /></td>
         </tr>
         <tr>
                    <td >Account Type</td>
                    <td ><input type="radio" name="acctype" 
                        value="saving" checked>Saving Account</td>
                    <td><input type="radio" name="acctype" value="current" 
					    >Current Account</td>
                    
                </tr>
         <tr>
         <td>Initial Deposit Account</td>
         <td><input type="text" name="inDeposit" /></td>
         </tr>
         <tr>
         <td>Minimum balance</td>
         <td><input type="text" name="minBalance" /></td>
         </tr>
         <tr>
         <td>OverDraft Amount</td>
         <td><input type="text" name="overdraftAmount" /></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" onclick="return validate();" value="Open Account"></input><br/ >
         <input   type="reset" value="Reset"></input></td>
         </tr>
        </table>
        
       

</body>
</html>