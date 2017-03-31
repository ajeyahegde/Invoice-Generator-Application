

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
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String authorname,authoraddress,authorphone,authormobile,authorpan;
		authorname=request.getParameter("aname");
		authoraddress=request.getParameter("aaddress");
		authorphone=request.getParameter("aphone");
		authormobile=request.getParameter("amobile");
		authorpan=request.getParameter("apan");
		SqlClient sql=new SqlClient();
		out.println("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		sql.setAuthorDetails(authorname, authoraddress, authorphone, authormobile, authorpan);
			out.println("<br>ಲೇಖಕರ ಹೆಸರು: "+authorname);
			out.println("<br>ಲೇಖಕರ ವಿಳಾಸ : "+authoraddress);
			out.println("<br>ಲೇಖಕರ ಫೋನ್ ನಂಬರ್ : "+authorphone);
			out.println("<br>ಲೇಖಕರ ಮೊಬೈಲ್  ನಂಬರ್ : "+authormobile);
			out.println("<br>ಲೇಖಕರ ಪಾನ್ ಕಾರ್ಡ್  ನಂಬರ್ : "+authorpan);
			out.println("</html>");
	}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
