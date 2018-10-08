<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

	<section>
		<h1>회원등록</h1>
		
	<form action="${pageContext.request.contextPath }/register 
		method="post"
		id='reg_form'>
		<table>
			<tr>
				<td><label for="id" >회원번호(자동발생)</label></td>
				<td>
					<input type="text" name="id" value="${id}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td><label for="name" >회원성명</label></td>
				<td>
					<input type="text" id='name' name="name" >
				</td>
			</tr>
			<tr>
				<td><label for="phone" >회원전화</label></td>
				<td>
					<input type="text" id='phone' name="phone" >
				</td>
			</tr>
			<tr>
				<td><label for="address" >회원주소</label></td>
				<td>
					<input type="text"  id='address' name="address" required>
				</td>
			</tr>
			<tr>
				<td><label for="join_date" >가입일자</label></td>
				<td>
					<input type="date" id='join_date'name="join_date" required>
				</td>
			</tr>
			<tr>
				<td><label for="grade" >회원등급</label></td>
				<td>
					<input type="text" id='grade' name="grade" required>
				</td>
			</tr>
			<tr>
				<td><label for="city_code" >도시코드</label></td>
				<td>
					<input type="text"  id='city_code'name="city_code" required>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button id='reg_button' type='button' onclick='register()'>
						등록
					</button>
					<button id='list_button' type='button' onclick='list_member()'>
						조회
					</button>
			</tr>
		</table>
	</form>
</section>

<%@ include file="/common/footer.jsp" %>

<script>
	var request;
	function register() {
		if (validate() == false) {
			return;
		
		} 
		if (validate2() == false) {
			return;
		
		} 
		if (validate3() == false) {
			return;
		
		} 
		if (validate4() == false) {
			return;
		
		} 
		if (validate5() == false) {
			return;
		
		} 
		if (validate6() == false) {
			return;
		
		} 
		
		var formObj = document.getElementById('reg_form');
		var elements = formObj.elements;
		var params = '';
		
		for (var i = 0; i < elements.length; i++) {
			if (elements[i].value != '') {
				params += elements[i].name + "=" + 
					encodeURIComponent(elements[i].value) + "&";
			}
		}
		
		console.log(params);
		
		request = new XMLHttpRequest();
		
		try {
			request.onreadystatechange = getResult;
			request.open("POST",
						"${pageContext.request.contextPath}/register",
						true);
			request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			request.send(params);
		} catch(e) {
			alert('서버로 요청 실패');
		}
	}
	
	function getResult() {
		if (request.readyState == 4) {
			
			if (request.status == 200) {
				alert('로딩 완료');
			}
			
		}
	}
	
	function validate() {
		var name = document.getElementById('name');
		
		if (name.value == '') {
			alert('회원성명이 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
	
	function validate2() {
		var phone = document.getElementById('phone');
		
		if (phone.value == '') {
			alert('회원전화번호가 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
	
	function validate3() {
		var address = document.getElementById('address');
		
		if (address.value == '') {
			alert('회원주소가 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
	function validate4() {
		var join_date = document.getElementById('join_date');
		
		if (join_date.value == '') {
			alert('가입날자가 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
	function validate5() {
		var grade = document.getElementById('grade');
		
		if (grade.value == '') {
			alert('회원등급이 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
	function validate6() {
		var city_code = document.getElementById('city_code');
		
		if (city_code.value == '') {
			alert('도시코드가 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
</script>