<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>
	<div class="left">
		<div class="left_content1">
			<div align="center">
			<span data-tooltip-text="연락처 수정"><a href="editContact?no=${dto.no }"><img src="resources/contacts/images/edit.png" style="max-width: 30px; height: auto;"></a></span>&nbsp
			<span data-tooltip-text="연락처 삭제"><a href="deleteContact?no=${dto.no }"><img src="resources/contacts/images/delete.png" style="max-width: 30px; height: auto;"></a></span>
		<table class="jjm494">
				<tr>
					<td>
						<c:if test="${!empty dto.photo }">
							<img src="resources/contacts/upload/${dto.photo }" style="max-width: 60px; height: auto;">
						</c:if>
						<c:if test="${empty dto.photo }" >
							<img src="resources/contacts/images/account.png" style="max-width: 60px; height: auto;">
						</c:if>	
					</td>
					<td><h2>${dto.name }</h2>
				</tr>
				<tr>
					<td colspan="2" align="center"><h3>Contact details</h3></td>
				</tr>
				<tr>
					<td><img src="resources/contacts/images/email.png" style="max-width: 30px; height: auto;"></td>
					<td><a href="sendJames?to=${dto.email }">${dto.email }</a></td>
				</tr>
				<tr>
					<td><img src="resources/contacts/images/phone.png" style="max-width: 30px; height: auto;"></td>
					<td>${dto.phone }</td>
				</tr>
				<tr>
					<td><img src="resources/contacts/images/notes.png" style="max-width: 30px; height: auto;"></td>
					<td>${dto.notes }</td>
				</tr>
		</table>
	
	
	
			</div>
		</div>
	</div>
	 
<%@ include file="footer.jsp" %>