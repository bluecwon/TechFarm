<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<meta charset="UTF-8">
<%@ include file="header.jsp"%>
<%
String bgPath = config.getServletContext().getRealPath("/WEB-INF/blog/background/"); //백그라운드 이미지 경로
String hdPath = config.getServletContext().getRealPath("/WEB-INF/blog/header/"); //헤더 이미지 경로
%>	
<c:set var = "bg" value="<%=bgPath%>"/>
<c:set var = "hd" value="<%=hdPath%>"/>

<section>
	<article>
		<h2>최신글</h2>
		최신글목록을 불러오자
	</article>  
</section>
<%@ include file="aside.jsp"%>
<%@ include file="footer.jsp"%>