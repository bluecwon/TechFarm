<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="resources/login/style.css" rel="stylesheet"/>
<title>Welcome to TF</title>
	<script type="text/javascript">
		var goodColor = "#66cc66";
    	var badColor = "#ff6666";
    	function checkId(){
    		var id=document.getElementById('id');
    	}		
		function checkForm(){
			if(member.name.value==""){
				alert("이름를 입력하세요")
				member.name.focus()
				return false;
			}else if(member.email1.value==""){
				alert("이메일을 입력하세요")
				member.email1.focus()
				return false;
			var email=member.email1.value+"@"+member.email2.value;
			member.email.value=email;
			return true;
		}
	</script>
</head>
<body>
	<div class="createmain">
		<table>
			<spring:hasBindErrors name="inputInfo"/>
			<form name="member" action="searchId" method="post" onsubmit="return checkForm()">
			<tr>
				<td><img src="resources/home/imgs/name.png" width="200"></td>
			</tr>
			<tr>
				<td><font size=5>ID 찾기</font></td>
			</tr>
			<tr>
				<td>이름<br><input type="text" name="name" value="${inputInfo.name}">
				<br><form:errors path="inputInfo.name"/></td>
			</tr>
			<tr>
				<td>E-mail<br><input type="text" name="email1" value="${inputInfo.email1}">@<input type="text" name="email2" value="${inputInfo.email2}">
				<br><form:errors path="inputInfo.email"/></td>
			</tr>
				<td><span>회원 가입시 입력했던 email 주소를 입력해주세요.</span></td>
			<tr>
				<td align="center"><input type="submit" value="ID 찾기"><input type="reset" value="다시작성"></td>
			</tr>
			<input type="hidden" name="email">
			</form>
		</table>
	</div>
</body>
</html>