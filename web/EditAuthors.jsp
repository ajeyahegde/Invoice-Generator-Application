<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="databaseClient.SqlClient,java.sql.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/formdesign1.css">
<title>Insert title here</title>
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	String author=request.getParameter("author");
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getAuthorDetails(author);
	String aname="",aaddress="",aphone="",apan="",amobile="";
	while(rs.next())
	{
		aaddress=rs.getNString(2);
		aphone=rs.getNString(3);
		apan=rs.getNString(4);
		amobile=rs.getNString(5);
	}
%>
<form action="EditDetails.jsp">
ಲೇಖಕರ ಹೆಸರು :<input type="text" disabled="disabled" name="aname" value="<%=author%>"><br>
ಲೇಖಕರ ವಿಳಾಸ :<input type="text" name="aaddress" value="<%=aaddress%>"><br>
ಲೇಖಕರ ಫೋನ್ :<input type="text" name="aphone" value="<%=aphone%>"><br>
ಲೇಖಕರ ಮೊಬೈಲ್ ಸಂಖ್ಯೆ:<input type="text" name="amobile" value="<%=amobile%>"><br>
ಲೇಖಕರ ಪ್ಯಾನ್ ಕಾರ್ಡ್ ಸಂಖ್ಯೆ :<input type="text" name="apan" value="<%=apan%>"><br>
<input type="hidden" name="author" value="<%=author%>">
<input type="hidden" name="id" value="<%=id%>"> 
<input type="submit" value="Enter Details">
</form>
</body>
</html>