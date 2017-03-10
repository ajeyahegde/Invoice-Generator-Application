<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,databaseClient.SqlClient" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String customer,id;
	customer=request.getParameter("customer");
	id=request.getParameter("id");
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getCustomerDetails(customer);
	String cname="",cphone="";
	while(rs.next())
	{
		cname=rs.getString(1);
		cphone=rs.getString(3);
	}
%>
<form action="EditDetails.jsp" method="get">
Customer Details
<br>Customer<input type="text" disabled="disabled" name="caddress" value="<%=customer%>">
<br>Enter Customer Name<input type="text" name="cname" value="<%=cname%>">
<br>Enter Customer Phone Number<input type="text" name="cphone" value="<%=cphone%>">
<input type="hidden" value="<%=customer%>" name="customer">
<input type="hidden" value="<%=id%>" name="id">
<br><input type="submit" value="Update Customer details">
</form>

</body>
</html>