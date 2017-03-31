

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
 * Servlet implementation class displaybookdetails
 */
@WebServlet("/DisplayBookDetails")
public class DisplayBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBookDetails() {
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
		String bookname=request.getParameter("param");
		SqlClient sql=new SqlClient();
		ResultSet rs=sql.getBookDetails(bookname);
		out.print("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		String author,prakashananame;
		int year,bookno,pages,quantity,price;
		try{
			while(rs.next())
			{
				author=rs.getNString(2);
				prakashananame=rs.getNString(7);
				price=rs.getInt(3);
				pages=rs.getInt(5);
				quantity=rs.getInt(4);
				year=rs.getInt(6);
				bookno=rs.getInt(8);
				out.println("<br><h1>"+bookname+"</h1>");
				out.println("<br>ಪುಸ್ತಕದ ಹೆಸರ: "+bookname);
				out.println("<br>ಪುಸ್ತಕದ ಬೆಲೆ: "+price);
				out.println("<br>ಪುಸ್ತಕದ ಲೇಖಕರ ಹೆಸರು: "+author);
				out.println("<br>ಪುಸ್ತಕ ಪ್ರಮಾಣ: "+quantity);
				out.println("<br>ಪುಸ್ತಕದ ಬಿಡುಗಡೆಯಾದ ವರ್ಷ: "+year);
				out.println("<br>ಪುಸ್ತಕದ ಪುಟಗಳ ಸಂಖ್ಯೆ: "+pages);
				out.println("<br>ಪುಸ್ತಕದ ಪ್ರಕಾಶನ : "+prakashananame);
				out.println("<br>ಪುಸ್ತಕ ಆಯ್ಕೆ ಸಂಖ್ಯೆ: "+bookno);
			}
			out.println("</html>");
			}
			catch(Exception e){
				System.out.println("Exception called in DisplayBookDetails.java:"+e.getMessage());
				
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
