

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.DriverManager;

import bills2.DatabaseAccess;
import bills2.DatabaseAccess.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class authorservlet
 */
@WebServlet("/authorservlet")
public class authorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorservlet() {
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
		String aname,aaddress,aphone,amobile,apan;
		aname=request.getParameter("aname");
		aaddress=request.getParameter("aaddress");
		aphone=request.getParameter("aphone");
		amobile=request.getParameter("amobile");
		apan=request.getParameter("apan");
		DatabaseAccess d=new DatabaseAccess();
		d.setAuthorDetails(aname, aaddress, aphone, amobile, apan);
			out.println("<br>You inserted author detials as follows");
			out.println("<br>Author name: "+aname);
			out.println("<br>Author address: "+aaddress);
			out.println("<br>Author phone: "+aphone);
			out.println("<br>Author mobile: "+amobile);
			out.println("<br>Author pancard no: "+apan);
	}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
