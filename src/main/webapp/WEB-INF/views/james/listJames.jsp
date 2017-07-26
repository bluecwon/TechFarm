<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function confirmDel(num){
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href="deleteJames?num="+num;
			}
		}
	</script>
</head>
<body>
	<header>
		<h1 align="center">메일함</h1>
	</header>
	<nav>
		<div align="left">
			<a href="sendJames">메일 쓰기</a>
		</div>
		<br>
		<a href="listJames?folder=INBOX">받은편지함</a><br>
		<a href="listJames?folder=Sent">보낸편지함</a><br>
		<a href="listJames?folder=Trash">휴지통</a><br>
	</nav>
	<section>
		<article>
			<table>
		<tr>
		<td>
			<div align="center">
				<table>
					<c:choose>
						<c:when test="${listJames.size()==0 }">
							<b>받은 메일이 없습니다.</b>
						</c:when>
						<c:otherwise>
							<c:forEach var = "dto" items="${listJames }">
								<tr>
									<td><input type="checkbox" name="chk_mail" value="${dto.num	}"></td>
									<td><a href="sendJames?to=${dto.from}">${dto.from }</a></td>
									<td><a href="getJames?num=${dto.num }">${dto.subject }</a></td>
									<td>${dto.sentDate }</td>
									<td><a href="javascript:onClick=confirmDel('${dto.num }')">삭제</a></td>			
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</td>
		</tr>
	</table>
		<ul class="pageUL"> 
			<c:if test="${pageMaker.prev}"> 
				<li><a href='listJames?page=${pageMaker.start -1}'>이전</a></li> 
			</c:if> 
			<c:forEach begin="${pageMaker.start }" end="${pageMaker.end}" var="idx"> 
				<li class='<c:out value="${idx == pageMaker.page?'current':''}"/>'> 
					<a href='listJames?page=${idx}'>${idx}</a> 
				</li> 
			</c:forEach> 
			<c:if test="${pageMaker.next }"> 
				<li><a href='listJames?page=${pageMaker.end +1}'>다음</a></li> 
			</c:if> 
		</ul>
		</article>
	</section>
	<footer></footer>
</body>
</html>