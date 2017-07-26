<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/tftube/cssU.css"/>
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
	});
</script>


	<div id="header1">
		<div class="imaj"><input type="button" id="but" src="resources/tftube/imgs/fold.JPG">
		<a href="tftube_main"><font size=6>TF</font><img src="resources/tftube/imgs/tube.jpg"></a></div>	
		<div class="titl"><form action="tftube_search" method="post">
	<input type="text" name="search_text" size="70" maxlength="70" alt="음메">  
	<select name="search">
<option value="channel">작성자</option>
<option value="description">내용</option>
<option value="title" selected>제목</option>
</select>	 
	<input type="submit" value="검색" width="900">
	
			<c:choose>
				<c:when test="${memberDTO==null}">
					<a href="login">업로드</a>
					<a href="login">로그인</a>
				</c:when>
				<c:otherwise>
					<a href="tftube_video_insert">업로드</a>
				</c:otherwise>
			</c:choose>	
		</form>	
	</span>


	</div><!-- end of header1 -->
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