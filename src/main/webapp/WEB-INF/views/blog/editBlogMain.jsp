<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
<%@ include file="editBlogTop.jsp"%>
		<td valign="top">
<form action="editBlog" method="post" enctype="multipart/form-data">
<br>
&nbsp;&nbsp;&nbsp;<input type="submit" value="저장">
<br><br>
<input type="hidden" value="${mode}">	

<c:if test="${mode=='profile'}">
	<div align="center">
	<h1>프로필 사진 변경</h1><br>
	<input type="hidden" name="id" value="${optionDTO.id}">
	<input type="hidden" name="mode" value="${mode}">
	<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="200px" height="200px" id="pfimg"><br>
	<input type="file" name="profile" id="pf">
	<input type="button" value="등록" onclick="document.getElementById('pf').click();">
	<br>
	이미지 파일은 jpg,png,gif 파일만 등록 가능합니다.
	<br><br>
	<h1>소개 글 변경</h1><br>
	<textarea rows="10" cols="20" maxlength="200" name="introduce">${optionDTO.introduce}</textarea>
	</div>
</c:if>

<c:if test="${mode=='layout'}">
	<div align="center">
		<h1>레이아웃 변경</h1><br>
		<input type="hidden" name="id" value="${optionDTO.id}">
		<input type="hidden" name="mode" value="${mode}">
		<input type="radio" name="layout" value="1" id="layout1" checked style="display:none;">
		<img src="resources/images/layout/layout1on.jpg" onclick='layoutChoice(1)' style="cursor:pointer;" class="layout1">
		<input type="radio" name="layout" value="2" id="layout2" style="display:none;">&nbsp;
		<img src="resources/images/layout/layout2.jpg" onclick='layoutChoice(2)' style="cursor:pointer;" class="layout2">
		<input type="radio" name="layout" value="3" id="layout3" style="display:none;">&nbsp;
		<img src="resources/images/layout/layout3.jpg" onclick='layoutChoice(3)' style="cursor:pointer;" class="layout3">
		<input type="radio" name="layout" value="4" id="layout4" style="display:none;">&nbsp;
		<img src="resources/images/layout/layout4.jpg" onclick='layoutChoice(4)' style="cursor:pointer;" class="layout4">
		<input type="radio" name="layout" value="5" id="layout5" style="display:none;">&nbsp;
		<img src="resources/images/layout/layout5.jpg" onclick='layoutChoice(5)' style="cursor:pointer;" class="layout5">
		<input type="radio" name="layout" value="6" id="layout6" style="display:none;">&nbsp;
		<img src="resources/images/layout/layout6.jpg" onclick='layoutChoice(6)' style="cursor:pointer;" class="layout6">
	</div><br><br>
	<div class="layoutedit1" align="center" style="border: 5px double #ccc; ">
		레이아웃 설정
		<table width="50%" height="100%" align="center">
			<tr>
				<td align="left" rowspan="2" valign="top">
					<div class="aside" height="100%" align="right">
						<img src="resources/images/layout/sidebar.jpg">
					</div>
				</td>
				<td>
					<div class="title" width="100%">
						<img src="resources/images/layout/title.jpg">
					</div>
				</td>
				<td align="right" rowspan="2" valign="top">
					<div class="aside2" height="100%" align="left">
						<img src="resources/images/layout/empty.jpg">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>
						<img src="resources/images/layout/main.jpg">
					</div>
				</td>
			</tr>
		</table>
			</div>
			<div class="layoutedit2" align="center" style="border: 5px double #ccc;display:none; ">
				레이아웃 설정
		<table width="50%" height="100%" align="center">
			<tr>
				<td align="right" rowspan="2" valign="top">
					<img src="resources/images/layout/empty.jpg">
				</td>
				<td>
					<div class="title" width="100%">
						<img src="resources/images/layout/title.jpg">
					</div>
				</td>
				<td align="right" rowspan="2" valign="top">
					<div class="aside2" height="100%" align="left">
						<img src="resources/images/layout/sidebar2.jpg">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>
						<img src="resources/images/layout/main.jpg">
					</div>
				</td>
			</tr>
		</table>
			</div>
			<div class="layoutedit3" align="center" style="border: 5px double #ccc;display:none; ">
				레이아웃 설정
				<table width="50%" height="100%" align="center">
					<tr>
						<td align="left" rowspan="2" valign="top">
							<div class="aside" height="100%" align="right">
								<img src="resources/images/layout/sidebar.jpg">
							</div>
						</td>
						<td>
							<div class="title" width="100%">
								<img src="resources/images/layout/main.jpg">
							</div>
						</td>
						<td align="right" rowspan="2" valign="top">
							<div class="aside2" height="100%" align="left">
								<img src="resources/images/layout/empty.jpg">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<img src="resources/images/layout/title.jpg">
							</div>
						</td>
					</tr>
				</table>
					</div>
					<div class="layoutedit4" align="center" style="border: 5px double #ccc;display:none; ">
						레이아웃 설정
						<table width="50%" height="100%" align="center">
							<tr>
								<td align="left" rowspan="2" valign="top">
								<img src="resources/images/layout/empty.jpg">
								</td>
								<td>
									<div class="title" width="100%">
									<img src="resources/images/layout/main.jpg">
									</div>
								</td>
								<td align="right" rowspan="2" valign="top">
									<div class="aside2" height="100%" align="left">
									<img src="resources/images/layout/sidebar2.jpg">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div>
									<img src="resources/images/layout/title.jpg">
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="layoutedit5" align="center" style="border: 5px double #ccc;display:none; ">
						레이아웃 설정
						<table width="50%" height="100%" align="center">
							<tr>
								<td align="left" rowspan="2" valign="top">
									<div class="aside" height="100%" align="right">
									<img src="resources/images/layout/sidebar.jpg">
									</div>
								</td>
								<td>
									<div class="title" width="100%">
									<img src="resources/images/layout/title.jpg">
									</div>
								</td>
								<td align="right" rowspan="2" valign="top">
									<div class="aside2" height="100%" align="left">
									<img src="resources/images/layout/sidebar2.jpg">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div>
									<img src="resources/images/layout/main.jpg">
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="layoutedit6" align="center" style="border: 5px double #ccc;display:none; ">
						레이아웃 설정
						<table width="50%" height="100%" align="center">
							<tr>
								<td align="left" rowspan="2" valign="top">
								<img src="resources/images/layout/sidebar.jpg">
								</td>
								<td>
									<div class="title" width="100%">
									<img src="resources/images/layout/main.jpg">
									</div>
								</td>
								<td align="right" rowspan="2" valign="top">
									<div class="aside2" height="100%" align="left">
									<img src="resources/images/layout/sidebar2.jpg">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div>
									<img src="resources/images/layout/title.jpg">
									</div>
								</td>
							</tr>
						</table>
					</div>
