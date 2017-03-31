<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,databaseClient.SqlClient" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/formdesign1.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
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
		cname=rs.getNString(1);
		cphone=rs.getNString(3);
	}
%>
<form action="EditDetails.jsp" method="get">
ಗ್ರಾಹಕರ ವಿವರಗಳನ್ನು ನಮೂದಿಸಿ
<br>ಗ್ರಾಹಕರ ವಿಳಾಸ :<input type="text" disabled="disabled" name="caddress" value="<%=customer%>">
<br>ಗ್ರಾಹಕರ ಹೆಸರು:<input type="text" name="cname" value="<%=cname%>">
<br>ಗ್ರಾಹಕರ ದೂರವಾಣಿ ಸಂಖ್ಯೆ:<input type="text" name="cphone" value="<%=cphone%>">
<input type="hidden" value="<%=customer%>" name="customer">
<input type="hidden" value="<%=id%>" name="id">
<br><input type="submit" value="Update Customer details">
</form>

</body>
</html>