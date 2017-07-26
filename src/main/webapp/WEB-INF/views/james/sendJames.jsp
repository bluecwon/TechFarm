<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>
	<div class="left">
		<div class="left_content1">
			<div align="center">
			
			
		<h1 align="center" style="color:#ff8080;">메일 보내기</h1>

		<form action="sendJames" method="post" enctype="multipart/form-data">
		<table class="jjm494">
			<tr>
				<td><input type="email" name="to" value="${to }" placeholder="상대의 이메일" ></td>
			</tr>
			<tr>
				<td><input type="text" name="subject" placeholder="제목을 입력해주세요" ></td>
			</tr>
			<tr>
				<td>
					<textarea name="text" cols="100" rows="12" placeholder="내용을 입력해주세요" ></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="file" name="sendFile" multiple></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="메일 보내기" >
      				<input type="reset" value="취소">
				</td>
			</tr>
      	</table>
  		</form>


			</div>
		</div>
	</div>
	 
<%@ include file="footer.jsp" %>