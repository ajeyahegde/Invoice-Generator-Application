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
	String id,prakashana;
	id=request.getParameter("id");
	prakashana=request.getParameter("prakashana");
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getPrakashanaDetails(prakashana);
	String paddress="",owner="";
	while(rs.next())
	{
		paddress=rs.getString(3);
		owner=rs.getString(2);
	}
%>
<form action="EditDetails.jsp" method="get">
Prakashana Details
<br>Prakashana Name<input type="text" disabled="disabled" name="pname" value="<%=prakashana%>">
<br>Enter Owner Name<input type="text" name="owner" value="<%=owner%>">
<br>Enter Address<input type="text" name="paddress" value="<%=paddress%>">
<input type="hidden" name="id" value="<%=id%>">
<input type="hidden" name="prakashana" value="<%=prakashana%>">
<br><input type="submit" value="Update Prakashana details">
</form>

</body>
</html>