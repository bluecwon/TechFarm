<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function addtionalSearch(pnum){
		document.s.action="search.naver?pagenum="+pnum;
		document.s.submit();
	}
</script>
<html5>
<body>
<b>검색결과 : ${total} <br>
	검색시간 : ${time}</b>
	<form name="s" method="post">
		<input type="hidden" name="search" value="${search}">
	</form>
<c:forEach var="dto" items="${result}">
 <a href="${dto.link}">${dto.title}</a><br>
 ${dto.description}<br>
 <br>
</c:forEach>
<div align="center">
 <a href="javascript:addtionalSearch(0);">
 1
 </a>
 <a href="javascript:addtionalSearch(1);">
 2
 </a>
 <a href="javascript:addtionalSearch(2);">
 3
 </a>
 <a href="javascript:addtionalSearch(3);">
 4
 </a>
 <a href="javascript:addtionalSearch(4);">
 5
 </a>
 </div>
</body>
</html5>