</c:if>

<c:if test="${mode=='skin'}">
					<div align="center">
					<h1>스킨 변경</h1><input type="button" value="미리보기"><br>
					<input type="hidden" name="id" value="${optionDTO.id}">
					<input type="hidden" name="mode" value="${mode}">
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
					</table>
					</div>
</c:if>

<c:if test="${mode=='neighbor'}">
<div align="center">
<h1>이웃 관리</h1><br>
<input type="hidden" name="mode" value="${mode}">
</div>
</c:if>

<c:if test="${mode=='blog'}">
<div align="center">
<h1>블로그 타이틀 변경</h1><br>
<input type="hidden" name="id" value="${optionDTO.id}">
<textarea rows="3" cols="20" maxlength="30" name="headerword">${optionDTO.headerword}</textarea><br><br><br><br>
<input type="hidden" name="mode" value="${mode}">
<h1>블로그 탈퇴</h1><br>
<input type="button" value="탈퇴하기" onclick="javascript:checkDel('${optionDTO.id}');">
</div>
</c:if>

<c:if test="${mode=='board'}">
<div align="center">
<h1>게시판 관리</h1><br>
게시판은 각 사이드바에 속하며 사이드바가 없는 레이아웃을 선택시, 게시판이 보이지 않을 수 있습니다.
<div align="right">
<a href="makeBoardTitle?id=${optionDTO.id}">게시판 추가</a>
</div>
<div>
<table border="1" width="500px" >
	<tr align="center">
		<td width="250px">사이드바1</td>
		<td width="250px">사이드바2</td>
	</tr>
	<tr align="center">
		<c:choose>
		<c:when test="${list.size()==0}">
		<td colspan="2" align="center">
			게시판이 없습니다
		</td>
		</c:when>
		<c:otherwise>
		<td>
		<c:forEach var="dto" items="${list}">
		<c:if test="${dto.sideno % 2 == 1}">
		${dto.title}&nbsp;&nbsp;&nbsp;<a href="editBoardTitle?id=${dto.id}">수정</a>&nbsp;|&nbsp;<a href="">삭제</a><br>
		</c:if>
		</c:forEach>
		</td>
		<td>
		<c:forEach var="dto" items="${list}">
		<c:if test="${dto.sideno % 2 == 0}">
		${dto.title}&nbsp;&nbsp;&nbsp;<a href="editBoardTitle?id=${dto.id}">수정</a>&nbsp;|&nbsp;<a href="editBoardTitle?id=${optionDTO.id}">삭제</a><br>
		</c:if>
		</c:forEach>
		</td> 
		</c:otherwise>
		</c:choose>
	</tr>	
</table>
</div>
</div>
</c:if>
</form>
		</td>
	</tr>
</table>
</body>
</html>