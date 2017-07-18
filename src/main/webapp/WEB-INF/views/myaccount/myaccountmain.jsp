<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/resources/myaccount/header.jsp" %>
<div id="main"><br><br>
				<b>${sessionScope.memberDTO.name}</b>님 환영합니다.<br>
				<b>한 곳</b>에서 <b>TechFarm</b>에 관한 계정을 관리할 수 있습니다.<br>
				<br>
				<div id="menu1">TechFarm 정보
					<table align="center">
						<tr>
							<td>[${sessionScope.memberDTO.name}]님</td>
						</tr>
						<tr>
							<td>${sessionScope.memberDTO.id}</td>
						</tr>
						<tr>
							<td>${sessionScope.memberDTO.email}</td>
						</tr>
						<tr>
							<td><a href="editMyInfo">회원정보 수정</a></td>
						</tr>
						<tr>
							<td><a href="editMyPw">비밀번호 변경</a></td>
						</tr>
						<tr>
							<td><a href="deleteMember">회원 탈퇴</a></td>
						</tr>
					</table>
				</div>
				<div id="menu2">tftube 정보</div>
				<div id="menu3">tblog 정보</div>
				<div id="menu4">tplus 정보</div>
</div>
</body>
</html>