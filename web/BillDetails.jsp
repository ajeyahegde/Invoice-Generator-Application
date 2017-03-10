<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,databaseClient.SqlClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BILL DETAILS</title>
</head>
<body>
<form action="SelectBooks.jsp" method="get">
Select Prakashana 
<%try{
	SqlClient s=new SqlClient();
	ResultSet rs=s.getPrakashanaTable();
	String s1;
	String pnames[];
	pnames=new String[]{""};
	ArrayList<String> ar=new ArrayList<String>(); 
	while(rs.next())
	{
		s1=rs.getString(1);
		ar.add(s1);
	}
	for(String s2:ar)
	{
		System.out.println(s2);
	}
	%>
<select name="pname">
	<option value="" selected>select</option>
	<%for(String s2:ar){
	%>
	<option value="<%=s2 %>"><%=s2 %></option>
	<%}%>
</select>
<%} catch(Exception e){}
%>
<br>Enter Date<input type="text" name="date">
<br>Enter Bill Number<input type="text" name="billno">
<br>Select Customer<br>
<%try{
	SqlClient s=new SqlClient();
	ResultSet rs=s.getCustomerTable();
	String s1;
	ArrayList<String> cnames=new ArrayList<String>(); 
	while(rs.next())
	{
		s1=rs.getString(2);
		cnames.add(s1);
	}
	for(String s2:cnames)
	{
		System.out.println(s2);
	}
	%>
<select name="cname">
	<option value="" selected>select</option>
	<%for(String s2:cnames){
	%>
	<option value="<%=s2 %>"><%=s2 %></option>
	<%}%>
</select>
<%} catch(Exception e){}
%>
<input type="submit" value="SUBMIT">
</form>
</body>
</html>