<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<td height="700px" width="60%" valign="top" align="center">
			<hr width="95%">
			<div id="boardList">
			<div align="left">
				<h2>${title}</h2><br>
			</div>
					<table class="viewBoard"  width="100%">
						<tr>
							<td width="10%" align="center" id="view">제목</td>
							<td width="70%" class="view" id="view">${boardDTO.subject}</td>
							<td width="20%" class="view" align="center" id="view">${optionDTO.nickname}(${optionDTO.id})</td>
						</tr>
						<c:if test="${boardDTO.file1 != ''}">
						<tr>	
							<td width="100%" colspan="3" align="right">
							<form action="fileDownload">
							<input type="hidden" name="upPath" value="${upPath}">
							<input type="hidden" name="file1" value="${boardDTO.file1}">
							첨부파일 : ${boardDTO.file1} &nbsp;&nbsp; <input type="submit" value="다운로드">
							</form>
							</td>
						</tr>
						</c:if>
						<tr>
							<td width="100%" height="500" colspan="3" valign="top" id="view">${boardDTO.content}</td>
						</tr>
						<tr>
							<td colspan="3" align="right" id="view"> 
							<a href="listBoard?title=${title}&boardno=${boardDTO.boardno}">목록</a>&nbsp;&nbsp;
							<a href="updateBoard?title=${title}&no=${boardDTO.no}">수정</a>&nbsp;&nbsp;
							<c:if test="${boardDTO.id==sessionScope.memberDTO.id }">
							<a href="javascript:checkDelBoard('${boardDTO.no}');">삭제</a>&nbsp;&nbsp;
							</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="3">
							<form action="insertReply">
							<input type="hidden" name="no" value="${boardDTO.no}">
							<input type="hidden" name="id" value="${sessionScope.memberDTO.id}">
							<input type="hidden" name="mode" value="reply">
								<table>
									<tr>
										<th width="10%">댓글</th>
										<c:choose>
										<c:when test="${membermode=='guest'}">
										<td align="center" width="70%">
										<textarea name="repcontent" rows="3" cols="100" maxlength="100" placeholder="로그인 후 댓글이용이 가능합니다." disabled></textarea>
										</td>
										<td width="20%"><input type="button" value="등록" onclick="javascript:login();"></td>
										</c:when>
										<c:otherwise>
										<td align="center" width="70%">
										<textarea name="repcontent" rows="3" cols="100" maxlength="100"></textarea>
										<td width="20%"><input type="submit" value="등록"></td>
										</td>
										</c:otherwise>
										</c:choose>
									</tr>
								</table>
							</form>	
							</td>
						</tr>
						<tr>
							<td colspan="3">
							<div align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;댓글보기(댓글수)
							</div>
							<table id="listReply">
							<c:choose>
							<c:when test="${listReply.size()==0}">
								<tr>
									<th>등록된 댓글이 없습니다.</th>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="listReply" items="${listReply}">
								<tr>
									<td>
									<c:if test="${listReply.re_level==1}">
									<img src="" width="100" height="80" align="left">
									</c:if>
									<c:choose>
									<c:when test="${listReply.profile==null}">
									<img src="resources/images/guest.png" width="50" height="40">
									</c:when>
									<c:otherwise>
									<img src="resources/upload/${sessionScope.memberDTO.id}/${listReply.profile}" width="50" height="50" align="left">
									</c:otherwise>
									</c:choose>
									${listReply.id}  <span id="regdate">${listReply.reg_date}</span>
									<br>
									${listReply.repcontent}<br>
									<c:choose>
									<c:when test="${listReply.id==sessionScope.memberDTO.id}">
									댓글 &nbsp;<a href="javascript:checkDelReply('${listReply.replyno}','${listReply.no}');">삭제</a>
									</c:when>
									<c:otherwise>
									댓글
									</c:otherwise>
									</c:choose>
									<br>
									<form action="insertReply">
									<input type="hidden" name="re_step" value="${listReply.re_step}">
									<input type="hidden" name="no" value="${listReply.no}">
									<input type="hidden" name="id" value="${sessionScope.memberDTO.id}">
									<input type="hidden" name="mode" value="rereply">
									<input type="text" name="repcontent" maxlength="100">
									<input type="submit" value="등록">
									</form>	
								</tr>
								</c:forEach>
							</c:otherwise>
							</c:choose>
							</table>
							</td>
						</tr>
					</table>			
			</div>
</td>	