<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/resources/myaccount/header.jsp" %>
<div id="main_my">
<div id="main"><br><br>
				<b>${sessionScope.memberDTO.name}</b>님 환영합니다.<br>
				<b>한 곳</b>에서 <b>TechFarm</b>에 관한 계정을 관리할 수 있습니다.<br>
				<br>
				<br>
				<div id="menu1" align="center">TechFarm 정보
					<table>
						<tr>
							<td>[${sessionScope.memberDTO.name}]님</td>
						</tr>
						<tr>
							<td>${sessionScope.memberDTO.id}</td>
						</tr>
						<tr>
							<td>${sessionScope.memberDTO.email}</td>
						</tr>
						<tr>
							<td><a href="editMyInfo">회원정보 수정</a></td>
						</tr>
						<tr>
							<td><a href="editMyPw">비밀번호 변경</a></td>
						</tr>
						<tr>
							<td><a href="deleteMember">회원 탈퇴</a></td>
						</tr>
					</table>
				</div>
				<div id="menu2">tftube 정보
					<table align="center">
						<c:if test="${tfPlusSize == 0}">
							<tr>
								<td>작성된 프로필이 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<td>총 작성프로필 : ${tfPlusSize}</td>
						</tr>
						<tr>
							<td>
								최근 작성프로필 제목 : ${tfPlusNews.profileName}</br>
								작성날짜 : ${tfPlusNews.profileDate}</br>
								<a href="tfPlusNewsProfileBoardList?profileName=${tfPlusNews.profileName}&id=${tfPlusNews.profileId}&num=${tfPlusNews.profileNum}&my=true&myId=${sessionScope.memberDTO.id}"/>
									<img src="resources/tfPlus/images/contents/profile/${tfPlusNews.photo}" style="width:200px; height:150px;">
								</a>
							</td>
						</tr>
					</table>
				</div>
				<div id="menu3">tblog 정보
					<table align="center">
						<tr>
							<th>총 내가 작성한 글</th>
						</tr>
						<tr>
							<td>${myBoardNumber}</td>
						</tr>
						<tr>
							<th>총 내가 작성한 댓글</th>
						</tr>
						<tr>
							<td>${myReplyNumber}</td>
						</tr>
						<tr>
							<th>내 블로그</th>
						</tr>
						<c:choose>
						<c:when test="${blogoptionDTO == null}">
						<tr>
						<th><br>생성한 블로그가 없습니다.<br><a href="blogStart">지금 만들어보세요.</a></th>
						<tr>
						</c:when>
						<c:otherwise>
						<tr>
							<th>
							<img src="resources/images/skin/${blogoptionDTO.profile}" style="width:150px; height:100px;"><br>
							<a href="myBlog?id=${blogoptionDTO.id}">(${blogoptionDTO.blogname})</a>
							</th>
						</tr>
						</c:otherwise>
						</c:choose>
					</table>
				</div>
				<div id="menu4">tplus 정보</div>
</div>
</div>
</body>
</html>