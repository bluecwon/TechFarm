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
<script type="text/javascript">
function delete_recent(){
	location.href="tftube_recentvideo_delete";
};
</script>
</head>
<div> <!-- start of 2-2 -->
<a href="tftube_recentvideo_delete_all"><button>모두지우기</button></a>
<table>
<c:forEach var="recentVideo" items="${recent_list}">
<tr>
<td>
<div class="imaj">
<c:if test="${recent_list.size()==0}">
시청한 동영상이 없습니다.
</c:if>
<a href="tftube_videoView?no=${recentVideo.no}">
<img src="resourc\es/tftube/uploadImage/${recentVideo.image}" 
width="400" height="250">

</a>
</div>
<div class="imaj">
${recentVideo.title}<br>
<a href="tftube_mychannel">${recentVideo.channel}</a><br><!-- probability of not working -->
<fmt:formatNumber value="${recentVideo.readcount}" pattern="#,##0"/>회<br>
${recentVideo.description}
</div>

<div class="titl">

<a href="tftube_recentvideo_delete?no=${recentVideo.no}">삭제</a>

</div>
</td>
</tr>
</c:forEach>
</table>
</div>
<%@ include file="main_bottom.jsp"%> 
</body>
</html>