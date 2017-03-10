

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;    //TODO:Remove * and use specific imports.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;
import databaseClient.SqlClient.*;

/**
 * Servlet implementation class author1
 */
@WebServlet("/DisplayAuthorDetails")
public class DisplayAuthorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAuthorDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String authorname,link,authorName,authoraddress,authorphone,authormobile,authorpan;//TODO:change names using refactor rename
		authorname=request.getParameter("param");
		out.println(authorname);
		SqlClient d=new SqlClient();
		try{
			ResultSet rs=d.getAuthorDetails(authorname);
			while(rs.next())
			{
				authorName=rs.getString(1);
				authoraddress=rs.getString(2);
				authorphone=rs.getString(3);
				authorpan=rs.getString(4);
				authormobile=rs.getString(5);
				out.println("<br>Author detials are as follows");
				out.println("<br>Author name: "+authorName);
				out.println("<br>Author address: "+authoraddress);
				out.println("<br>Author phone: "+authorphone);
				out.println("<br>Author mobile: "+authormobile);
				out.println("<br>Author pancard no: "+authorpan);
				out.println("To view Author books:");
			}
			link="DisplayAuthorBooks?param="+authorname;
			out.println("<a href='"+ link +"'> View Authors Books</a>");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception called in DisplayAuthorDetails.java"+e.getMessage()); //TODO:Write classname in exceptions
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
