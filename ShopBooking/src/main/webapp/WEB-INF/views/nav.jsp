<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.member == null}">
	<div class="my-2">
		<a href="/login" class="btn btn-sm btn-primary">로그인</a>
	</div>
</c:if>
<c:if test="${sessionScope.member != null}">	
	<div class="my-2">
		${sessionScope.member.id} (${sessionScope.member.role})
		<a href="/logout" class="btn btn-sm btn-primary">로그아웃</a>
	</div>
</c:if>