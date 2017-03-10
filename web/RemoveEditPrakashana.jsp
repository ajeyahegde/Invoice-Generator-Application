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
	rs=sql.getPrakashanaTable();
	String prakashana;
	while(rs.next())
	{
		prakashana=rs.getString(1);
		out.println("<br>"+prakashana);	
%>

<input type="button" value="delete" name="button2" onclick="func1('<%=prakashana%>')">
<input type="button" value="edit" name="button1" onclick="func2('<%=prakashana%>')">
<%
}
%>
<input type="hidden" value="3" name="id">
<input type="hidden" id="prakashana" name="prakashana">
</form>
</body>
<script>
function func1(name)
{
	var x=name;
	document.getElementById("prakashana").value=x;
	document.form1.action="DeleteDetails.jsp";
	form1.submit();
}
function func2(name)
{
	document.getElementById("prakashana").value=name;
	document.form1.action="EditPrakashana.jsp";
	form1.submit();
}

</script>
</html>