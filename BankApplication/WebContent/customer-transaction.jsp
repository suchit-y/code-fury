<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Transaction</title>
</head>
<body>
	<form action="CustomerServiceController" method="post">
		<table>
			<tr>
				<td><Label>Sender's Account Id</Label></td>
				<td><select name="senderAccId">
						<option value=1001>1001</option>
						<option value=1002>1002</option>
						<option value=1003>1003</option>
				</select></td>
			</tr>
			<tr>
				<td><Label>Receiver's Account Id</Label></td>
				<td><input type="text" name="receiverAccId"></td>
			</tr>
			<tr>
				<td><Label>Amount</Label></td>
				<td><input type="text" name="amount"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="transact"></td>
			</tr>
		</table>
	</form>
</body>
</html>