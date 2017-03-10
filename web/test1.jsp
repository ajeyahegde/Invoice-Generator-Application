<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<%
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8","root","root");
		String s1,s2,s3;
		Statement stmt = (Statement) con.createStatement();
	    stmt.executeQuery("SET NAMES 'UTF8'");
	    stmt.executeQuery("SET CHARACTER SET 'UTF8'");
		if(!con.isClosed())
			System.out.println("Connected to databsae");
		PreparedStatement ps=con.prepareStatement("insert into prakashana value(?,?,?)");
		s1="aaaa";
		s2="ಸೀತಾರಾಮ";
		s3="ಬೆಂಗಳೂರು";
		InputStream stream1= new ByteArrayInputStream(s1.getBytes("UTF-8"));
		InputStream stream2 = new ByteArrayInputStream(s2.getBytes("UTF-8"));
		InputStream stream3 = new ByteArrayInputStream(s3.getBytes("UTF-8"));
	/*	ps.setUnicodeStream(1, stream1, stream1.available());
		ps.setUnicodeStream(2, stream2, stream2.available());
		ps.setUnicodeStream(3, stream3, stream3.available());
	*/
		ps.setNString(1, s1);
		ps.setNString(2, s2);
		ps.setNString(3, s3);
	    ps.execute();
		ResultSet rs=stmt.executeQuery("select * from prakashana");
		while(rs.next())
		{
			//out.println("<br>"+(rs.getUnicodeStream(1)).toString());
			out.println(rs.getCharacterStream(1).toString());
			out.println(rs.getNString(2));//"<br>"+(rs.getUnicodeStream(2)).toString());
			out.println(rs.getNString(3));//"<br>"+(rs.getUnicodeStream(3)).toString());
		}
	}catch(Exception e)
	{
		System.out.println("Exception"+e.getMessage());
	}

%>

</body>
</html>