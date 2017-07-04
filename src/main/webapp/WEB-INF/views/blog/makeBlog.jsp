<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="header.jsp"%>
<%
String bgPath = config.getServletContext().getRealPath("/WEB-INF/blog/background/"); //백그라운드 이미지 경로
String hdPath = config.getServletContext().getRealPath("/WEB-INF/blog/header/"); //헤더 이미지 경로
%>	
<c:set var = "bg" value="<%=bgPath%>"/>
<c:set var = "hd" value="<%=hdPath%>"/>
<section>
	<article>
		<h2>블로그 만들기<img src="resources/images/1step.jpg" align="right" width="150" height="50"></h2>
		<h3>1단계:블로그 기본설정</h3>
		
		<form action="blogMake2.blog" method="post" enctype="multipart/form-data" name="makeblog">
		<input type="hidden" name="id" value="${id}"> 
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="blogname" value="${id}님의 블로그" maxlength="30"></td>
					<td>한글,영문,숫자 혼용가능 (30자 이내)</td>
				</tr>
				<tr>
					<td>별명</td>
					<td><input type="text" name="nickname" maxlength="15"></td>
					<td>한글,영문,숫자 혼용가능 (15자 이내)</td>
				</tr>
				<tr>
					<td>소개글</td>
					<td><textarea rows="10" cols="20" maxlength="200" name="introduce"></textarea></td>
					<td>블로그 프로필 영역의<br>프로필사진 아래에 반영됩니다.<br>(200자 이내)</td>
				</tr>
				<!-- <tr>
					<td>블로그 프로필 사진</td>
					<td><img src="resources/images/noprofile.jpg" border="1" width="150" height="150" id="pfimg"></td>
					<td>
					<input type="file" id="pf" name="profile">
					<input type="button" value="등록" onclick="document.getElementById('pf').click();">
					<input type="button" value="삭제"><br>
					이미지 파일은<br>jpg,png,gif 파일만 등록 가능합니다.
					</td>
				</tr> -->
				<tr>
					<td>타이틀 글</td>
					<td><textarea rows="10" cols="3" maxlength="30" name="headerword"></textarea></td>
					<td>블로그 타이틀 글<br>(30자 이내)</td>
				</tr>
				<tr>
					<td colspan="3" align="center"><hr size="1">
					<input type="submit" value="다음단계">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
					</td>
				</tr>				
			</table>
		</form>	
	</article>  
</section>
<%@ include file="aside.jsp"%>
<%@ include file="footer.jsp"%>