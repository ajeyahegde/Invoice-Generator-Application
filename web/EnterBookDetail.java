

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
		PrintWriter out=response.getWriter();
		SqlClient d=new SqlClient();
		String bookname,author,prakashananame;
		int year,pages,price,quantity,bno;
		bookname=request.getParameter("bname");
		author=request.getParameter("author");
		prakashananame=request.getParameter("pname");
		price=Integer.parseInt(request.getParameter("price"));
		pages=Integer.parseInt(request.getParameter("pages"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		year=Integer.parseInt(request.getParameter("year"));
		bno=Integer.parseInt(request.getParameter("bno"));
		d.setBookDetails(bookname, author, price, quantity, pages, year, prakashananame,bno);
		out.println("<br>You inserted Book detials as follows");
		out.println("<br>Book Name: "+bookname);
		out.println("<br>Book Price"+price);
		out.println("<br>Author Name"+author);
		out.println("<br>Quantity"+quantity);
		out.println("<br>Year of Release"+year);
		out.println("<br>Number of pages in Book"+pages);
		out.println("<br>Published under prakashana"+prakashananame);
		out.println("<br>Book Number is"+bno);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
