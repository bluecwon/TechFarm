<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<h2>메일함</h2>
			<c:choose>
				<c:when test="${listJames.size()==0 }">
					<b>받은 메일이 없습니다.</b>
				</c:when>
				<c:otherwise>
					<c:forEach var = "dto" items="${listJames }">
						<tr>
							<td>${dto.num }</td>
							<td><a href="sendJames?to=${dto.from}">${dto.from }</a></td>
							<td><a href="getJames?num=${dto.num }">${dto.subject }</a></td>
							<td>${dto.sentDate }</td>
							<td>삭제</a></td>			
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<div align="right">
		<a href="sendJames">메일 쓰기</a>
	</div>
</body>
</html>