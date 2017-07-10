<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table colspan="2" border="3">
<tr>
<td>
<a href="tftube_main">TFtube </a>
</td> 
<td>검색						 
<c:choose>
<c:when test="${memberDTO==null}"><a href="login">업로드</a>	
		<a href="login">로그인</a>
</c:when>
<c:otherwise>
<a href="tftube_video_insert">업로드</a> 
</c:otherwise></c:choose>		
</td>                            
</tr>
<tr>
<td>
<a href="tftube_main">홈</a><br>
인기<br>

<c:if test="${memberDTO!=null}">
		<a href="tftube_mychannel">내 채널</a><br>
</c:if>
<a href="tftube_recentvideo_listRecent_member_no">최근 본 동영상</a><br>
-----------------------------<br>
음악<br>
스포츠<br>
게임<br>
영화<br>
TV프로그램<br>
뉴스<br>
실시간<br>
</td>
<td>







</body>
</html>