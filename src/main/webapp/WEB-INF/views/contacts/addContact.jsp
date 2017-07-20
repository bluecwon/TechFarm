<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>
<body>
	<header>
		<h1>연락처 입력</h1>
	</header>
	<nav></nav>
	<section>
		<form method="post" action="addContact" enctype="multipart/form-data">
		<table>
			<tr>
				<td><img src="resources/home/imgs/account.png" style="max-width: 60px; height: auto;"></td>
				<td>Name : <input type="text" name = "name"></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/company.png" style="max-width: 30px; height: auto;"></td>
				<td>Company : <input type="text" name="company"></td>
				<td>Jobtitle : <input type="text" name="jobtitle"></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/email.png" style="max-width: 30px; height: auto;"></td>
				<td>Email : <input type="text" name="email"></td>
				<td></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/phone.png" style="max-width: 30px; height: auto;"></td>
				<td>Phone :  <input type="text" name="phone"></td>
				<td></td>
			</tr>
			<tr>
				<td><img src="resources/contacts/images/notes.png" style="max-width: 30px; height: auto;"></td>
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
	</section>
	<footer></footer>
</body>
</html>