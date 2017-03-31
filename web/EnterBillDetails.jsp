<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,databaseClient.SqlClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BILL DETAILS</title>
<link href="<%=request.getContextPath()%>/ViewDesign.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="SelectBooks.jsp" method="get">
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<h1>BILL DETAILS</h1>
ಪ್ರಕಾಶನ ಹೆಸರನ್ನು ಆಯ್ಕೆ ಮಾಡಿ
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
<br>ದಿನಾಂಕ [YYYY-MM-DD]:<input type="text" name="date" style="width:50%;">
<br>ಬಿಲ್ ಸಂಖ್ಯೆ :<input type="text" name="billno" style="width:50%;">
<br>ಗ್ರಾಹಕರ ಹೆಸರು ಆಯ್ಕೆ ಮಾಡಿ
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