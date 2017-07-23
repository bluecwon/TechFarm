<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="top.jsp"%>

<link rel="stylesheet" type="text/css" href="resources/tftube/style.css">

<div> <!-- start of 2-2-1 -->
<c:choose>
<c:when test="${like_list.size()==0}">
관심 목록이 없습니다.
</c:when>
<c:otherwise>

<c:forEach var="likeList" items="${like_all_list}">
<div id="like-one-line">

<div style="float:left"><!-- start of 2-2-1 -->
<a href="tftube_videoView?no=${likeList.no}">
<img src="resources/tftube/uploadImage/${likeList.image}" 
width="300" height="200"></a>
</div>

<div style="overflow:hidden"><!-- start of 2-2-2 -->
<a href="tftube_videoView?no=${likeList.no}">${likeList.title}</a><br>
<a href="tftube_mychannel">${likeList.channel}</a>
</div><!-- end of 2-2-2 -->
</div><!-- end of like one line -->
</c:forEach>

</c:otherwise>
</c:choose>
</div>
</div>
<%@ include file="bottom.jsp"%> 

