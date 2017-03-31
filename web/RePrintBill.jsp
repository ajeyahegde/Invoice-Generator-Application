<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,databaseClient.SqlClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Table.css">
</head>
<body>
<%!	String paddress="",caddress="",cphone="" ;%>
<%
	
	int count=Integer.parseInt(request.getParameter("count"));
	int i;
	String s1,s2;
	ArrayList<Integer> price=new ArrayList<Integer>();
	String priceArray1=request.getParameter("prices").toString();
	String[] priceArray2= priceArray1.substring(1, priceArray1.length() - 1).split("\\,");
	ArrayList<String> books=new ArrayList<String>();
	String booksArray1=request.getParameter("pnames").toString();
	String[] booksArray2=booksArray1.substring(1, booksArray1.length()-1).split("\\,");
	int prices[]=new int[100];
	int no=0;
	for(i=0;i<count;i++)
	{
		System.out.println(priceArray2[i]+booksArray2[i]);
		priceArray2[i]=priceArray2[i].trim();
		prices[i]=Integer.parseInt(priceArray2[i]);
		booksArray2[i]=booksArray2[i].trim();
		price.add(i,Integer.parseInt(priceArray2[i]));
		books.add(i,booksArray2[i]);
		System.out.println(priceArray2[i]+booksArray2[i]);
	}
	String cname=request.getParameter("cname");
	String pname=request.getParameter("pname");
	String date=request.getParameter("date");
	int billno=Integer.parseInt(request.getParameter("billno"));
	String[] author=new String[100];
	int[] total=new int[100];
	int[] quantity=new int[100];
	int[] bookno=new int[100];
	SqlClient sql=new SqlClient();
	ResultSet rs;
	int finaltotal=Integer.parseInt(request.getParameter("total"));
	for(i=0;i<count;i++)
	{
		s1=booksArray2[i];
		try{
		rs=sql.getBookDetails(s1);
		while(rs.next())
		{
		bookno[i]=rs.getInt(8);
		author[i]=rs.getNString(2);
		quantity[i]=Integer.parseInt(request.getParameter(s1));
		total[i]=prices[i]*quantity[i];
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception called");
		}
	}
	try{
	rs=sql.getPrakashanaDetails(pname);
	while(rs.next())
	{
		paddress=rs.getNString(3);
	}
	rs=sql.getCustomerDetails(cname);
	while(rs.next())
	{
		cname=rs.getNString(1);
		caddress=rs.getNString(2);
		cphone=rs.getNString(3);
	}	
	}catch(Exception e)
	{
		System.out.println("Exception in FindTotal");
	}
	%>
<div align="center">
<table style="border:1px solid black; text-align:left; width:100%;table-layout:fixed;">
<tr>
	<td style="width:50%"><%=pname%><br><%=paddress%> </td>
	<td style="width:50%">Date: <%=date%><br>BillNo: <%=billno%><br><%=cname %><br><%=caddress%><br><%=cphone%></td>
</tr>
</table>
</div>	
<table style="width:100%; border:1px solid black; text-align:left">
<tr>
<th>Sl No</th>
<th>BookNo</th>
<th>BookName</th>
<th>Author</th>
<th>Price</th>
<th>Quantity</th>
<th>Total</th>
</tr>
<%for(i=0,no=1;i<count;i++)
{
	if(quantity[i]==0)
		continue;
%>
<tr style="border:0px solid black;">
	<td style="border-bottom-style:hidden;"><%=no%></td>
	<td style="border-bottom-style:hidden;"><%=bookno[i]%>
	<td style="border-bottom-style:hidden;"><%=booksArray2[i] %></td>
	<td style="border-bottom-style:hidden;"><%=author[i] %>
	<td style="border-bottom-style:hidden;"><%=prices[i] %></td>
	<td style="border-bottom-style:hidden;"><%=quantity[i]%></td>
	<td style="border-bottom-style:hidden;"><%=total[i]%></td>
</tr>	
<%
no++;
} %>
</table>
<table style="width:100%;text-align:right;table-layout:fixed;"><tr>
<td style="width:91%;">Grand Total:</td>
<td>
<%out.println(finaltotal);
%></td>
</tr>
</table>
<br><button onclick="printscreen()" id="printbutton">Print Bill</button>
<script>
function printscreen()
{
	document.getElementById('printbutton').style.visibility='hidden';
	window.print();
	document.getElementById('printbutton').style.visibility='visible';
}
</script>
</body>
</html>