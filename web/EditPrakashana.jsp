<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*,databaseClient.SqlClient" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/formdesign1.css">
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<%
	String id,prakashana;
	id=request.getParameter("id");
	prakashana=request.getParameter("prakashana");
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getPrakashanaDetails(prakashana);
	String paddress="",owner="";
	while(rs.next())
	{
		paddress=rs.getNString(3);
		owner=rs.getNString(2);
	}
%>
<form action="EditDetails.jsp" method="get">
ಪ್ರಕಾಶನ ವಿವರಗಳನ್ನು ನಮೂದಿಸಿ
<br>ಪ್ರಕಾಶನ ಹೆಸರು:<input type="text" disabled="disabled" name="pname" value="<%=prakashana%>">
<br>ಪ್ರಕಾಶನ ಮಾಲೀಕರ ಹೆಸರು:<input type="text" name="owner" value="<%=owner%>">
<br>ಪ್ರಕಾಶನ ವಿಳಾಸ:<input type="text" name="paddress" value="<%=paddress%>">

<input type="hidden" name="id" value="<%=id%>">
<input type="hidden" name="prakashana" value="<%=prakashana%>">
<br><input type="submit" value="Update Prakashana details">
</form>

</body>
</html>