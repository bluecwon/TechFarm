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
	<c:if test="${mode=='guest'}">
	<img src="resources/images/guest.png"  width="100" height="100" class="homemenu"/><br>
	<b>Guest</b>님 <br>
	<input type="button" value="블로그 만들기" onclick="javascript:login();">
	</c:if>
	<c:if test="${mode=='membernoblog'}">
	<img src="resources/images/guest.png"  width="100" height="100" class="homemenu"/><br>
	<b>${sessionScope.memberDTO.id}</b>님 &nbsp;&nbsp;<input type="button" value="로그아웃" style="width:70px;height:25px;"><br>
	<input type="button" value="블로그 만들기" onclick="location.href='blogMake?id=${sessionScope.memberDTO.id}&mode=${mode}'">
	</c:if>
	<c:if test="${mode=='member'}">
	<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="100" height="100" class="homemenu"/><br>
	<b>${sessionScope.memberDTO.id}</b>님 &nbsp;&nbsp;<input type="button" value="로그아웃" style="width:70px;height:25px;"><br>
	<input type="button" value="내 블로그" onclick="location.href='myBlog?id=${sessionScope.memberDTO.id}'">
	</c:if>
	</div>
</aside> 