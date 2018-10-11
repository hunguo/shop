<%@page import="org.study.model.Sale"%>
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
			<th>회원등급</th>
			<th>매출</th>
		</tr>
		<%
			List<Sale> list = (List<Sale>) request.getAttribute("list");
			for (Sale sale : list){
			
		
		%>
		<tr>
			<td><%= sale.getId() %></td>
			<td><%= sale.getName() %></td>
			<% if (sale.getGrade().equals("a")){
				%>
				<td>vip</td>
			<%}else if (sale.getGrade().equals("b")){
				%>
				<td>일반</td>
			<%}else{%>
				<td>직원</td>
				<%}%>
	        <td><%= sale.getSales() %></td>
			
		</tr>
		<%} %>
	</table>
	</div>

</section>

<%@ include file="/common/footer.jsp" %>

<script>
	
</script>