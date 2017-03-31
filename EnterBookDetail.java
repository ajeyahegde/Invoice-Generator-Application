

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;

/**
 * Servlet implementation class enterbooks
 */
@WebServlet("/EnterBookDetail")
public class EnterBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterBookDetail() {
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
		SqlClient sql=new SqlClient();
		String bookname,author,prakashananame;
		out.println("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		int year,pages,price,quantity,bookno;
		bookname=request.getParameter("bname");
		author=request.getParameter("author");
		prakashananame=request.getParameter("pname");
		price=Integer.parseInt(request.getParameter("price"));
		pages=Integer.parseInt(request.getParameter("pages"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		year=Integer.parseInt(request.getParameter("year"));
		bookno=Integer.parseInt(request.getParameter("bno"));
		sql.setBookDetails(bookname, author, price, quantity, pages, year, prakashananame,bookno);
		out.println("<br>ಪುಸ್ತಕದ ಹೆಸರ: "+bookname);
		out.println("<br>ಪುಸ್ತಕದ ಬೆಲೆ: "+price);
		out.println("<br>ಪುಸ್ತಕದ ಲೇಖಕರ ಹೆಸರು: "+author);
		out.println("<br>ಪುಸ್ತಕ ಪ್ರಮಾಣ: "+quantity);
		out.println("<br>ಪುಸ್ತಕದ ಬಿಡುಗಡೆಯಾದ ವರ್ಷ: "+year);
		out.println("<br>ಪುಸ್ತಕದ ಪುಟಗಳ ಸಂಖ್ಯೆ: "+pages);
		out.println("<br>ಪುಸ್ತಕದ ಪ್ರಕಾಶನ : "+prakashananame);
		out.println("<br>ಪುಸ್ತಕ ಆಯ್ಕೆ ಸಂಖ್ಯೆ: "+bookno);
		out.println("</html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
