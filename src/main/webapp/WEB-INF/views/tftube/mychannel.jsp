<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="top.jsp"%>
<div class="spacing" id="2-2-1" ><!-- start of 2-2-1 -->
업로드한 동영상<p>
<%-- <table>
<c:choose>
<c:when test="${Video_by_member.size()==0}">
<tr><td>
재생 목록이 없습니다.
</td></tr>
</c:when>
<c:otherwise>
<c:forEach var="videoList" items="${video_by_member}">
<tr><td>
<a href="resources/tftube/uploadVideo/${videoList.video_name}">
<img src="resources/tftube/uploadImage/${videoList.image}" width="300"
height="200"></a><br>
</td></tr>
</c:forEach>
</c:otherwise>
</c:choose> --%>

<c:set var="count" value="0"/>
<c:choose>
<c:when test="${video_by_member.size()==0}">
재생목록이 없습니다
</c:when>
<c:otherwise>
<table>
<tr>
<c:forEach var="videoList" items="${video_by_member}"> 
<td bgcolor="white">
<a href="tftube_videoView?no=${videoList.no}">
<img src="resources/tftube/uploadImage/${videoList.image}" width="196" height="100"><br>
${videoList.title}</a><br>
<a href="tftube_mychannel">${videoList.channel}</a><br>
${videoList.readcount}회  ＊ ${videoList.uploaddate}
</td>
<c:set var="count" value="${count=count+1}"/>
</c:forEach>
<c:if test="${count%5==0}">
</tr><tr>
</c:if>
</tr>
</table>
</c:otherwise>
</c:choose>





구독채널<p>
<table>
<c:choose>
<c:when test="${subing_list.size()==0}">
<tr><td>
구독 하시는 채널이 없습니다.
</td></tr>
</c:when>

<c:otherwise>
<c:forEach var="subingList" items="${subing_list}">
<a href="mychannel?mem_no=${subingList.member_no}">${subingList.channel}</a>
<br>

</c:forEach>
</c:otherwise>
</c:choose>
</td></tr>
</table>



<p>
구독자 <p>
<table>
<c:choose>
<c:when test="${subed_list.size()==0}">
<tr><td>
관심 동영상이 없습니다.
</td></tr>
</c:when>

<c:otherwise>

<c:forEach var="subedList" items="${subed_list}">
<a href="mychannel?mem_no=${subedList.member_no}">${subedList.channel}</a>
<br>
</td></tr>
</c:forEach>
</c:otherwise>
</c:choose>


</table>
</div><!-- end of 2-2-1 -->

<p>
<p>
<p>
<p>
<p>
<%@include file="bottom.jsp" %>


