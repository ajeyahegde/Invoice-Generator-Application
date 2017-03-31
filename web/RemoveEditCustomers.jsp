<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.sql.*,databaseClient.SqlClient" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/ViewDesign.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<form name="form1" action="blank.jsp">
<table>
<%
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getCustomerTable();
	String customer;
	int i=0;
	while(rs.next())
	{
%>
<tr>
<td>
<%
		customer=rs.getNString(2);
		out.println("<br>"+customer);	
%>
</td>
<td><input type="button" value="delete" name="button2" onclick="func1('<%=customer%>')"></td>
<td><input type="button" value="edit" name="button1" onclick="func2('<%=customer%>')"></td>
</tr>
<%
}
%>
</table>
<input type="hidden" value="4" name="id">
<input type="hidden" id="customer" name="customer">
</form>
</body>
<script>
function func1(name)
{
	var x=name;
	document.getElementById("customer").value=x;
	document.form1.action="DeleteDetails.jsp";
	form1.submit();
}
function func2(name)
{
	document.getElementById("customer").value=name;
	document.form1.action="EditCustomers.jsp";
	form1.submit();
}

</script>
</html>