<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>
	<div class="left">
		<div class="left_content1">
			<div align="center">
	
		<h1>연락처 수정</h1>
		<form method="post" action="editContact" enctype="multipart/form-data">
		<input type="hidden" id="no" name="no" value="${dto.no }">
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
				<td colspan="2">Name : <input type="text" name = "name" value="${dto.name }" class="jjm494_input"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/company.png" style="max-width: 30px; height: auto;"></td>
				<td>Compnay : <input type="text" name="company" value="${dto.company }" class="jjm494_input"></td>
				<td>Jobtitle : <input type="text" name="jobtitle" value="${dto.jobtitle }" class="jjm494_input"></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/email.png" style="max-width: 30px; height: auto;"></td>
				<td colspan="2">Email : <input type="email" name="email" value="${dto.email }" class="jjm494_input"></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/phone.png" style="max-width: 30px; height: auto;"></td>
				<td colspan="2">Phone :  <input type="text" name="phone" value="${dto.phone }" class="jjm494_input"></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/notes.png" style="max-width: 30px; height: auto;"></td>
				<td colspan="2">Notes : <input type="text" name="notes" value="${dto.notes }" class="jjm494_input"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="확인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
		</form>
	
	
			</div>
		</div>
	</div>
	 
<%@ include file="footer.jsp" %>