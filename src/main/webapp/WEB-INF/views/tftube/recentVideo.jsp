<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
<%@ include file="main_top.jsp"%> 

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<div> <!-- start of 2-2 -->
<table>
<c:forEach var="recentVideo" items="${recent_list}">
<tr>
<td>
<div class="imaj">
<c:if test="${recent_list.size()==0}">
시청한 동영상이 없습니다.
</c:if>
<a href="tftube_videoView?no=${recentVideo.no}">
<img src="resources/tftube/uploadVideo/${recentlist.video_name}" 
width="400" height="250">
</a>
</div>
<div class="titl">
${recentVideo.title}<br>
<a href="tftube_mychannel">${recentVideo.channel}</a><br><!-- probability of not working -->
<fmt:formatNumber value="${recentVideo.readcount}" pattern="#,##0"/>회<br>
${recentVideo.description}
</div>
</td>
</tr>
</c:forEach>
</table>
</div>
<%@ include file="main_bottom.jsp"%> 
</body>
</html>