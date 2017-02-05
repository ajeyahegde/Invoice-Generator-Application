

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
 * Servlet implementation class authorbooks
 */
@WebServlet("/authorbooks")
public class authorbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorbooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String s=request.getParameter("param");
		out.println("Books of "+s+" are:");
		String s1;
		DatabaseAccess d=new DatabaseAccess();
		try{
			ResultSet rs=d.getAuthorBookList(s);
			while(rs.next())
			{
				out.println("<br>"+rs.getString(1));
			}
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
