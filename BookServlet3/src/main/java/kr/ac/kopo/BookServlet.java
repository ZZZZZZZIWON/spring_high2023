package kr.ac.kopo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/book/list", "/book/add", "/book/update", "/book/delete" })
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public BookServlet() {
		
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		System.out.println(uri);

		if (uri.endsWith("/list")) {
			ArrayList<Book> list = bookService.list();

			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/book/list.jsp").forward(request, response);

		} else if (uri.endsWith("/add")) {

			request.getRequestDispatcher("/WEB-INF/book/add.jsp").forward(request, response);

		} else if (uri.endsWith("/update")) {
			
			String bookid = request.getParameter("bookid");
			
			Book item = bookService.item(bookid);
			request.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/book/update.jsp").forward(request, response);

		} else if (uri.endsWith("/delete")) {

			String bookid = request.getParameter("bookid");
			
			int result = bookService.delete(bookid);
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/book/delete.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		request.setCharacterEncoding("UTF-8");

		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
		String price = request.getParameter("price");
		
		if (uri.endsWith("/add")) {


			int result = bookService.add(bookid, bookname, publisher, price);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/book/add_apply.jsp").forward(request, response);

		} else if (uri.endsWith("/update")) {
			request.setCharacterEncoding("UTF-8");

			int result = bookService.update(bookid, bookname, publisher, price);

			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/book/update_apply.jsp").forward(request, response);

		}
	}
}
