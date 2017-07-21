<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
	<script type="text/javascript">
		function confirmDel(no){
			if(confirm("이 연락처를 삭제하시겠습니까?")){
				location.href="deleteContact?no="+no;
			}
		}
	</script>
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
		<h1 align="center">연락처 목록</h1>
	</header>
	<nav>
		<span data-tooltip-text="연락처 등록"><a href="addContact"><img src="resources/contacts/images/add.png" style="max-width: 50px; height: auto;"></a></span>
	</nav>
	<section>
		<table>
			<c:choose>
				<c:when test="${listContacts.size()==0 }">
					<b>등록된 연락처가 없습니다.</b>
				</c:when>
				<c:otherwise>
					<c:forEach var = "dto" items="${listContacts }">
						<tr>
							<td><input type="checkbox" name="chk_contact" value="${dto.no }"></td>
							<td><a href="getContact?no=${dto.no }"><img src="resources/contacts/upload/${dto.photo }" style="max-width: 30px; height: auto;"></a></td>
							<td><a href="getContact?no=${dto.no }">${dto.name }</a></td>
							<td><a href="sendJames?to=${dto.email }">${dto.email }</a></td>
							<td>${dto.phone }</td>
							<td><span data-tooltip-text="연락처 수정"><a href="editContact?no=${dto.no }"><img src="resources/contacts/images/edit.png" style="max-width: 20px; height: auto;"></a></span></td>
							<td><span data-tooltip-text="연락처 삭제"><a href="javascript:onClick=confirmDel('${dto.no }')"><img src="resources/contacts/images/delete.png" style="max-width: 20px; height: auto;"></a></span></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</section>
	<footer></footer>
		
	
	
</body>
</html>