<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">welcome to order page</h1>
<hr>
<form action="processOrder">
	<div align = "center">
		<label for="item_name">Item Name:</label> <input type="text"
			name="foodType" placeholder="put your order" id="item_name">
		<input type="submit" value="orderNow">
	</div>
</form>
</body>
</html> 