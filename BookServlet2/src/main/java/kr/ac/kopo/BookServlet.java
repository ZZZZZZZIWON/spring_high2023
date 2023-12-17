package kr.ac.kopo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/book/list", "/book/add", "/book/update", "/book/delete" })
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		System.out.println(uri);

		if (uri.endsWith("/list")) {
			ArrayList<Book> list = new ArrayList<Book>();

			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang",
						"madang");

				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery("SELECT * FROM book");

				while (rs.next()) {
					Book item = new Book(); // 하나의 row에 해당하는 객체 생성

					item.setBookid(rs.getInt(1));
					item.setBookname(rs.getString(2));
					item.setPublisher(rs.getString(3));
					item.setPrice(rs.getInt(4));

					list.add(item);
				}
				rs.close();
				stmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/book/list.jsp").forward(request, response);

		} else if (uri.endsWith("/add")) {

			request.getRequestDispatcher("/WEB-INF/book/add.jsp").forward(request, response);

		} else if (uri.endsWith("/update")) {
			String bookid = request.getParameter("bookid");
			Book item = new Book();

			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang",
						"madang");

				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM book WHERE bookid=?");

				pstmt.setString(1, bookid);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					item.setBookid(rs.getInt(1));
					item.setBookname(rs.getString(2));
					item.setPublisher(rs.getString(3));
					item.setPrice(rs.getInt(4));
				}
				;

				rs.close();
				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/book/update.jsp").forward(request, response);

		} else if (uri.endsWith("/delete")) {

			String bookid = request.getParameter("bookid");
			int result= 0;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
				
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM book WHERE bookid=?");
				
				pstmt.setString(1, bookid);
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/book/delete.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.endsWith("/add")) {
			request.setCharacterEncoding("UTF-8");

			String bookid = request.getParameter("bookid");
			String bookname = request.getParameter("bookname");
			String publisher = request.getParameter("publisher");
			String price = request.getParameter("price");

			int result = 0;
			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang",
						"madang");

				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?)");

				pstmt.setString(1, bookid);
				pstmt.setString(2, bookname);
				pstmt.setString(3, publisher);
				pstmt.setString(4, price);

				result = pstmt.executeUpdate();

				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/book/add_apply.jsp").forward(request, response);

		} else if (uri.endsWith("/update")) {
			request.setCharacterEncoding("UTF-8");

			String bookid = request.getParameter("bookid");
			String bookname = request.getParameter("bookname");
			String publisher = request.getParameter("publisher");
			String price = request.getParameter("price");

			int result = 0;

			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang",
						"madang");

				PreparedStatement pstmt = conn
						.prepareStatement("UPDATE book SET bookname=?, publisher=?, price=? WHERE bookid=?");

				pstmt.setString(4, bookid);
				pstmt.setString(1, bookname);
				pstmt.setString(2, publisher);
				pstmt.setString(3, price);

				result = pstmt.executeUpdate();

				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/book/update_apply.jsp").forward(request, response);

		}
	}

}
