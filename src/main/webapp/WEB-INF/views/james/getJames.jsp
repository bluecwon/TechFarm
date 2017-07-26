<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>
	<div class="left">
		<div class="left_content1">
			<div align="center">



		<h1 align="center">메일내용</h1>

		<a href="sendJames">메일 쓰기</a>
		<a href="listJames?folder=INBOX">받은편지함</a>
		<a href="listJames?folder=Sent">보낸편지함</a>
		<a href="listJames?folder=Trash">휴지통</a>

		<div id="contents">
		${jamesDTO.content }
		</div>




			</div>
		</div>
	</div>
	 
<%@ include file="footer.jsp" %>