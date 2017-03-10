<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,databaseClient.SqlClient" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id"));
	SqlClient sql=new SqlClient();
	if(id==1)
	{
		String author=request.getParameter("author");
		sql.RemoveAuthor(author);
		out.println(id);
		out.println("Deleted author is "+author);
		Thread.sleep(5000);
		response.sendRedirect("RemoveEditAuthors.jsp");
	}
	else if(id==2)
	{
		String book=request.getParameter("book");
		sql.RemoveBook(book);
		out.println(id);
		out.println("Deleted prakashana is "+book);
		Thread.sleep(5000);
		response.sendRedirect("RemoveEditBooks.jsp");
	}
	else if(id==3)
	{
		String prakashana=request.getParameter("prakashana");
		sql.RemovePrakashana(prakashana);
		out.println(id);
		out.println("Deleted prakashana is "+prakashana);
		Thread.sleep(5000);
		response.sendRedirect("RemoveEditPrakashana.jsp");
	}
	else if(id==4)
	{
		String customer=request.getParameter("customer");
		sql.RemoveCustomer(customer);
		out.println(id);
		out.println("Deleted customer is "+customer);
		Thread.sleep(5000);
		response.sendRedirect("RemoveEditCustomers.jsp");
	}
%>

</body>
</html>