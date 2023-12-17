<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div>
			<h3>주문 상세내역</h3>
		</div>

		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>

		<div>
			<div>
				<label>주문번호: </label> ${item.orderid}
			</div>
			<div>
				<label>고객번호: </label> ${item.custid}
			</div>
			<div>
				<label>주문금액: </label><fmt:formatDate value="${item.orderdate }" pattern="yyyy년 MM월 dd일"/>
			</div>
			<div>
				<label>주문일자: </label>

			</div>
			<div>
				<table class="table table-sm table-striped">
					<thead class="table-dark">
						<tr>
							<th>상세번호</th>
							<th>도서번호</th>
							<th>도서명</th>
							<th>출판사</th>
							<th>주문수량</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${item.details.size() < 1}">
							<tr>
								<td colspan="3">상세내역이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="detail" items="${item.details}">
						<tr>
							<td>${detail.code}</td>
							<td>${detail.bookid}</td>
							<td>${detail.bookname}</td>
							<td>${detail.publisher}</td>
							<td>${detail.amount}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
		<div>
			<a href="../list" class="btn btn-sm btn-secondary">목록으로</a>
		</div>
	</div>
</body>
</html>