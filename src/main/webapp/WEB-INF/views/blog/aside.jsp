<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<meta charset="UTF-8"> 
<% 
String pfPath = config.getServletContext().getRealPath("/WEB-INF/blog/profile/"); //프로필 이미지 경로
%>
<c:set var = "pf" value="<%=pfPath%>"/>
<aside>
	<div align="center" class="ad">
	<img src="resources/images/guest.png" onclick="location.href='login.do'" style="cursor:pointer;" width="100" height="100" 

class="homemenu"/><br>
	<b>${id}</b>님 &nbsp;&nbsp;<input type="button" value="로그아웃" style="width:70px;height:25px;"><br>
	<!-- 블로그가 있으면 -->
	<input type="button" value="내 블로그">
	<!-- 블로그가 없으면 -->
	<input type="button" value="블로그 시작!" onclick="location.href='blogMake.blog?id=${id}'">
	</div>
</aside> 