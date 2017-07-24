<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/tftube/cssU.css" />
<link rel="stylesheet" type="text/css" href="resources/tftube/tftubeStyle.css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>TFtube에 오신걸 환영합니다~</title>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#but").click(function() {
			$(".top").slideToggle('fast');
		});
		$("#wideView").click(function() {
			$("#content").toggleClass("wide");
			$(this).toggleClass("wide");
		});
		$("#menu").click(function() {
			$("#header").find(".header_menu").slideDown('normal').show();
		});
		$("#close").click(function() {
			$("#header").find(".header_menu").slideUp('fast').show();
		});
		$("#myinfo").click(function() {
			$("#header").find(".header_info").slideDown('normal').show();
		});
		$("#close2").click(function() {
			$("#header").find(".header_info").slideUp('fast').show();
		});
	});
</script>
</head>
<body>
	<div id="header">
		<Button id="but">펼치기</Button>
		<a href="tftube_main">TFtube</a>

	
	<input type="text" name="search" size="70" style=""> 
	<input type="button" value="검색" width="900">
			<c:choose>
				<c:when test="${memberDTO==null}">
					<a href="login">업로드</a>
					<a href="login">로그인</a>
				</c:when>
				<c:otherwise>
					<a href="tftube_video_insert">업로드</a>
				</c:otherwise>
			</c:choose>	
		<div class="topnav" style="float:right"><!-- align="right" -->
			
			
			<a rel="tooltip" title="메뉴"><img id="menu"
				src="resources/home/imgs/menu.png" width="25" height="25"></a>
			<c:if test="${sessionScope.memberDTO eq null}">
				<a rel="tooltip" title="로그인" href="login"> <img
					src="resources/home/imgs/login.png" width="15px" height="15px">
				</a>
			</c:if>
			<c:if test="${sessionScope.memberDTO ne null}">
				<abbr title="정보보기"> <img id="myinfo"
					src="resources/home/imgs/profile.png" width="25px" height="25px">
				</abbr>
			</c:if>
		</div>
		<div class="header_menu" align="center">
			<table>
				<tr>
					<td align="center"><a href="#" onclick="check('myAccount');"><img
							id="img_handle" src="resources/home/imgs/account.png" width="40%"
							height="35%"></a><br>내계정</td>
					<td align="center"><a href="#"><img id="img_handle"
							src="resources/home/imgs/search.png" width="40%" height="35%"></a><br>검색</td>
					<td align="center"><a href="#"><img id="img_handle"
							src="resources/home/imgs/mail.png" width="40%" height="35%"></a><br>메일</td>
				</tr>
				<tr>
					<td align="center"><a
						href="tfPlusIndex?id=${sessionScope.memberDTO.id}"><img
							id="img_handle" src="resources/home/imgs/social.png" width="40%"
							height="35%"></a><br>SNS</td>
					<td align="center"><a href="tftube_main"><img
							id="img_handle" src="resources/home/imgs/utube.png" width="40%"
							height="35%"></a><br>영상</td>
					<td align="center"><a href="blogmain.do"><img
							id="img_handle" src="resources/home/imgs/document.png"
							width="40%" height="35%"></a><br>블로그</td>
				</tr>
				<tr>
					<td align="center"><a
						href="tfNoteIndex?id=${sessionScope.memberDTO.id}"><img
							id="img_handle" src="resources/home/imgs/memo.png" width="40%"
							height="35%"></a><br>메모</td>
					<td align="center"><a href="chatting"><img id="img_handle"
							src="resources/home/imgs/chatting.png" width="40%" height="35%"></a><br>채팅</td>
					<td align="center"><a href="#"
						onclick="check('listContacts');"><img id="img_handle"
							src="resources/home/imgs/calendar.png" width="40%" height="35%"></a><br>연락처</td>
				</tr>
				<tr>
					<td>
				</tr>
				<tr>
					<td align="center" colspan="3" id="close"><img id="img_handle"
						src="resources/home/imgs/close.png" width="10%" height="20%"></td>
				</tr>
			</table>
		</div>
		<div class="header_info" align="center">
			${sessionScope.memberDTO.name}님 환영합니다.<br>
			${sessionScope.memberDTO.id}<br> ${sessionScope.memberDTO.email}<br>
			<a href="logout">로그아웃</a><br> <a id="close2">닫기</a>
		</div>
		<!-- <br /> -->


	</div>
	<div id="2-1" class="top" style="float: left;">
		<table>
			<tr>
				<td><a href="tftube_main">홈</a><br> 인기<br> <c:if
						test="${memberDTO!=null}">
						<a href="tftube_mychannel">내 채널</a>
						<br>
						<a href="tftube_recentvideo_listRecent_member_no">최근 본 동영상</a>
						<br>
						<a href="likedVideo">관심 동영상</a>
					</c:if>
					<p>
						<a href="tftube_category?category=music">음악</a><br> 
						<a href="tftube_category?category=sport">스포츠</a><br> 
						<a href="tftube_category?category=game">게임</a><br> 
						<a href="tftube_category?category=movie">영화</a><br> 
						<a href="tftube_category?category=comedy">코미디</a><br>
						<a href="tftube_category?category=news/politics">뉴스</a><br> 
						<a href="tftube_category?category=animation">애니메이션</a><br></td>
		</table>
	</div>
	
	<!-- end of 2 -1-->


	<div id="main">