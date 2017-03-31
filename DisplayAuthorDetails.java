

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String authorname,link,authorName,authoraddress,authorphone,authormobile,authorpan;//TODO:change names using refactor rename
		out.print("<html><head><link rel='stylesheet' type='text/css' href='/bills2/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		authorname=request.getParameter("param");
		SqlClient sql=new SqlClient();
		try{
			ResultSet rs=sql.getAuthorDetails(authorname);
			while(rs.next())
			{
				authorName=rs.getNString(1);
				authoraddress=rs.getNString(2);
				authorphone=rs.getNString(3);
				authorpan=rs.getNString(4);
				authormobile=rs.getNString(5);
				out.println("<br><h1>"+authorname+"</h1>");
				out.println("<br>ಲೇಖಕರ ಹೆಸರು: "+authorname);
				out.println("<br>ಲೇಖಕರ ವಿಳಾಸ : "+authoraddress);
				out.println("<br>ಲೇಖಕರ ಫೋನ್ ನಂಬರ್ : "+authorphone);
				out.println("<br>ಲೇಖಕರ ಮೊಬೈಲ್  ನಂಬರ್ : "+authormobile);
				out.println("<br>ಲೇಖಕರ ಪಾನ್ ಕಾರ್ಡ್  ನಂಬರ್ : "+authorpan);
				out.println("<br>ಲೇಖಕರ ಪುಸ್ತಕಗಳು ವೀಕ್ಷಿಸಲು:");
			}
			link="DisplayAuthorBooks?param="+authorname;
			out.println("<br><a href='"+ link +"'> View Authors Books</a>");
			out.println("</html>");
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
