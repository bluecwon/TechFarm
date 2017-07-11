<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<!-- 상단 부분 -->

		<!-- MAIN -->
		<div id="main">	
			<div class="wrapper clearfix">
			
				<!-- 커뮤니티 게시물 리스트 시작 -->
	        	<div id="posts-list">
	        	
	        		<h2 class="page-heading">
	        			<span>
	        				${memberBoardName}
	        				<c:if test="${memberprofileId==sessionScope.memberDTO.id}">
		        				<a href="#" onclick="window.open('tfPlusMemberProfileBoardWriting?name=${memberBoardName}','window','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=715,height=500,left=500, top=250, scrollbars=yes');return false"  title="게시물을 등록할까요?" class="poshytip">
		        					<img src="resources/tfPlus/img/social/plus.png"/>
		        				</a>
	        				</c:if>
	        			</span>
	        		</h2>	
	        		
	        		<c:if test="${memberBoardList.size() == 0}">
        				<article class="format-standard">
							<h2  class="post-heading"><a href="#">등록된 글이 없습니다.</a></h2>
						</article>
	        		</c:if>
	        		<c:forEach var="dto" items="${memberBoardList}">
	        		<c:set var="profileBoardNum" value="${dto.mProfileBoardPK}"/>
	        			<c:choose>
	        				<c:when test="${memberBoardList.size() != 0}">
	        					<article class="format-standard">
	        						<c:set var="BoardDate" value="${dto.mProfileBoardDate}"/>
									<div class="entry-date">
										<div class="number">${fn:substring(BoardDate,8,10)}</div> 
										<div class="year">${fn:substring(BoardDate,5,7)}, ${fn:substring(BoardDate,0,4)}</div>
									</div>
									<div class="feature-image">
										<a href="${memberProfileBoardUpPath}/${dto.mProfileBoardPhoto}" data-rel="prettyPhoto">
											<img src="${memberProfileBoardUpPath}/${dto.mProfileBoardPhoto}" alt="Alt text" width="600px" height="300px"/>
										</a>
									</div>
									<h2  class="post-heading"><a href="#">${dto.mProfileBoardTitle}</a></h2>
									<div class="excerpt">${dto.mProfileBoardContents}</div>
									<a href="#" class="read-more">더보기 &#8594;</a>
									<div class="div_add">
										<div class="meta">
											<div class="categories">좋아요 : ${dto.mProfileBoardGood}</div>
											<div class="comments"><a href="javascript:;">댓글 보기</a></div>
											<div class="user">작성자 : ${dto.mProfileBoardName}</div>
										</div>
										
										<!-- 댓글 -->
										<table class="jjm494_add">
											<c:if test="${memberAddList.size() == 0}">
												<tr>
													<th></th>
													<td>등록된 댓글이 하나도 없습니다.</td>
												</tr>
											</c:if>
											<c:forEach var="dto" items="${memberAddList}">
												<c:choose>
													<c:when test="${dto.mProfileBoardFK == profileBoardNum}">
														<tr>
															<th scope="row">
																${dto.mProfileAddName}
																<a href="javascript:;">삭제</a>
															</th>
															<td>
																<div class="subMenuDiv_add">
																	${dto.mProfileAddContents}
																	<a href="javascript:;">답글</a>
																	<form>
																		<table class="jjm494_subAdd">
																			<tr>
																				<th scope="row">여긴 아직 test</th>
																				<td>
																					<input name="profileBoardTitle" type="text" class="form-poshytip" title="내용을 입력하세요"/>
																					<input type="submit" value="등록">
																				</td>
																			</tr>
																		</table>
																	</form>
																</div>
															</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<th></th>
															<td>등록된 댓글이 하나도 없습니다.</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</table>
										
										<form name="f" action="tfPlusMemberProfileAddPro" method="post">
											<table class="jjm494_add">
											    <tr>
											        <th scope="row">${sessionScope.memberDTO.name}</th>
											        <td>
											        	<input name="profileAddContents" type="text" class="form-poshytip" title="내용을 입력하세요."/>
											        	<input type="submit" value="등록">
														<!-- 히든으로 넘어갈 정보들 -->
															<input type="hidden" value="${sessionScope.memberDTO.id}" name="profileAddId" id="to" />
															<input type="hidden" value="${sessionScope.memberDTO.name}" name="profileBoardName" id="to" />
															<input type="hidden" value="${profileBoardNum}" name="profileBoardFK" id="to" />
															
															<input type="hidden" value="${memberBoardName}" name="profileName" id="to" />
															<input type="hidden" value="${memberprofileId}" name="id" id="to" />
															<input type="hidden" value="${num}" name="num" id="to" />
															<input type="hidden" value="${my}" name="my" id="to" />
														<!-- 히든으로 넘어갈 정보들 -->
													</td>
											    </tr>
											</table>
										</form>
										<!-- 댓글 끝 -->
										
									</div>
								</article>
	        				</c:when>
						</c:choose>
					</c:forEach>
					
					<!-- 소식 게시물 페이지 처리 시작 -->
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