<%@page import="org.study.model.Member"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

	<section>
	<h1>회원정보목록</h1>
	
	<div>
	<table border = 1>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입ㄴ일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
		<%
			List<Member> list = (List<Member>) request.getAttribute("list");
			for (Member member : list){
			
		
		%>
		<tr>
			<td><a href="${pageContext.request.contextPath}/update?id=<%= member.getId() %>"><%= member.getId() %></td>
			<td><%= member.getName() %></td>
			<td><%= member.getPhone() %></td>
			<td><%= member.getAddress() %></td>
			<td><%= member.getJoin_date() %></td>
			<% if (member.getGrade().equals("a")){
				%>
				<td>vip</td>
			<%}else if (member.getGrade().equals("b")){
				%>
				<td>일반</td>
			<%}else{%>
				<td>직원</td>
				<%}%>
			<td><%= member.getCity_code() %></td>
			
		</tr>
		<%} %>
	</table>
	</div>

</section>

<%@ include file="/common/footer.jsp" %>

<script>
	
</script>