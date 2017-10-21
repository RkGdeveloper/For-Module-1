<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Show </title>
</head>
<body>
	<h1> List of Magic Show</h1>
<br/>

<table border="3">
	<tr>
	<th>ShowName</th>
	<th>Location</th>
	<th>Date</th>
	<th>Price</th>
	<th>Available Seats</th>
	<th>Book</th>
	</tr>
<c:forEach items="${alShow}" var="sb">
	
	<tr>
		<td><c:out value="${sb.getShowName()}"></c:out></td>
		<td><c:out value="${sb.getLocation()}"></c:out></td>
		<td><c:out value="${sb.getShowDate()}"></c:out></td>
		<td><c:out value="${sb.getPriceTicket()}"></c:out></td>
		<td><c:out value="${sb.getAvSeats()}"></c:out></td>
		<td></td>
	</tr>
</c:forEach>
</table>
	
</body>
</html>
