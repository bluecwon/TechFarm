<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="main_top.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function goReply(){
	document.f.action="otube_reply_insert";
	document.f.submit();	
}
</script>
<title>Insert title here</title>
</head>
<body>
<%-- <%
String filename=(String)session.getAttribute("filename");
/* String image=request.getParameter("image");
String upPath_img=request.getParameter("upPath_img");

System.out.println(image); */
System.out.println(filename);
%> --%>
<%-- <%
String file[]=new String[];
for(int i=0;;i++){
file[i]=(String)session.getAttribute(filename[i]);
}		
%> --%>

<video src="/resources/folername/filename/${vdto.filename}" autoplay  
poster="${upPath_img}/${vdto.image}" controls="controls" width="600" height="450">
 브라우저 지원안함</video>  
 
 <p>
 <font size="18">${vdto.title}</font><br>
 <c:choose>
 <c:when test="${vdto.uploaddate.length()>=10}">
 
 게시일:${vdto.uploaddate.substring(0,10)}<!-- 게시일 --><br>
 </c:when>
 <c:otherwise>
 게시일:${vdto.uploaddate}<br>
 </c:otherwise>
 </c:choose>
 ${vdto.description}<!-- 간략히 버튼 추가 --><br> 
 
댓글 <!-- 댓글갯수 --><br>
<form name="f">
<textArea name="content">

</textArea><!--클릭시 로그인창 열리는 방법찾기 -->
<c:if test="${tube_id!=null}">
<input type="button" value="입력" onClick="javascript:goReply()">
</c:if>
</form>

<table>
<c:forEach var="rdto" items="${r_list}">

<tr>
<td>
<%-- ${rdto.nickname}<!-- 3일전 --><br>--%><!-- id sysdate-reg_date 아니면 java에서 변환 -->
${rdto.content}<br> 
<!--답글이 존재한다면 답글:답글갯수 -->
</tr>

</c:forEach>

</table>



	<%-- <a href="board_insert.do">글쓰기</a>
	<table border="1">	
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록자</th>
			<th>등록일</th>	
			<th>조회</th>
			<th>IP</th>
			<th>파일</th>		
		</tr>
		
		<c:forEach var="dto" items="${boardList}">
		<tr>
			<td>${number=number-1}</td>
			<td><a href="board_content.do?num=${dto.num}&mode=content">${dto.subject}</a></td>
			<td>${dto.writer}</td>
			<td>${dto.reg_date}</td>
			<td>${dto.readcount}</td>
			<td>${dto.ip}</td>
			<td>${dto.filename}</td>			
		</tr>		
		</c:forEach>	
		
		<tr>
		<c:if test="${startPage>pageBlock}">
				[<a href="board_list.do?pageNum=${startPage-pageBlock}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">		
				[<a href="board_list.do?pageNum=${i}">${i}</a>] 
		</c:forEach>
		<c:if test="${endPage < pageCount}">
				[<a href="board_list.do?pageNum=${startPage+pageBlock}">다음</a>]
		</c:if>
		</tr>
		</table> --%>
 
</body>
<%@ include file="main_bottom.jsp"%> 
</html>