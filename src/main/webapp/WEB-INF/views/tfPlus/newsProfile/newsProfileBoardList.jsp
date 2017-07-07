<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<!-- 상단 부분 -->

		<!-- MAIN -->
		<div id="main">	
			<div class="wrapper clearfix">
			
				<!-- 소식 게시물 리스트 시작 -->
	        	<div id="posts-list">
	        	
	        		<h2 class="page-heading">
	        			<span>
	        				정재문
	        				<a href="#" onclick="window.open('tfPlusBoardWriting','window','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=715,height=500,left=500, top=250, scrollbars=yes');return false"  title="게시물을 등록할까요?" class="poshytip">
	        					<img src="resources/tfPlus/img/social/plus.png"/>
	        				</a>
	        			</span>
	        		</h2>	
	        		
	        		<c:forEach var="dto" items="${newsBoardList}">
	        			<c:choose>
	        				<c:when test="${newsBoardList.size() != 0}">
	        					<article class="format-standard">
	        						<c:set var="BoardDate" value="${dto.profileBoardDate}"/>
									<div class="entry-date"><div class="number">${fn:substring(BoardDate,8,10)}</div> <div class="year">06, 2017</div></div>
									<div class="feature-image">
										<a href="img/slides/01.jpg" data-rel="prettyPhoto"><img src="img/slides/01.jpg" alt="Alt text" /></a>
									</div>
									<h2  class="post-heading"><a href="#">글 제목</a></h2>
									<div class="excerpt">글 내용ㅂㅈ업쟈앚어대-ㅏㅏ아아재아애ㅏㅏㅐㅈ베ㅐㅇ제ㅐ롭재래뱌ㅓ래버래ㅑㅂ저랴ㅐㅂ저랴ㅐㅓㅂ재러배ㅑ러ㅐㅑ
									</div>
									<a href="single.html" class="read-more">더보기 &#8594;</a>
									<div class="meta">
										<div class="categories">In <a href="#">팔로우 수 </a>, <a href="#">ㅇㅂㅈ</a></div>
										<div class="comments"><a href="#">5 댓글수 </a></div>
										<div class="user"><a href="#">사용자 정보보기</a></div>
									</div>
								</article>
	        				</c:when>
						</c:choose>
					</c:forEach>
					
					<!-- 소식 게시물 페이지 처리 시작 -->
					<div class="page-navigation clearfix">
	    				<div class="nav-next">
	    					<a  href="#">&#8592; 이전 페이지</a>
	    				</div>
	    				<div class="nav-previous">
	    				    <a href="#">다음 페이지 &#8594;</a> 
	    				</div>
	    			</div>
		        	<!--소식 게시물 페이지 처리 끝 -->
	        		
	        	</div>
	        	<!-- 소식 게시물 리스트 끝 -->
		
				<!-- 사이드 메뉴 -->
	        	<aside id="sidebar">
	        		<ul>
		        		<li class="block">
			        		<h4>사이드 메뉴</h4>
							<ul>
								<li class="cat-item"><a href="#" title="View all posts">ㅇㅂ즈애브애ㅡㅂ으ㅐ뱌즈ㅐ으배즈아</a></li>
								<li class="cat-item"><a href="#" title="View all posts">2</a></li>
								<li class="cat-item"><a href="#" title="View all posts">3</a></li>
								<li class="cat-item"><a href="#" title="View all posts">4</a></li>
								<li class="cat-item"><a href="#" title="View all posts">5</a></li>
								<li class="cat-item"><a href="#" title="View all posts">6</a></li>
								<li class="cat-item"><a href="#" title="View all posts">7</a></li>
								<li class="cat-item"><a href="#" title="View all posts">8</a></li>
							</ul>
		        		</li>
		        		<li class="block">
			        		<h4>하단 메뉴</h4>
							<ul>
								<li class="cat-item"><a href="#" title="View all posts">9</a></li>
								<li class="cat-item"><a href="#" title="View all posts">11</a></li>
								<li class="cat-item"><a href="#" title="View all posts">22</a></li>
							</ul>
		        		</li>
	        		</ul>
	        		<em id="corner"></em>
	        	</aside>
				<!-- 사이드 메뉴 끝 -->
	        	
			</div>
		</div>
		<!-- ENDS MAIN -->

<!-- 하단 부분 -->
<%@include file="../footer.jsp"%>