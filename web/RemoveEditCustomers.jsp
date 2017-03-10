<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.sql.*,databaseClient.SqlClient" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action="blank.jsp">
<%
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getCustomerTable();
	String customer;
	int i=0;
	while(rs.next())
	{
		customer=rs.getString(2);
		out.println("<br>"+customer);	
%>

<input type="button" value="delete" name="button2" onclick="func1('<%=customer%>')">
<input type="button" value="edit" name="button1" onclick="func2('<%=customer%>')">
<%
}
%>
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