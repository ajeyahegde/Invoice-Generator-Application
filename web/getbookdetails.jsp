<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="databaseClient.SqlClient,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/formdesign1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	SqlClient sql=new SqlClient();
	ResultSet rs=sql.getAuthorTable();
	int i=0,authorcount=0,prakashanacount=0;
	String[] authornames=new String[10];
	String[] prakashananames=new String[10];
	while(rs.next())
	{
		authornames[i]=rs.getNString(1);
		authorcount++;
		i++;
	}
	rs=sql.getPrakashanaTable();
	i=0;
	while(rs.next())
	{
		prakashananames[i]=rs.getNString(1);
		prakashanacount++;
		i++;
	}
%>
<a style="margin-left:90%;margin-top:10%;" href="Homepage.html">HOME</a>
<form action="EnterBookDetail" method="get">
<br><h1>ಪುಸ್ತಕದ ವಿವರಗಳು ನಮೂದಿಸಿ</h1>
<br>ಪುಸ್ತಕದ ಹೆಸರು:<input type="text" name="bname">
<br>ಪುಸ್ತಕದ ಲೇಖಕರ ಹೆಸರು: 
<select name="author">
	<%for(i=0;i<authorcount;i++){
		String s2=authornames[i];
	%>
	<option value="<%=s2 %>"><%=s2 %></option>
	<%}%>
</select>
<br>ಪುಸ್ತಕದ ಬೆಲೆ :<input type="text" name="price">
<br>ಪುಸ್ತಕ ಪ್ರಮಾಣ [STOCK]:<input type="text" name="quantity">
<br>ಪುಸ್ತಕದ ಪುಟಗಳ ಸಂಖ್ಯೆ :<input type="text" name="pages">
<br>ಪುಸ್ತಕದ ಬಿಡುಗಡೆಯಾದ ವರ್ಷ: <input type="text" name="year">
<br>ಪುಸ್ತಕದ ಪ್ರಕಾಶನ ಹೆಸರು:
<select name="pname">
	<%for(i=0;i<prakashanacount;i++){
		String s2=prakashananames[i];
	%>
	<option value="<%=s2 %>"><%=s2 %></option>
	<%}%>
</select>
<br>ಪುಸ್ತಕ ಆಯ್ಕೆ ಸಂಖ್ಯೆ :<input type="text" name="bno">
<br><input type="submit" value="ಪುಸ್ತಕದ ವಿವರಗಳು ನಮೂದಿಸಿ">
</form>
<br><a href="https://www.google.com/inputtools/try/">Type Kannada Here</a><br>


</body>
</html>