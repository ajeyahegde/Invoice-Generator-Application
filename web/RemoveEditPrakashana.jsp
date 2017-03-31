<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.sql.*,databaseClient.SqlClient" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath()%>/ViewDesign.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<form name="form1" action="blank.jsp">
<table>
<%
	SqlClient sql=new SqlClient();
	ResultSet rs;
	rs=sql.getPrakashanaTable();
	String prakashana;
	while(rs.next())
	{
%>
<tr>
<td>
<% 		
		prakashana=rs.getNString(1);
		out.println("<br>"+prakashana);	
%>
</td>
<td><input type="button" value="delete" name="button2" onclick="func1('<%=prakashana%>')"></td>
<td><input type="button" value="edit" name="button1" onclick="func2('<%=prakashana%>')"></td>
</tr>
<%
}
%>
</table>
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