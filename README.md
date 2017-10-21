<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Now Details</title>
</head>
<body>

	<h1>Booking Form</h1>
	<form action ="ShowController" method="post">	
	
		Show Name: <input type= "text" value="${sBean.getShowName()}" name="showName"> <br/>
		Price Per Ticket: <input type = "text" value="${sBean.getPriceTicket()}" name="priceTicket"/><br/>
		Customer Name : <input type="text" name ="cname"/><br/>
		Mobile Number : <input type="text" name ="mobNum"/><br/>
		Seat Available : <input type="text" value="${sBean.getAvSeats()}" name ="avSeat"><br/>
		No. of Seats to Book :<input type="text" name="noOfSeat"/> <br/>
		
	<input type="submit" value="BookNow" name="action"/> 
	</form>
</body>
</html>
