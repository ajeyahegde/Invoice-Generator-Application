package databaseClient;

import java.sql.*;

public class SqlClient {
	static Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement ps;
	String s;

	public SqlClient()  //Ctrl+i for indentation
	{
		try{	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		}catch(Exception e)
		{
			System.out.println("Exception called in Constructor");
		}
	}
	
	/**
	 * Get Result set containing Author Table  
	 * @return:ResultSet containing Author table
	 */
	public ResultSet getAuthorTable()  
	{
		try{
			stmt=con.createStatement();
			s="select * from author";
			rs=stmt.executeQuery(s);
		}catch(Exception e){
			System.out.println("Exception in getAuthorTable method"+e.getMessage());
		}			//TODO:Exception neat aag madavu
		return rs;
	}
	
	/**
	 * Retrives Author's BookList 
	 * 
	 * @param authorname:authorname for which booklist is to be returned
	 * @return:resultset containg authors books.
	 */
	public ResultSet getAuthorBookList(String authorname)
	{
		try{
			ps=con.prepareStatement("select bname from books where author=?");
			ps.setString(1, authorname);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getAuthorBookList method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @param authorname
	 * @return:ResultSet containing Particular Author details
	 */
	public ResultSet getAuthorDetails(String authorname)
	{
		try{
			ps=con.prepareStatement("select * from author where aname=?");
			ps.setString(1, authorname);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getAuthorDetails method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @return:ResultSet containing BooksTable
	 */
	public ResultSet getBooksTable()
	{
		try{
			stmt=con.createStatement();
			s="select * from books";
			rs=stmt.executeQuery(s);
		}catch(Exception e){
			System.out.println("Exception in getBooksTable method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @param bookname
	 * @return:Result Set Containing particular Book Details
	 */
	public ResultSet getBookDetails(String bookname)
	{
		try{
			s="select * from books where bname=?";
			ps=con.prepareStatement(s);
			ps.setString(1, bookname);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getBookDetails method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @return:ResultSet containing Prakashana Table
	 */
	public ResultSet getPrakashanaTable()
	{
		try{
			stmt=con.createStatement();
			s="select * from prakashana";
			rs=stmt.executeQuery(s);
		}catch(Exception e){
			System.out.println("Exception in getPrakashanaTable method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @param pname
	 * @return:Result Set Containing particular Prakashana Details
	 */
	public ResultSet getPrakashanaDetails(String pname)
	{
		try{
			s="select * from prakashana where pname=?";
			ps=con.prepareStatement(s);	
			ps.setString(1, pname);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getPrakashanaDetails method"+e.getMessage());
		}
		return rs;
	}
	public ResultSet getPrakashanaBookListDetails(String prakashananame)
	{
		try{
			ps=con.prepareStatement("select * from books where pname=?");
			ps.setString(1, prakashananame);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getAuthorBookList method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @return:ResultSet containing BillDetails Table
	 */
	public ResultSet getBillDetailsTable()
	{
		try{
			stmt=con.createStatement();
			s="select * from billdetails";
			rs=stmt.executeQuery(s);
		}catch(Exception e){
			System.out.println("Exception in getBillDetailsTable method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @return:ResultSet containing BillBooksTable
	 */
	public ResultSet getBillBooksTable()
	{
		try{
			stmt=con.createStatement();
			s="select * from billbooks";
			rs=stmt.executeQuery(s);
		}catch(Exception e){
			System.out.println("Exception in getBillBooksTable method"+e.getMessage());
		}
		return rs;
	}
	public ResultSet getBillBooks(int billno)
	{	
		try{
			ps=con.prepareStatement("select * from billbooks where billno=?");
			ps.setInt(1, billno);
			rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Exception in getBillBooks method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @return:ResultSet containing CustomerTable
	 */
	public ResultSet getCustomerTable()
	{
		try{
			stmt=con.createStatement();
			s="select * from customer";
			rs=stmt.executeQuery(s);
		}catch(Exception e){
			System.out.println("Exception in getCustomerTable method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @param caddress
	 * @return:Result Set Containing particular Customer Details
	 */
	public ResultSet getCustomerDetails(String caddress)
	{
		try{
			s="select * from customer where caddress=?";
			ps=con.prepareStatement(s);
			ps.setString(1, caddress);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getCustomerDetails method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * 
	 * @param aname
	 * @param aaddress
	 * @param aphone
	 * @param amobile
	 * @param apan
	 * Set Author Details
	 */
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
		}catch(Exception e){
			System.out.println("Exception in setAuthorDetails method"+e.getMessage());
		}
	}
	/**
	 * 
	 * @param bname
	 * @param author
	 * @param price
	 * @param quantity
	 * @param pages
	 * @param year
	 * @param pname
	 * Set Book Details
	 */
	public void setBookDetails(String bname,String author,int price,int quantity,int pages,int year,String pname,int bno)
	{
		try{
			s="insert into books values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(s);
			ps.setString(1, bname);
			ps.setString(2, author);
			ps.setInt(3, price);
			ps.setInt(4, quantity);
			ps.setInt(5, pages);
			ps.setInt(6, year);
			ps.setString(7, pname);
			ps.setInt(8, bno);
			ps.execute();
		}catch(Exception e){
			System.out.println("Exception in setBookDetails method"+e.getMessage());
		}
	}
	/**
	 * Set Prakashana Details
	 * @param pname
	 * @param owner
	 * @param paddress
	 */
	public void setPrakashanaDetails(String pname,String owner,String paddress)
	{
		try{
			s="insert into prakashana values(?,?,?)";
			ps=con.prepareStatement(s);
			ps.setString(1, pname);
			ps.setString(2, owner);
			ps.setString(3, paddress);
			ps.execute();
		}catch(Exception e){
			System.out.println("Exception in setPrakashanaDetails method"+e.getMessage());
		}
	}
	/**
	 * Set Customer Details
	 * @param cname
	 * @param cphone
	 * @param caddress
	 */
	public void setCustomerDetails(String cname,String cphone,String caddress)
	{
		try{
			s="insert into customer values(?,?,?)";
			ps=con.prepareStatement(s);
			ps.setString(1, cname);
			ps.setString(2, caddress);
			ps.setString(3, cphone);
			ps.execute();
		}catch(Exception e){
			System.out.println("Exception in setCustomerDetails method"+e.getMessage());
		}
	}
	/**
	 * Set BillBooks Details
	 * @param billno
	 * @param bookname
	 * @param quantity
	 */
	public void setBillBookDetails(int billno,String bookname,int quantity)
	{
		try{
			s="insert into billbooks values(?,?,?)";
			ps=con.prepareStatement(s);
			ps.setInt(1, billno);
			ps.setString(2, bookname);
			ps.setInt(3, quantity);
			ps.execute();
		}catch(Exception e){
			System.out.println("Exception in setBillBookDetails method"+e.getMessage());
		}
	}
	/**
	 * Set BillDetails Table
	 * @param billno
	 * @param total
	 * @param date
	 * @param status
	 * @param pname
	 * @param address
	 */
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
		}catch(Exception e){
			System.out.println("Exception in setBillDetails method"+e.getMessage());
		}
	}
	public void RemoveAuthor(String author)
	{
		s="delete from author where aname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, author);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemoveAuthor method"+e.getMessage());
		}
		
	}
	public void RemoveBook(String bookname)
	{
		s="delete from books where bname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, bookname);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemoveBooks method"+e.getMessage());
		}
		
	}
	public void RemovePrakashana(String prakashana)
	{
		s="delete from prakashana where pname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, prakashana);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemovePrakashana method"+e.getMessage());
		}
		
	}
	public void RemoveCustomer(String customer)
	{
		s="delete from customer where caddress=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, customer);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemoveBooks method"+e.getMessage());
		}	
	}
	public void UpdateAuthor(String author,String aaddress,String apan,String amobile,String aphone)
	{
		s="update author set address=?,apan=?,amobile=?,aphone=? where aname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, aaddress);
		ps.setString(2, apan);
		ps.setString(3, amobile);
		ps.setString(4, aphone);
		ps.setString(5, author);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdateAuthor method"+e.getMessage());
		}
	}
	public void UpdateBooks(String bname,String author,int quantity,String pname,int price,int pages,int year,int bno)
	{
		s="update books set author=?,pname=?,price=?,pages=?,quantity=?,year=?,bno=? where bname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, author);
		ps.setString(2, pname);
		ps.setInt(3, price);
		ps.setInt(4, pages);
		ps.setInt(5, quantity);
		ps.setInt(6, year);
		ps.setInt(7, bno);
		ps.setString(8, bname);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdateAuthor method"+e.getMessage());
		}
	}
	public void UpdatePrakashana(String pname,String owner,String paddress)
	{
		s="update prakashana set paddress=?,owner=? where pname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(3,pname);
		ps.setString(2,owner);
		ps.setString(1,paddress);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdatePrakashana method"+e.getMessage());
		}
	}
	public void UpdateCustomer(String cname,String cphone,String caddress)
	{
		s="update customer set cname=?,cphone=? where caddress=?";
		try{
		ps=con.prepareStatement(s);
		ps.setString(1, cname);
		ps.setString(2, cphone);
		ps.setString(3, caddress);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdateCustomer method"+e.getMessage());
		}
	}
}
