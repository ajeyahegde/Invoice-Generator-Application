

import java.io.IOException;
import java.io.PrintWriter;

import bills2.DatabaseAccess;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displaybookdetails
 */
@WebServlet("/displaybookdetails")
public class displaybookdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displaybookdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String bname=request.getParameter("param");
		DatabaseAccess d=new DatabaseAccess();
		ResultSet rs=d.getBookDetails(bname);
		String author,pname;
		int year,pages,quantity,price;
		try{
			while(rs.next())
			{
				author=rs.getString(2);
				pname=rs.getString(7);
				price=rs.getInt(3);
				pages=rs.getInt(5);
				quantity=rs.getInt(4);
				year=rs.getInt(6);
				out.println("<br>Book Name: "+bname);
				out.println("<br>Author of the Book: "+author);
				out.println("<br>Price of Book: "+price);
				out.println("<br>Quantity Remaining: "+quantity);
				out.println("<br>No of pages: "+pages);
				out.println("<br>Year of Release: "+year);
				out.println("<br>Prakashana Name: "+pname);
			}
			}
			catch(Exception e){}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
