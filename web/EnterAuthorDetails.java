

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;
import databaseClient.SqlClient.*;


/**
 * Servlet implementation class authorservlet
 */
@WebServlet("/EnterAuthorDetails")
public class EnterAuthorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterAuthorDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("This is author details page");
		String authorname,authoraddress,authorphone,authormobile,authorpan;
		authorname=request.getParameter("aname");
		authoraddress=request.getParameter("aaddress");
		authorphone=request.getParameter("aphone");
		authormobile=request.getParameter("amobile");
		authorpan=request.getParameter("apan");
		SqlClient d=new SqlClient();
		d.setAuthorDetails(authorname, authoraddress, authorphone, authormobile, authorpan);
			out.println("<br>You inserted author detials as follows");
			out.println("<br>Author name: "+authorname);
			out.println("<br>Author address: "+authoraddress);
			out.println("<br>Author phone: "+authorphone);
			out.println("<br>Author mobile: "+authormobile);
			out.println("<br>Author pancard no: "+authorpan);
	}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
