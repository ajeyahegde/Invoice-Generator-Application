

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
 * Servlet implementation class displayprakashanadetails
 */
@WebServlet("/DisplayPrakashanaDetails")
public class DisplayPrakashanaDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPrakashanaDetails() {
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
		String prakashananame=request.getParameter("param");
		out.print("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		out.println("<br><h1>"+prakashananame+"</h1>");
		ResultSet rs=sql.getPrakashanaDetails(prakashananame);
		String prakashanaaddress,owner;
		try{
		while(rs.next())
		{
			owner=rs.getNString(2);
			prakashanaaddress=rs.getNString(3);
			out.println("<br>ಪ್ರಕಾಶನ ಹೆಸರು: "+prakashananame);
			out.println("<br>ಪ್ರಕಾಶನ ವಿಳಾಸ: "+prakashanaaddress);
			out.println("<br>ಪ್ರಕಾಶನ ಮಾಲೀಕರು: "+owner);
			
		}
		out.println("</html>");
		}
		catch(Exception e){
			System.out.println("Exception called in DisplayPrakashanaDetails.java:"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
