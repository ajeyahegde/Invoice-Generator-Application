<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,databaseClient.SqlClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/ViewDesign.css" rel="stylesheet" type="text/css"/>
</head>
<script>
var total=0;
function findtotal(count,price)
{
	var currentqty=document.getElementById(""+count).value;
	if(currentqty=="")
		{
		currentqty=0;
		}
	total=total+(parseInt(currentqty)*price);
	document.getElementById("total").value=total;
}
</script>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Firstmenu.html">HOME</a>
<h1>SELECT NUMBER OF COPIES OF BOOKS</h1>
<form action="PrintBill.jsp" method="get">
<%String pname,date,billno,cname;
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
pname=request.getParameter("pname").toString();
date=request.getParameter("date");
billno=request.getParameter("billno");
cname=request.getParameter("cname").toString();
SqlClient s=new SqlClient();
ResultSet rs=s.getPrakashanaBookListDetails(pname);
int i=0,count=0,price;
ArrayList<String> p=new ArrayList<String>();
ArrayList<String> pnames=new ArrayList<String>();
ArrayList<Integer> prices=new ArrayList<Integer>();
while(rs.next())
{
	pnames.add(rs.getNString(1));
	prices.add(rs.getInt(3));
	out.println("<br>"+rs.getNString(1)+" - ");
	count++;
	price=rs.getInt(3);
	out.println(price);%>
<input type="text" name="<%=i%>" id="<%=i%>" onchange="findtotal(<%=i%>,<%=price%>)" style="width:50%;">	
<%
	i++;
}
count=i;
%>
<br>Total is :<input type="text" name="total" id="total">
<input type="hidden" name="count" value="<%=count%>">
<input type="hidden" name="cname" value="<%=cname%>">
<input type="hidden" name="pname" value="<%=pname%>">
<input type="hidden" name="billno" value="<%=billno%>">
<input type="hidden" name="date" value="<%=date%>">
<input type="hidden" name="pnames" value="<%=pnames%>">
<input type="hidden" name="prices" value="<%=prices%>">
<br><input type="submit" value="Create">
</form>
</body>
</html>