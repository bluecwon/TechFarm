<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="main_top.jsp"%>
<!-- 상단 부분 -->

<div id="content">
	<div class="toolbox">클릭: <a id="wideView" href="#"></a></div>
	<h3>유튜브</h3>
	<p>
		<span style="float:left; margin:0 10px 10px 0;">
			<pvideo>
				<video src="resources/tftube/advertise/soccer.mp4" autoplay controls poster="C:\Users\Public\Pictures\Sample Pictures\Chrysanthemum.jpg"width="300" height="200"/>
			</pvideo>
		</span>
		<c:forEach var="dto" items="${list}"> 
			<a href="tftube_videoView?no=${dto.no}">
				<img src="resources/tftube/uploadImage/${dto.image}" width="196" height="100"/><br>
				${dto.title}<br>
			</a>
			<a href="tftube_mychannel">${dto.channel}</a><br>
			${dto.readcount}회  ＊ ${dto.uploaddate}<br>
			<c:set var="count" value="${count=count+1}"/>
		</c:forEach>
		<!-- 
			src="동영상주소" : 동영상 주소를 입력합니다. 예 - http://www.domain.com/동영상.mp4 
			controls : 동영상을 재생하고 탐색하기 위한 조정 바를 표시합니다.
			loop : 반복 설정합니다. 동영상이 계속 반복됩니다.
			muted : 음소거가 되도록 합니다.
			autoplay : 페이지가 로드되면 바로 동영상이 재생되도록 합니다.
			poster="이미지파일" : 동영상이 플레이 되기 전 대표로 보여줄 이미지파일을 지정합니다. 
		-->
	</p>
</div>		

<!-- 하단 부분 -->
<%@include file="main_bottom.jsp"%>