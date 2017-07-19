<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
 <%-- <select id="listRecent_inf" parameterType="int" resultType="video_recentvideoDTO">
 select a.*,b.recent_no from tftube_video a join tftube_recentvideo b on a.video_name=b.video_name and b.member_no=#{member_no} order by b.recent_no desc limit 40;
 </select> 
 정확한 이유는파악하지 못했다. 그러나 아직 video_name이 unique가 아니기 때문에 오류가 발생한다.
  --%>	
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
<img src="resources/tftube/uploadImage/${recentVideo.image}" 
width="400" height="250">
비디오 일련번호:${recentVideo.no}
</a>

</div>
<div class="imaj">
${recentVideo.title}<br>
<a href="tftube_mychannel">${recentVideo.channel}</a><br><!-- probability of not working -->
<fmt:formatNumber value="${recentVideo.readcount}" pattern="#,##0"/>회<br>
${recentVideo.description}
</div>

<div class="titl">

<a href="tftube_recentvideo_delete?recent_no=${recentVideo.recent_no}">삭제</a>

</div>
</td>
</tr>
</c:forEach>
</table>
</div>
<%@ include file="main_bottom.jsp"%> 
</body>
</html>