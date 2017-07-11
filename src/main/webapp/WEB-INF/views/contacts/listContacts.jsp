<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
	<script type="text/javascript">
		function confirmDel(no){
			if(confirm("이 연락처를 삭제하시겠습니까?")){
				location.href="deleteContact?no="+no;
			}
		}
	</script>
</head>
<body>
	<div align="center">
		<table>
			<h2>연락처 목록</h2>
			<c:choose>
				<c:when test="${listContacts.size()==0 }">
					<b>등록된 연락처가 없습니다.</b>
				</c:when>
				<c:otherwise>
					<c:forEach var = "dto" items="${listContacts }">
						<tr>
							<td>${dto.photo }</td>
							<td><a href="getContact?no=${dto.no }">${dto.name }</a></td>
							<td>${dto.email }</td>
							<td>${dto.phone }</td>
							<td><a href="editContact?no=${dto.no }">수정</a></td>
							<td><a href="javascript:onClick=confirmDel('${dto.no }')">삭제</a></td>			
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<div align="right">
		<a href="addContact">연락처 등록</a>
	</div>
	
</body>
</html>