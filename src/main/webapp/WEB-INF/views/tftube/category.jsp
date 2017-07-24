<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="top.jsp"%>

<div class="spacing">
<h2>${category}</h2>
<table>
<tr>
<c:forEach var="cdto" items="${clist}"> 
<td bgcolor="white">
<a href="tftube_videoView?no=${cdto.no}">
<img src="resources/tftube/uploadImage/${cdto.image}" width="196" height="100"><br>
${cdto.title}</a><br>
<a href="tftube_mychannel">${cdto.channel}</a><br>
${cdto.readcount}회  * ${cdto.uploaddate}
</td>
<c:set var="count" value="${count=count+1}"/>
</c:forEach>
<c:if test="${count%6==0}">
</tr><tr>
</c:if>
</table>
</div>

<%@include file="bottom.jsp"%>