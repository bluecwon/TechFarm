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
			<div align="right">	
				<img src="resources/images/write.jpg" onclick="location.href='insertBoard?boardno=${boardno}&id=${optionDTO.id}&title=${title}'" style="cursor:pointer;">&nbsp;&nbsp;<br>
			</div><br>
				<div>
					<table>
						<c:choose>
						<c:when test="${listBoard.size()==0}">
						<tr>
						<td>
						게시글이 없습니다. 지금 작성 해보세요.
						</td>
						</tr>
						</c:when>
						<c:otherwise>
						<c:forEach var="listBoard" items="${listBoard}">
						<tr>
						<td width="50%" id="boardlist">${listBoard.subject}</td>
						<td width="15%" id="boardlist">${optionDTO.nickname}(${listBoard.id})</td>		
						<td width="10%" id="boardlist"><img src="resources/images/reply.jpg">&nbsp;${listBoard.reply} &nbsp;&nbsp;&nbsp;  <img src="resources/images/view.jpg">&nbsp;${listBoard.readcount}  </td>
						<td width="15%" id="boardlist">${listBoard.reg_date}</td>
						</tr><tr><td colspan="4"></td></tr>
						
						</c:forEach>
						</c:otherwise>
						</c:choose>	
					</table>			
				</div>
			</div>
</td>		