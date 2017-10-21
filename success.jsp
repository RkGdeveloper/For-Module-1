<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booked Page</title>
</head>
<body>

<h1>Show is Booked, below are the details:</h1>

Show Name : <c:out value="${showName}"></c:out><br/>
Customer Name :<c:out value="${custName}"></c:out><br/>
Mobile Number :<c:out value="${mobile} "></c:out> <br/>
No. of Seats : <c:out value="${seats} "></c:out> <br/>
Total Price : <c:out value="${totalP} "></c:out> <br/>


<br/>

<a href = "ShowController?action=getAll">Go back to Home</a>
</body>
</html>