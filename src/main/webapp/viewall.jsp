<%@page import="com.js.dto.Bike"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
	color: red;
}
</style>
</head>
<body>

<h1>
		<marquee behavoir="scroll" direction="right" scrollamount="	30">
			BIKES DISPLAYED IN THE SHOWROOM </marquee>
	</h1>
	<!--  <marquee behavoir="scroll" direction="right" scrollamount="	30"> -->
	<table style="border-color: chartreuse;" border="2px ">

		<tr>
			<th>Bike_no</th>
			<th>Bike_name</th>
			<th>Owner_name</th>
		
			
		</tr>
		<%
			ArrayList<Bike> ob1 = (ArrayList)request.getAttribute("name");
			for (Bike b : ob1) {
		%>
		<tr>
			<td><%=b.getBike_no() %></td>
			<td><%=b.getBike_name() %></td>
			<td><%=b.getOwner_name() %></td>
			
		</tr>
		<%}%>
	</table>
	</marquee>

	<a href="welcome.html"> GO BACK TO HOME</a>

</body>
</html>