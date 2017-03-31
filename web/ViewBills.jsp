<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*,databaseClient.SqlClient" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/ViewDesign.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<h1>BILLS</h1>
<table style="border:1px solid black; width:100%">
<tr>
<th>BILLNO</th>
<th>TOTAL</th>
<th>DATE</th>
<th>CUSTOMER</th>
<th>STATUS</th>
<th>PRAKASHANA</th>	
<th>VIEW</th>
</tr>
<%
	ResultSet rs;
	SqlClient sql=new SqlClient();
	rs=sql.getBillDetailsTable();
	int billno,total;
	String date,caddress,pname,status;
	boolean s;
	while(rs.next())
	{
		billno=rs.getInt(1);
		total=rs.getInt(2);
		date=rs.getDate(3).toString();
		s=rs.getBoolean(4);
		if(s==true)
			status="PAID";
		else
			status="NOT PAID";
		caddress=rs.getString(5);
		pname=rs.getString(6);			
%>
<tr>
	<td><%=billno%></td>
	<td><%=total%></td>
	<td><%=date%></td>
	<td><%=caddress%></td>
	<td><%=pname%></td>
	<td><%=status%></td>
	<td><a style="margin-left:0%;" href="BooksinBill.jsp?billno=<%=billno%>&total=<%=total%>&date=<%=date%>&caddress=<%=caddress%>&pname=<%=pname%>">VIEW</a></td>
</tr>
<%
}
%>	
</table>

</body>
</html>