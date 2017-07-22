<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="main_top.jsp"%>

<link rel="stylesheet" type="text/css" href="resources/tftube/style.css">

<div> <!-- start of 2-2-1 -->

<c:choose>
<c:when test="${like_list.size()==0}">
관심 목록이 없습니다.
</c:when>

<c:otherwise>
<table>
<c:forEach var="likeList" items="${like_list}">
<tr><td>
<div id="imaj"><!-- start of 2-2-1 -->
<img src="resources/tftube/uploadImage/${likeList.image}" 
width="400" height="250">
</div><!-- end of 2-2-1 -->

<div id="titl"><!-- start of 2-2-2 -->
${likeList.title}<br>
${likeList.channel}
</div><!-- end of 2-2-2 -->
</td></tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</div><!-- end of 2-2 -->
</div><!-- end of 2 -->
<%@ include file="main_bottom.jsp"%> 

