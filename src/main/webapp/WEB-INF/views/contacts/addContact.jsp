<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>
<body>
	<div align="center">
		<h2>Create Contact</h2>
		<form method="post" action="addContact">
		<table>
			<tr>
				<td>photo</td>
				<td>Name : <input type="text" name = "name"></td>
				<td></td>
			</tr>
			<tr>
				<td>icon</td>
				<td>Compnay : <input type="text" name="company"></td>
				<td>Jobtitle : <input type="text" name="jobtitle"></td>
			</tr>
			<tr>
				<td>icon</td>
				<td>Email : <input type="text" name="email"></td>
				<td></td>
			</tr>
			<tr>
				<td>icon</td>
				<td>Phone :  <input type="text" name="phone"></td>
				<td></td>
			</tr>
			<tr>
				<td>icon</td>
				<td>Notes : <input type="text" name="notes"></td>
				<td></td>
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
</body>
</html>