<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%@include file="main_top.jsp"%>
<table>
<!-- <tr><td>생성된 재생목록<br>
재생 목록이 없습니다.
</td></tr> -->
<%int count=0;%>
<tr><td>업로드한 동영상<br>
<tr>
<c:choose>
<c:when test="${list.size==0}">
재생 목록이 없습니다.
</c:when>
<c:otherwise>
<c:forEach var="dto" items="${list}"> 
<td>
<a href="tftube_videoView?no=${dto.no}">
<img src="resources/tftube/uploadImage/${dto.image}" width="196" height="100"><br>
${dto.title}</a></td>
<c:set var="count" value="<%=++count%>"/>
<c:if test="${count%6==0}">
</tr><tr>
</c:if>
</c:forEach>
</c:otherwise>
</c:choose>
</td></tr>
<tr><td>좋아요 표시한 동영상</td></tr>
list
<tr><td>구독채널</td></tr>
list
<tr><td>구독자</td></tr>
lsit
</table>



<%@include file="main_bottom.jsp" %>
</body>

</html>