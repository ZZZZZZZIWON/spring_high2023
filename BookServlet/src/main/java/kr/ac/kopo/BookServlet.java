package kr.ac.kopo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/book/list", "/book/add", "/book/update", "/book/delete"})
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BookServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		if(uri.endsWith("/list")) {
			request.getRequestDispatcher("/WEB-INF/book/list.jsp").forward(request, response);
			
		} else if(uri.endsWith("/add")) {
			request.getRequestDispatcher("/WEB-INF/book/add.jsp").forward(request, response);
			
		} else if(uri.endsWith("/update")) {
			request.getRequestDispatcher("/WEB-INF/book/update.jsp").forward(request, response);
			
		} else if(uri.endsWith("/delete")) {
			request.getRequestDispatcher("/WEB-INF/book/delete.jsp").forward(request, response);
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		if(uri.endsWith("/add")) {
			request.getRequestDispatcher("/WEB-INF/book/add_apply.jsp").forward(request, response);
			
		} else if(uri.endsWith("/update")) {
			request.getRequestDispatcher("/WEB-INF/book/update_apply.jsp").forward(request, response);
			
		}
	}

}
