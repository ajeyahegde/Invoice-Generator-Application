<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,databaseClient.SqlClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/formdesign1.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<%
	int id;
	id=Integer.parseInt(request.getParameter("id"));	
	SqlClient sql=new SqlClient();
	if(id==1)
	{	
	String aname,aaddress,aphone,apan,amobile;
	aname=request.getParameter("author");
	aaddress=request.getParameter("aaddress");
	aphone=request.getParameter("aphone");
	amobile=request.getParameter("amobile");
	apan=request.getParameter("apan");
	sql.UpdateAuthor(aname, aaddress, apan, amobile, aphone);
	Thread.sleep(2000);
	out.println("<h1>Author Details Updated</h1>");
	}
	else if(id==2)
	{
		String author="",pname="",bname;
		int price=0,pages=0,year=0,quantity=0,bno=0;
		author=request.getParameter("author");
		pname=request.getParameter("pname");
		bname=request.getParameter("book");
		price=Integer.parseInt(request.getParameter("price"));
		pages=Integer.parseInt(request.getParameter("pages"));
		year=Integer.parseInt(request.getParameter("year"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		bno=Integer.parseInt(request.getParameter("bno"));
		sql.UpdateBooks(bname, author, quantity, pname, price, pages, year, bno);
		out.println("<h1>Book Details Updated</h1>");
	}
	else if(id==3)
	{
		String pname,paddress,owner;
		pname=request.getParameter("prakashana");
		paddress=request.getParameter("paddress");
		owner=request.getParameter("owner");
		sql.UpdatePrakashana(pname, owner, paddress);
		out.println("<h1>Prakashana Details Updated</h1>");
	}
	else if(id==4)
	{
		String cname,caddress,cphone;
		cname=request.getParameter("cname");
		caddress=request.getParameter("customer");
		cphone=request.getParameter("cphone");
		sql.UpdateCustomer(cname, cphone, caddress);
		out.println("<h1>Customer Details Updated</h1>");
	}
%>
</body>
</html>