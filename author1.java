

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import bills2.DatabaseAccess;
import bills2.DatabaseAccess.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class author1
 */
@WebServlet("/author1")
public class author1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public author1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String s,s1,aname,aaddress,aphone,amobile,apan;
		s=request.getParameter("param");
		out.println(s);
		DatabaseAccess d=new DatabaseAccess();
		try{
			ResultSet rs=d.getAuthorDetails(s);
			while(rs.next())
			{
				aname=rs.getString(1);
				aaddress=rs.getString(2);
				aphone=rs.getString(3);
				apan=rs.getString(4);
				amobile=rs.getString(5);
				out.println("<br>Author detials are as follows");
				out.println("<br>Author name: "+aname);
				out.println("<br>Author address: "+aaddress);
				out.println("<br>Author phone: "+aphone);
				out.println("<br>Author mobile: "+amobile);
				out.println("<br>Author pancard no: "+apan);
				out.println("To view Author books:");
			}
			s1="authorbooks?param="+s;
			out.println("<a href='"+ s1 +"'> View Authors Books</a>");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception called");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
