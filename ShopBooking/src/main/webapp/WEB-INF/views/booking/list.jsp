<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h3 class="mt-2">예약 목록</h3>
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div class="mb-2 px-3">
			<form>
				<div class="row">
					<div class="col"></div>
					<div class="col-2">
						<select name="search" class="form-control form-control-sm">
							<option value="0">전체 검색</option>
							<option value="1" ${pager.search == 1 ? 'selected' : ''}>매장 아이디</option>
							<option value="2" ${pager.search == 2 ? 'selected' : ''}>시간대</option>	
							<option value="3" ${pager.search == 3 ? 'selected' : ''}>예약일자</option>					
						</select>
					</div>
					<div class="col-4">
						<input type="text" name="keyword" class="form-control form-control-sm" value="${pager.keyword}">
					</div>
					<div class="col-1">
						<div class="row">
							<input type="submit" value="검색" class="btn btn-primary btn-sm">
						</div>
					</div>
				</div>
			</form>
		</div>
		<div>
			<table class="table table-sm table-striped">
				<thead class="table-dark">
					<tr>
						<th class="col">예약번호</th>
						<th class="col">예약일자</th>
						<th class="col">고객명</th>
						<th class="col">테이블명</th>
						<th class="col">예약시간</th>
						<th class="col">관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="6">등록 된 예약내역이 없습니다</td>					
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.bookingId}</td>
							<td>${item.day}</td>
							<td>${item.memberTitle}</td>
							<td>${item.title}</td>
							<td>${item.hour}</td>
							<td><a href="delete/${item.bookingId}" class="btn btn-outline-danger btn-sm">예약취소</a> <a href="update/${item.bookingId}" class="btn btn-outline-info btn-sm">예약</a></td>							
						</tr>
					</c:forEach>					
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="pagination pagination-sm justify-content-center">
								<div class="page-item"><a href="?page=1&${pager.query}" class="page-link">처음</a></div>
								<div class="page-item"><a href="?page=${pager.prev}&${pager.query}" class="page-link">이전</a></div>
									<c:forEach var="page" items="${pager.list}">
										<div class="page-item ${pager.page == page ? 'active' : ''}"><a href="?page=${page}&${pager.query}" class="page-link">${page}</a></div>
									</c:forEach>								
								<div class="page-item"><a href="?page=${pager.next}&${pager.query}" class="page-link">다음</a></div>
								<div class="page-item"><a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a></div>
							</div>							
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="mb-2">
			<a href="add" class="btn btn-primary btn-sm">등록</a>		
			<a href="/role/admin" class="btn btn-warning btn-sm">처음으로</a>
		</div>
	</div>
</body>
</html>









