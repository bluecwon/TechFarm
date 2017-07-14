<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<%@ include file="main_top.jsp"%> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<div>
<c:forEach var="recentlist" items="${recent_list}">
<c:if test="${recent_list.size()==0}">
시청한 동영상이 없습니다.
</c:if>
<a href="tftube_videoView?no=${dto.no}">
<img src="resources/tftube/uploadVideo/${recentlist.video_name}" 
width="600" height="450">
</a>
</div>
<div>
${recent_list.title}<br>
<!-- 이름<br> -->
${recent_list.readcount}<br>
${recent_list.content }
</div>
</c:forEach>
<%@ include file="main_bottom.jsp"%> 
</body>
</html>