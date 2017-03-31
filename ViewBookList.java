

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;

/**
 * Servlet implementation class viewbooks
 */
@WebServlet("/ViewBookList")
public class ViewBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		SqlClient sql=new SqlClient();
		ResultSet rs=sql.getBooksTable();
		String bookname,link;
		out.print("<html><head><link rel='stylesheet' type='text/css' href='/bills2/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		out.println("<h1>ಪುಸ್ತಕಗಳು</h1>");
		try{
			while(rs.next())
			{
				bookname=rs.getNString(1);
				out.println("<br>"+rs.getNString(1));
				link="DisplayBookDetails?param="+bookname;
				out.println("<a href='"+ link +"'> View </a>");
			}
			out.print("</html>");
			}catch(Exception e)
			{
				System.out.println("Exception called in ViewBookList.java:"+e.getMessage());
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
