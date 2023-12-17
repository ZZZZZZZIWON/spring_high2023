package kr.ac.kopo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookService {

	private Connection conn;

	private PreparedStatement query(String query) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
	
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
	
		return conn.prepareStatement(query);
	}

	public ArrayList<Book> list() {
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement pstmt = query("SELECT * FROM book");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Book item = new Book(); // 하나의 row에 해당하는 객체 생성

				item.setBookid(rs.getInt(1));
				item.setBookname(rs.getString(2));
				item.setPublisher(rs.getString(3));
				item.setPrice(rs.getInt(4));

				list.add(item);
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public Book item(String bookid) {
		Book item = new Book();

		try {
			PreparedStatement pstmt = query("SELECT * FROM book WHERE bookid=?");

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

		return item;
	}

	public int delete(String bookid) {
		int result= 0;
		try {
			
			PreparedStatement pstmt = query("DELETE FROM book WHERE bookid=?");
			
			pstmt.setString(1, bookid);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int add(String bookid, String bookname, String publisher, String price) {
		int result = 0;
		try {
			PreparedStatement pstmt = query("INSERT INTO book VALUES(?, ?, ?, ?)");

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
		return result;
	}

	public int update(String bookid, String bookname, String publisher, String price) {
		int result = 0;

		try {
			PreparedStatement pstmt = query("UPDATE book SET bookname=?, publisher=?, price=? WHERE bookid=?");

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
		return result;
	}

}
