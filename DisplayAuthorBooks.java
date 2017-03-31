

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;
import databaseClient.SqlClient.*;

/**
 * Servlet implementation class authorbooks
 */
@WebServlet("/DisplayAuthorBooks")
public class DisplayAuthorBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAuthorBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String authorname=request.getParameter("param");
		out.print("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		out.println("<h1>"+authorname+"ರವರ ಪುಸ್ತಕಗಳು :</h1>");
		SqlClient sql=new SqlClient();
		try{
			ResultSet rs=sql.getAuthorBookList(authorname);
			while(rs.next())
			{
				out.println("<br>"+rs.getNString(1));
			}
			out.println("</html>");
		}
		catch(Exception e)
		{
			System.out.println("Exception called in DisplayAuthorBooks.java:"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
