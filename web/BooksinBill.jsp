<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*,databaseClient.SqlClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RePrintBill.jsp">
<%
	String date,cname,pname;
	int total,billno;
	date=request.getParameter("date");
	cname=request.getParameter("caddress");
	pname=request.getParameter("pname");
	total=Integer.parseInt(request.getParameter("total"));
	billno=Integer.parseInt(request.getParameter("billno"));
	ResultSet rs,rs1;
	SqlClient sql=new SqlClient();
	rs=sql.getBillBooks(billno);
	ArrayList<String> pnames=new ArrayList<String>();
	ArrayList<Integer> prices=new ArrayList<Integer>();
	int quantity[]=new int[50];
	int count=0,i;
	String bookname;
	while(rs.next())
	{
		bookname=rs.getString(2);
		pnames.add(count,bookname);
		quantity[count]=rs.getInt(3);
		rs1=sql.getBookDetails(bookname);
		while(rs1.next())
			prices.add(count,rs1.getInt(3));
		count++;
	}
%>
<%for(i=0;i<count;i++)
{%>
<input type="hidden" name="<%=pnames.get(i)%>" value="<%=quantity[i]%>">
<%}%>	
<input type="hidden" name="count" value="<%=count%>">
<input type="hidden" name="cname" value="<%=cname%>">
<input type="hidden" name="pname" value="<%=pname%>">
<input type="hidden" name="billno" value="<%=billno%>">
<input type="hidden" name="date" value="<%=date%>">
<input type="hidden" name="pnames" value="<%=pnames%>">
<input type="hidden" name="prices" value="<%=prices%>">
<input type="hidden" name="total" value="<%=total%>">
<input type="submit" value="Print Bill">
</form>
</body>
</html>