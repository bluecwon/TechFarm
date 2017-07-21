<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		[data-tooltip-text]:hover {
			position: relative;
		}
		
		[data-tooltip-text]:after {
			-webkit-transition: bottom .3s ease-in-out, opacity .3s ease-in-out;
			-moz-transition: bottom .3s ease-in-out, opacity .3s ease-in-out;
			transition: bottom .3s ease-in-out, opacity .3s ease-in-out;
		
			background-color: rgba(0, 0, 0, 0.8);
		
			-webkit-box-shadow: 0px 0px 3px 1px rgba(50, 50, 50, 0.4);
			-moz-box-shadow: 0px 0px 3px 1px rgba(50, 50, 50, 0.4);
			box-shadow: 0px 0px 3px 1px rgba(50, 50, 50, 0.4);
			
			-webkit-border-radius: 5px;
			-moz-border-radius: 5px;
			border-radius: 5px;
			
		    color: #FFFFFF;
			font-size: 12px;
			margin-bottom: 10px;
			padding: 7px 12px;
			position: absolute;
			width: auto;
			min-width: 50px;
			max-width: 300px;
			word-wrap: break-word;
		
			z-index: 9999;
		
			opacity: 0;
			left: -9999px;
		  top: 90%;
			
			content: attr(data-tooltip-text);
		}
		
		[data-tooltip-text]:hover:after {
			top: 130%;
			left: 0;
			opacity: 1;
		}
	</style>
</head>
<body>
	<header>
		<h1>연락처 가져오기</h1>
	</header>
	<nav>
			<span data-tooltip-text="연락처 수정"><a href="editContact?no=${dto.no }"><img src="resources/contacts/images/edit.png" style="max-width: 30px; height: auto;"></a></span>&nbsp
			<span data-tooltip-text="연락처 삭제"><a href="deleteContact?no=${dto.no }"><img src="resources/contacts/images/delete.png" style="max-width: 30px; height: auto;"></a></span>
			
			
	</nav>
	<section>
		<table>
				<tr>
					<td>${dto.photo }<img src="resources/home/imgs/account.png" style="max-width: 60px; height: auto;"></td>
					<td><h2>${dto.name }</h2>
				</tr>
				<tr>
					<td><h3>Contact details</h3></td>
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
	</section>
	<footer></footer>
	
	
	
</body>
</html>