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
	String id=request.getParameter("id");
	String bookname=request.getParameter("book");
	ResultSet rs;
	String author="",pname="";
	int price=0,pages=0,year=0,quantity=0,bno=0;
	SqlClient sql=new SqlClient();
	rs=sql.getBookDetails(bookname);
	while(rs.next())
	{
		author=rs.getNString(2);
		pname=rs.getNString(7);
		price=rs.getInt(3);
		pages=rs.getInt(5);
		quantity=rs.getInt(4);
		year=rs.getInt(6);
		bno=rs.getInt(8);
	}
%>
<form action="EditDetails.jsp" method="get">
<br>ಪುಸ್ತಕದ ವಿವರಗಳು ನಮೂದಿಸಿ
<br>ಪುಸ್ತಕದ ಹೆಸರು:<input type="text" disabled="disabled" name="bname" value="<%=bookname%>">
<br>ಪುಸ್ತಕದ ಲೇಖಕರ ಹೆಸರು: <input type="text" name="author" value="<%=author%>">
<br>ಪುಸ್ತಕದ ಬೆಲೆ :<input type="text" name="price" value="<%=price%>">
<br>ಪುಸ್ತಕ ಪ್ರಮಾಣ :<input type="text" name="quantity" value="<%=quantity%>">
<br>ಪುಸ್ತಕದ ಪುಟಗಳ ಸಂಖ್ಯೆ :<input type="text" name="pages" value="<%=pages%>">
<br>ಪುಸ್ತಕದ ಬಿಡುಗಡೆಯಾದ ವರ್ಷ: <input type="text" name="year" value="<%=year%>">
<br>ಪುಸ್ತಕದ ಪ್ರಕಾಶನ ಹೆಸರು:<input type="text" name="pname" value="<%=pname%>">
<br>ಪುಸ್ತಕ ಆಯ್ಕೆ ಸಂಖ್ಯೆ :<input type="text" name="bno" value="<%=bno%>">

<input type="hidden" name="id" value="<%=id%>">
<input type="hidden" name="book" value="<%=bookname%>">
<br><input type="submit" value="Update Book Details">
</form>


</body>
</html>