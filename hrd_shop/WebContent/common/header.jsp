<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hrd shop</title>
</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리ver1.0</h1>
	</header>
	<menu>
		<a href="${pageContext.request.contextPath }/register" >회원입력</a>
		<a href="${pageContext.request.contextPath }/member_list" >회원목록조회/수정</a>
		<a href="${pageContext.request.contextPath }/sale_list" >회원매출조회</a>
		<a href="${pageContext.request.contextPath }/" >홈으로</a>
	</menu>