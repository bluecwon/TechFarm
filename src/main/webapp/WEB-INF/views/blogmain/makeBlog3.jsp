<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<%
String bgPath = config.getServletContext().getRealPath("/WEB-INF/blog/background/"); //백그라운드 이미지 경로
String hdPath = config.getServletContext().getRealPath("/WEB-INF/blog/header/"); //헤더 이미지 경로
%>	
<c:set var = "bg" value="<%=bgPath%>"/>
<c:set var = "hd" value="<%=hdPath%>"/>
<section>
	<article>
		<h1>블로그 만들기<img src="resources/images/2step.jpg" align="right" width="150" height="50"></h1>
		<h2>3단계:블로그 꾸미기</h2>
		<form action="blogMakePro" method="post" enctype="multipart/form-data">
		<input type="hidden" name="blogname" value="${blogname}">
		<input type="hidden" name="nickname" value="${nickname}">
		<input type="hidden" name="introduce" value="${introduce}">
		<input type="hidden" name="layout" value="${layout}">
		<input type="hidden" name="id" value="${id}">
		<input type="hidden" name="headerword" value="${headerword}">
			<table>
				<tr>
					<td>스킨</td>
					<td width="75%">
					<input type="button" value="미리보기"><br>
					<div align="center">
					<table width="100%">
						<tr>
							<td>고양이</td>
							<td width="20%"><input type="radio" name="skin" value="skin1"></td>
							<td width="20%"><input type="radio" name="skin" value="skin2"></td>
							<td width="20%"><input type="radio" name="skin" value="skin3"></td>
							<td width="20%"><input type="radio" name="skin" value="skin4"></td>
						</tr>
						<tr>
							<td>강아지</td>
							<td width="20%"><input type="radio" name="skin" value="skin5"></td>
							<td width="20%"><input type="radio" name="skin" value="skin6"></td>
							<td width="20%"><input type="radio" name="skin" value="skin7"></td>
							<td width="20%"><input type="radio" name="skin" value="skin8"></td>
						</tr>
						<tr>
							<td>봄</td>
							<td width="20%"><input type="radio" name="skin" value="skin9"></td>
							<td width="20%"><input type="radio" name="skin" value="skin10"></td>
							<td width="20%"><input type="radio" name="skin" value="skin11"></td>
							<td width="20%"><input type="radio" name="skin" value="skin12"></td>
						</tr>
						<tr>
							<td>여름</td>
							<td width="20%"><input type="radio" name="skin" value="skin13"></td>
							<td width="20%"><input type="radio" name="skin" value="skin14"></td>
							<td width="20%"><input type="radio" name="skin" value="skin15"></td>
							<td width="20%"><input type="radio" name="skin" value="skin16"></td>
						</tr>
						<tr>
							<td>가을</td>
							<td width="20%"><input type="radio" name="skin" value="skin17"></td>
							<td width="20%"><input type="radio" name="skin" value="skin18"></td>
							<td width="20%"><input type="radio" name="skin" value="skin19"></td>
							<td width="20%"><input type="radio" name="skin" value="skin20"></td>
						</tr>
						<tr>
							<td>겨울</td>
							<td width="20%"><input type="radio" name="skin" value="skin21"></td>
							<td width="20%"><input type="radio" name="skin" value="skin22"></td>
							<td width="20%"><input type="radio" name="skin" value="skin23"></td>
							<td width="20%"><input type="radio" name="skin" value="skin24"></td>
						</tr>
						<tr>
							<td>하늘</td>
							<td width="20%"><input type="radio" name="skin" value="skin25"></td>
							<td width="20%"><input type="radio" name="skin" value="skin26"></td>
							<td width="20%"><input type="radio" name="skin" value="skin27"></td>
							<td width="20%"><input type="radio" name="skin" value="skin28"></td>
						</tr>
						<tr>
							<td>패턴</td>
							<td width="20%"><input type="radio" name="skin" value="skin29"></td>
							<td width="20%"><input type="radio" name="skin" value="skin30"></td>
							<td width="20%"><input type="radio" name="skin" value="skin31"></td>
							<td width="20%"><input type="radio" name="skin" value="skin32"></td>
						</tr>	
					</table>
					</div>
					</td>
					<td>마음에 드는<br> 스킨으로<br> 블로그를<br> 꾸며보세요</td>
				</tr>
				<tr>
					<td>배경<br> 이미지</td>
					<td></td>
					<td>
					<!-- <input type="file" id="bg" name="background" value="ssd">
					<input type="button" value="등록" onclick="document.getElementById('bg').click();">
					<input type="button" value="삭제"> -->
					</td>
				</tr>
				<tr>
					<td>타이틀<br> 이미지</td>
					<td></td>
					<td>
					<!-- <input type="file" id="hd" name="header">
					<input type="button" value="등록" onclick="document.getElementById('hd').click();">
					<input type="button" value="삭제"> -->
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center"><hr size="1">
					<input type="submit" value="만들기">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
					</td>
				</tr>				
			</table>
		</form>	
	</article>  
</section>
<%@ include file="aside.jsp"%>
<%@ include file="footer.jsp"%>