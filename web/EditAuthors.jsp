<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="databaseClient.SqlClient,java.sql.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	String author=request.getParameter("author");
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getAuthorDetails(author);
	String aname="",aaddress="",aphone="",apan="",amobile="";
	while(rs.next())
	{
		aaddress=rs.getString(2);
		aphone=rs.getString(3);
		apan=rs.getString(4);
		amobile=rs.getString(5);
	}
%>
<form action="EditDetails.jsp">
Author Name :<input type="text" disabled="disabled" name="aname" value="<%=author%>"><br>
Enter Author's Address<input type="text" name="aaddress" value="<%=aaddress%>"><br>
Enter Author's Phone No<input type="text" name="aphone" value="<%=aphone%>"><br>
Enter Author's Mobile No<input type="text" name="amobile" value="<%=amobile%>"><br>
Enter Author's Pan Card<input type="text" name="apan" value="<%=apan%>"><br>
<input type="hidden" name="author" value="<%=author%>">
<input type="hidden" name="id" value="<%=id%>"> 
<input type="submit" value="Enter Details">
</form>
</body>
</html>