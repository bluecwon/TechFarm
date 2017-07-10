<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>
<!-- 상단 부분 -->

		<!-- 메인 시작 -->
		<div id="main">	
		
			<div class="wrapper">
			
				<!-- 메인 이미지 + 텍스트상자 시작 -->
				<div id="slider-holder" class="clearfix">
				
					<!-- 메인 이미지 시작 -->
					<div class="flexslider home-slider">
						<ul class="slides">
						<c:forEach var="dto" items="${newsProfileList}"> 
							<li>
								<img src="${newsProfileUpPath}/${dto.photo}" width="700px" height="300px" alt="alt text" />
								<p class="flex-caption">${dto.profileContents}</p>
							</li>
						</c:forEach>
						</ul>
					</div>
					<!-- 메인 이미지 끝 -->
					
					<div class="home-slider-clearfix "></div>
					
					<!-- 메인 텍스트 상자 시작 -->
					<div id="headline">
						<h1>회원님이 관심있을만한 소식</h1>
		        		<p>ㅇㅇㅇㅇㅇ</p>
		        		<p>ㅇㅇㅇ <a href="#">글씨는 두껍게</a>ㅇㅇㅇㅇ</p>
		        		<em id="corner"></em>
		        	</div>
		        	<!-- 메인 텍스트 상자 끝 -->
		        	
		        </div>
		        <!-- 메인 이미지 + 텍스트상자 끝 -->
		        
		        <!-- 메인 소식 이미지박스 시작 -->
		        <div class="home-block">
		        	<h2 class="home-block-heading"><span>소식 모음</span></h2>
		        	<div class="one-third-thumbs clearfix" >
		        	
		        		<c:set var="count" value="1"/>
		        		<c:forEach var="dto" items="${newsProfileList}"> 
		        			<c:choose>
		        				<c:when test="${count!=3 and count!=6}">
		        					<figure>
					        			<figcaption>
					        				<strong>${dto.profileName}</strong>
				        					<span>${dto.profileContents}</span>
				        					<em>${dto.profileDate}</em>
				        				</figcaption>
				        				<c:if test="${dto.profileId == sessionScope.memberDTO.id}">
				        					<a href="tfPlusNewsProfileBoardList?profileName=${dto.profileName}&id=${dto.profileId}&num=${dto.profileNum}&my=true"  class="thumb">
				        				</c:if>
				        				<c:if test="${dto.profileId != sessionScope.memberDTO.id}">
				        					<a href="tfPlusNewsProfileBoardList?profileName=${dto.profileName}&id=${dto.profileId}&num=${dto.profileNum}&my=false&myId=${sessionScope.memberDTO.id}" class="thumb">
				        				</c:if>
				        					<img src="${newsProfileUpPath}/${dto.photo}" id="img_size" alt="Alt text" />
				        				</a>
				        			</figure>
		        				</c:when>
		        				<c:otherwise>
		        					<figure class="last">
					        			<figcaption>
					        				<strong>${dto.profileName}</strong>
				        					<span>${dto.profileContents}</span>
				        					<em>${dto.profileDate}</em>
				        				</figcaption>
				        				<c:if test="${dto.profileId == sessionScope.memberDTO.id}">
				        					<a href="tfPlusNewsProfileBoardList?profileName=${dto.profileName}&id=${dto.profileId}&num=${dto.profileNum}&my=true"  class="thumb">
				        				</c:if>
				        				<c:if test="${dto.profileId != sessionScope.memberDTO.id}">
				        					<a href="tfPlusNewsProfileBoardList?profileName=${dto.profileName}&id=${dto.profileId}&num=${dto.profileNum}&my=false&myId=${sessionScope.memberDTO.id}" class="thumb">
				        				</c:if>
				        					<img src="${newsProfileUpPath}/${dto.photo}" id="img_size" alt="Alt text" />
				        				</a>
				        			</figure>
		        				</c:otherwise>
		        			</c:choose>
		        			<c:set var="count" value="${count = count + 1}"/>
	        			</c:forEach>
	        			<a href="tfPlusNewsProfileList" class="more-link right">더보기..  &#8594;</a>
		        	</div>
		        </div>
	        	<!-- 메인 소식 이미지박스 끝 -->
	        	
	        	<!-- 메인 커뮤니티 이미지박스 시작 -->
	        	<div class="home-block">
	        	
	        		<h2 class="home-block-heading"><span>커뮤니티 모음</span></h2>
	        		<div class="one-fourth-thumbs clearfix">
	        			<figure>
		        			<figcaption>
	        					<strong>글 제목</strong>
	        					<span>글내용</span>
	        					<em>작성날짜</em>
	        					<a href="single.html" class="opener"></a>
			        		</figcaption>
			        		<a href="single.html"  class="thumb"><img src="resources/tfPlus/img/dummies/featured-7.jpg" alt="Alt text" /></a>
		        		</figure>
		        		<figure>
		        			<figcaption>
	        					<strong>글 제목</strong>
	        					<span>글내용</span>
	        					<em>작성날짜</em>
	        					<a href="single.html" class="opener"></a>
			        		</figcaption>
			        		<a href="single.html"  class="thumb"><img src="resources/tfPlus/img/dummies/featured-8.jpg" alt="Alt text" /></a>
		        		</figure>
		        		<figure>
		        			<figcaption>
	        					<strong>글 제목</strong>
	        					<span>글내용</span>
	        					<em>작성날짜</em>
	        					<a href="single.html" class="opener"></a>
			        		</figcaption>
			        		<a href="single.html"  class="thumb"><img src="resources/tfPlus/img/dummies/featured-9.jpg" alt="Alt text" /></a>
		        		</figure>
		        		<figure class="last">
		        			<figcaption>
	        					<strong>글 제목</strong>
	        					<span>글내용</span>
	        					<em>작성날짜</em>
	        					<a href="single.html" class="opener"></a>
			        		</figcaption>
			        		<a href="single.html"  class="thumb"><img src="resources/tfPlus/img/dummies/featured-10.jpg" alt="Alt text" /></a>
		        		</figure>
		        		<a href="#" class="more-link right">더보기..  &#8594;</a>
		        	</div>
		        
		        </div>
	        	<!-- 메인 커뮤니티 이미지 박스 끝 -->
	        	
	        </div>
		</div>
		<!-- 메인 끝 -->

<!-- 하단 부분 -->
<%@include file="footer.jsp"%>


























