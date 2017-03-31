


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
 * Servlet implementation class viewprakashana
 */
@WebServlet("/ViewPrakashanaDetails")
public class ViewPrakashanaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPrakashanaList() {
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
		ResultSet rs=sql.getPrakashanaTable();
		String prakashananame,link;
		out.print("<html><head><link rel='stylesheet' type='text/css' href='/bills2/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		out.println("<h1>ಪ್ರಕಾಶನ</h1> ");
		try{
		while(rs.next())
		{
			prakashananame=rs.getNString(1);
			out.println("<br>"+prakashananame);
			link="DisplayPrakashanaDetails?param="+prakashananame;
			out.println("<a href='"+ link +"'> View </a>");
		}
		out.println("</html>");
		}catch(Exception e){
			System.out.println("Exception called in ViewPrakashanaList.java:"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
