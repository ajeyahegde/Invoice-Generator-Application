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
	String id=request.getParameter("id");
	String bookname=request.getParameter("book");
	ResultSet rs;
	String author="",pname="";
	int price=0,pages=0,year=0,quantity=0,bno=0;
	SqlClient sql=new SqlClient();
	rs=sql.getBookDetails(bookname);
	while(rs.next())
	{
		author=rs.getString(2);
		pname=rs.getString(7);
		price=rs.getInt(3);
		pages=rs.getInt(5);
		quantity=rs.getInt(4);
		year=rs.getInt(6);
		bno=rs.getInt(8);
	}
%>
<form action="EditDetails.jsp" method="get">
<br>Book Details
<br>Book Name<input type="text" disabled="disabled" name="bname" value="<%=bookname%>">
<br>Enter Author Name<input type="text" name="author" value="<%=author%>">
<br>Enter Book Price<input type="text" name="price" value="<%=price%>">
<br>Enter Book Quantity<input type="text" name="quantity" value="<%=quantity%>">
<br>Enter Number of Pages<input type="text" name="pages" value="<%=pages%>">
<br>Enter Year of Release<input type="text" name="year" value="<%=year%>">
<br>Enter Prakashana Name<input type="text" name="pname" value="<%=pname%>">
<br>Enter Book Number<input type="text" name="bno" value="<%=bno%>">
<input type="hidden" name="id" value="<%=id%>">
<input type="hidden" name="book" value="<%=bookname%>">
<br><input type="submit" value="Update Book Details">
</form>


</body>
</html>