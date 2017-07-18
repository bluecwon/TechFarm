<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/tftube/style.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="main_top.jsp"%>
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
</body>
</html>