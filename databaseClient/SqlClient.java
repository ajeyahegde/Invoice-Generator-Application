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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8","root","root");
			stmt.executeQuery("SET NAMES 'UTF8'");
		    stmt.executeQuery("SET CHARACTER SET 'UTF8'");
		}catch(Exception e)
		{
			System.out.println("Exception called in Constructor"+e.getMessage());
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
			ps.setNString(1, authorname);
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
			ps.setNString(1, authorname);
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
			ps.setNString(1, bookname);
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
			ps.setNString(1, pname);
			rs=ps.executeQuery();
		}catch(Exception e){
			System.out.println("Exception in getPrakashanaDetails method"+e.getMessage());
		}
		return rs;
	}
	/**
	 * Retrives Prakashana BookList 
	 * 
	 * @param prakashananame:prakashananame for which booklist is to be returned
	 * @return:resultset contaning prakshana books.
	 */
	public ResultSet getPrakashanaBookListDetails(String prakashananame)
	{
		try{
			ps=con.prepareStatement("select * from books where pname=?");
			ps.setNString(1, prakashananame);
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
	/**
	 * Retrives Books and Quantity in bill=billno 
	 * 
	 * @param billno:Number of bill 
	 * @return:resultset containg Books and quantities in bill=billno.
	 */
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
			ps.setNString(1, caddress);
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
			ps.setNString(1, aname);
			ps.setNString(2, aaddress);
			ps.setNString(3, aphone);
			ps.setNString(4, apan);
			ps.setNString(5, amobile);
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
			ps.setNString(1, bname);
			ps.setNString(2, author);
			ps.setInt(3, price);
			ps.setInt(4, quantity);
			ps.setInt(5, pages);
			ps.setInt(6, year);
			ps.setNString(7, pname);
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
			ps.setNString(1, pname);
			ps.setNString(2, owner);
			ps.setNString(3, paddress);
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
			ps.setNString(1, cname);
			ps.setNString(2, caddress);
			ps.setNString(3, cphone);
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
			ps.setNString(2, bookname);
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
			ps.setNString(5, address);
			ps.setNString(6, pname);
			ps.execute();
		}catch(Exception e){
			System.out.println("Exception in setBillDetails method"+e.getMessage());
		}
	}
	/**
	 * Remove Author=author from Author table 
	 * 
	 * @param authorname:authorname for which details is to deleted
	 * @return nothing
	 */
	public void RemoveAuthor(String author)
	{
		s="delete from author where aname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, author);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemoveAuthor method"+e.getMessage());
		}
		
	}
	/**
	 * Remove Book=bookname from books table 
	 * 
	 * @param bookname:bookname for which details is to deleted
	 * @return nothing
	 */
	public void RemoveBook(String bookname)
	{
		s="delete from books where bname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, bookname);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemoveBooks method"+e.getMessage());
		}
		
	}
	/**
	 * Remove Prakashana=prakshana from prakashana table 
	 * 
	 * @param prakshana:prakashana name for which details is to deleted
	 * @return nothing
	 */
	public void RemovePrakashana(String prakashana)
	{
		s="delete from prakashana where pname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, prakashana);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemovePrakashana method"+e.getMessage());
		}
		
	}
	/**
	 * Remove Customer=customer from Author table 
	 * 
	 * @param customer:customer for which details is to deleted
	 * @return nothing
	 */
	public void RemoveCustomer(String customer)
	{
		s="delete from customer where caddress=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, customer);
		ps.execute();
		}catch(Exception e)
		{
			System.out.println("Exception in RemoveBooks method"+e.getMessage());
		}	
	}
	/**
	 * Update Author=author of Author table 
	 * 
	 * @param authorname,author address,author's pan number,mobile number,phone number
	 * @return nothing
	 */
	public void UpdateAuthor(String author,String aaddress,String apan,String amobile,String aphone)
	{
		s="update author set address=?,apan=?,amobile=?,aphone=? where aname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, aaddress);
		ps.setNString(2, apan);
		ps.setNString(3, amobile);
		ps.setNString(4, aphone);
		ps.setNString(5, author);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdateAuthor method"+e.getMessage());
		}
	}
	/**
	 * Update book=bname of Book table 
	 * 
	 * @param authorname,prakashana name,bookprice,bookpages,booknumber,book quantity,book release year,
	 * @return nothing
	 */
	public void UpdateBooks(String bname,String author,int quantity,String pname,int price,int pages,int year,int bno)
	{
		s="update books set author=?,pname=?,price=?,pages=?,quantity=?,year=?,bno=? where bname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, author);
		ps.setNString(2, pname);
		ps.setInt(3, price);
		ps.setInt(4, pages);
		ps.setInt(5, quantity);
		ps.setInt(6, year);
		ps.setInt(7, bno);
		ps.setNString(8, bname);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdateAuthor method"+e.getMessage());
		}
	}
	/**
	 * Update Prakashana=pname of prakashana table 
	 * 
	 * @param prakashana name,owner,prakashana address
	 * @return nothing
	 */
	public void UpdatePrakashana(String pname,String owner,String paddress)
	{
		s="update prakashana set paddress=?,owner=? where pname=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(3,pname);
		ps.setNString(2,owner);
		ps.setNString(1,paddress);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdatePrakashana method"+e.getMessage());
		}
	}
	/**
	 * Update customer=cname of customer table 
	 * 
	 * @param customer name,customer phone,customer address
	 * @return nothing
	 */
	public void UpdateCustomer(String cname,String cphone,String caddress)
	{
		s="update customer set cname=?,cphone=? where caddress=?";
		try{
		ps=con.prepareStatement(s);
		ps.setNString(1, cname);
		ps.setNString(2, cphone);
		ps.setNString(3, caddress);
		ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception in UpdateCustomer method"+e.getMessage());
		}
	}
}
