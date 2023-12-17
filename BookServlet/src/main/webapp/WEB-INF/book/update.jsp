<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String bookid = request.getParameter("bookid");

	Class.forName("oracle.jdbc.OracleDriver");

	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");

	PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM book WHERE bookid=?");

	pstmt.setString(1, bookid);
	
	ResultSet rs = pstmt.executeQuery();
	
	rs.next();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h3>도서정보 변경</h3>
		</div>
		<form method="post">
			<div>
				<div>
					<label>도서번호 : </label> 
					<input type="number" name="bookid" value="<%=rs.getString(1) %>" readonly>
				</div>
				<div>
					<label>도서명 : </label> 
					<input type="text" name="bookname" value="<%=rs.getString(2) %>">
				</div>
				<div>
					<label>출판사 : </label> 
					<input type="text" name="publisher" value="<%=rs.getString(3) %>">
				</div>
				<div>
					<label>가격 : </label> 
					<input type="number" name="price" value="<%=rs.getString(4) %>">
				</div>
				<div>
					<button>변경</button>
					<a href="list.jsp"><button type="button">목록</button></a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%
rs.close();
pstmt.close();
conn.close();
%>