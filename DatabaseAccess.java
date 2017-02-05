package bills2;

import java.sql.*;

public class DatabaseAccess {
	static Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement ps;
	String s;
	public DatabaseAccess()
	{
	try{	
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	}catch(Exception e)
	{
		System.out.println("Exception called");
	}
	}
	public ResultSet getAuthorTable()
	{
		try{
		stmt=con.createStatement();
		s="select * from author";
		rs=stmt.executeQuery(s);
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getAuthorBookList(String authorname)
	{
		try{
		ps=con.prepareStatement("select bname from books where author=?");
		ps.setString(1, authorname);
		rs=ps.executeQuery();
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getAuthorDetails(String authorname)
	{
		try{
		ps=con.prepareStatement("select * from author where aname=?");
		ps.setString(1, authorname);
		rs=ps.executeQuery();
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getBooksTable()
	{
		try{
		stmt=con.createStatement();
		s="select * from books";
		rs=stmt.executeQuery(s);
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getBookDetails(String bookname)
	{
		try{
		s="select * from books where bname=?";
		ps=con.prepareStatement(s);
		ps.setString(1, bookname);
		rs=ps.executeQuery();
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getPrakashanaTable()
	{
		try{
		stmt=con.createStatement();
		s="select * from prakashana";
		rs=stmt.executeQuery(s);
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getPrakashanaDetails(String pname)
	{
		try{
		s="select * from prakashana where pname=?";
		ps=con.prepareStatement(s);	
		ps.setString(1, pname);
		rs=ps.executeQuery();
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getBillDetailsTable()
	{
		try{
		stmt=con.createStatement();
		s="select * from billdetails";
		rs=stmt.executeQuery(s);
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getBillBooksTable()
	{
		try{
		stmt=con.createStatement();
		s="select * from billbooks";
		rs=stmt.executeQuery(s);
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getCustomerTable()
	{
		try{
		stmt=con.createStatement();
		s="select * from customer";
		rs=stmt.executeQuery(s);
		}catch(Exception e){}
		return rs;
	}
	public ResultSet getCustomerDetails(String caddress)
	{
		try{
		s="select * from customer where caddress=?";
		ps=con.prepareStatement(s);
		ps.setString(1, caddress);
		rs=ps.executeQuery();
		}catch(Exception e){}
		return rs;
	}
	public void setAuthorDetails(String aname,String aaddress,String aphone,String amobile,String apan)
	{
		try{
		s="insert into author values(?,?,?,?,?)";
		ps=con.prepareStatement(s);
		ps.setString(1, aname);
		ps.setString(2, aaddress);
		ps.setString(3, aphone);
		ps.setString(4, apan);
		ps.setString(5, amobile);
		ps.execute();
		}catch(Exception e){}
	}
	public void setBookDetails(String bname,String author,int price,int quantity,int pages,int year,String pname)
	{
		try{
		s="insert into books values(?,?,?,?,?,?,?)";
		ps=con.prepareStatement(s);
		ps.setString(1, bname);
		ps.setString(2, author);
		ps.setInt(3, price);
		ps.setInt(4, quantity);
		ps.setInt(5, pages);
		ps.setInt(6, year);
		ps.setString(7, pname);
		ps.execute();
		}catch(Exception e){}
	}
	public void setPrakashanaDetails(String pname,String owner,String paddress)
	{
		try{
		s="insert into prakashana values(?,?,?)";
		ps=con.prepareStatement(s);
		ps.setString(1, pname);
		ps.setString(2, owner);
		ps.setString(3, paddress);
		ps.execute();
		}catch(Exception e){}
	}
	public void setCustomerDetails(String cname,String cphone,String caddress)
	{
		try{
		s="insert into customer values(?,?,?)";
		ps=con.prepareStatement(s);
		ps.setString(1, cname);
		ps.setString(2, caddress);
		ps.setString(3, cphone);
		ps.execute();
		}catch(Exception e){}
	}
	public void setBillBookDetails(int billno,String bookname,int quantity)
	{
		try{
		s="insert into billbooks values(?,?,?)";
		ps=con.prepareStatement(s);
		ps.setInt(1, billno);
		ps.setString(2, bookname);
		ps.setInt(3, quantity);
		ps.execute();
		}catch(Exception e){}
	}
	public void setBillDetails(int billno,int total,String date,boolean status,String pname,String address)
	{
		try{
		s="insert into billdetails values(?,?,?,?,?,?)";
		ps=con.prepareStatement(s);
		ps.setInt(1, billno);
		ps.setInt(2, total);
		ps.setString(3, date);
		ps.setBoolean(4, status);
		ps.setString(5, address);
		ps.setString(6, pname);
		ps.execute();
		}catch(Exception e){}
	}
}
