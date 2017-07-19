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
							<td width="100%" colspan="3" align="center"><a href="${upPath}/${boardDTO.file1}">${boardDTO.file1}</a>
						</tr>
						</c:if>
						<tr>
							<td width="100%" height="500" colspan="3" valign="top" id="view">${boardDTO.content}</td>
						</tr>
						<tr>
							<td colspan="3" align="right" id="view"> 목록&nbsp;&nbsp;수정</td>
						</tr>
						<tr>
							<td width="10%" align="center">댓글</td> 
							<c:choose>
							<c:when test="${membermode=='guest'}">
							<td width="70%"><input type="text" name="replycontent" disabled></td>
							</c:when>
							<c:otherwise>
							<td width="70%"><input type="text" name="replycontent" ></td>
							</c:otherwise>
							</c:choose>
							<td width="20%" align="center">등록</td>
						</tr>
						<tr>
							<td colspan="3">댓글목록록록</td>
						</tr>
					</table>			
			</div>
</td>	