<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
Class.forName("oracle.jdbc.OracleDriver");

Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");

Statement stmt = conn.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM book");

int count=0;
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
			<h3>도서 목록</h3>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<%
					while (rs.next()) {
						count++;
					%>
					<tr>
						<td><%= rs.getInt(1) %></td>
						<td><%= rs.getString(2) %></td>
						<td><%= rs.getString(3) %></td>
						<td><%= rs.getInt(4) %></td>
						<td><a href="delete.jsp?bookid=<%=rs.getInt(1)%>">삭제</a> <a href="update.jsp?bookid=<%=rs.getInt(1)%>">변경</a></td>
					</tr>
					<%
					}
					%>
					
					<% if(count == 0) { %>
					<tr>
						<td colspan="5">검색 된 도서가 없습니다</td>
					</tr>
					<% }  %>
				</tbody>
			</table>
		</div>
		<div>
			<a href="add.jsp">등록</a>
		</div>
	</div>
</body>
</html>
<%
rs.close();
stmt.close();
conn.close();
%>