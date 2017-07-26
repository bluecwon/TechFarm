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
	<c:if test="${membermode=='guest'}">
	<img src="resources/images/guest.png"  width="180" height="180" class="homemenu"/><br><br>
	<b>Guest</b>님 환영합니다.<br><a href="login" id="login">로그인</a>해서 더 많은 서비스를 이용해보세요!<br><br>
	<input type="button" value="블로그 만들기" onclick="javascript:login();">
	</c:if>
	<c:if test="${membermode=='membernoblog'}">
	<img src="resources/images/guest.png"  width="180" height="180" class="homemenu"/><br><br>
	<b>${sessionScope.memberDTO.id}</b>님  환영합니다.<br><br>
	<input type="button" value="블로그 만들기" onclick="location.href='blogMake?id=${sessionScope.memberDTO.id}&mode=${mode}'">
	</c:if>
	<c:if test="${membermode=='member'}">
	<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="180" height="180" class="homemenu"/><br><br>
	<b>${sessionScope.memberDTO.id}</b>님  환영합니다.<br><br>
	<input type="button" value="내 블로그" onclick="location.href='myBlog?id=${sessionScope.memberDTO.id}'">
	</c:if>
	</div>
	<div class="blogsearch">
		<select name="search">
			<option value="블로그이름"></option>
			<option value="아이디"></option>
			<option value="블로그이름"></option>
		</select>
	</div>
</aside> 