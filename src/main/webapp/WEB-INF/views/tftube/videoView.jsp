<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="main_top.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
function goReply(){
	document.f1.action="tftube_reply_insert";
	document.f1.submit();	
}

$(function(){
	$(".reply_area").hide();	
	$(".reply").click(function(){
	$(".reply_area").show("fast");	
	});	
	
	$("#cancel").click(function(){
		$(".reply_area").hide();	
		});		
});

</script>
<title>Insert title here</title>
</head>
<body>
<!-- /resources/tftube -->
<video src="resources/tftube/uploadVideo/${vdto.video_name}" autoplay  
poster="resources/tftube/uploadImage/${vdto.image}" controls="controls" width="600" height="450"></video>
<br>
<table>
<tr><td>
<c:if test="${vdto.member_no eq memberDTO.no}">
<a href="tftube_video_edit">정보수정</a>								<a href="tftube_video_delete?no=${vdto.no}">삭제</a>
</c:if>
</td></tr>
 <tr><td> 
 <font size="18">${vdto.title}</font><br>
  게시일:${vdto.uploaddate.substring(0,10)}<!-- 게시일 -->				조회수 ${readcount}회 <br>	
 ${vdto.description}<!-- 간략히 버튼 추가 --><p> 
 </td></tr>
 </table>
댓글 <!-- 댓글갯수 --><br>
<c:choose>
<c:when test="${memberDTO==null}">
로그인이 필요한 서비스 입니다. <a href="login">로그인</a>을 해주세요.
</c:when>
<c:otherwise>
<%
		int num = 0, re_step = 0, re_level = 0;
		String snum = request.getParameter("num");//답글쓰기일경우
		if (snum != null){
			num = Integer.parseInt(snum);
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
%>
<form name="f1">
<textArea name="content"></textArea><!--클릭시 로그인창 열리는 방법찾기 -->
<input type="hidden" name="video_name" value="${vdto.video_name}">
<input type="hidden" name="no" value="${no}">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="re_step" value="<%=re_step%>">
<input type="hidden" name="re_level" value="<%=re_level%>">
<c:if test="${memberDTO!=null}">
<input type="button" value="입력" onClick="javascript:goReply()">
</c:if>
</form>
</c:otherwise></c:choose>



<table>
 <c:forEach var="rdto" items="${r_list}">
<tr>
<td>
<a href="tftube_mychannel?name=${r_name}">${r_name}</a>   ${rdto.reg_date}<br><!-- id sysdate-reg_date 아니면 java에서 변환 -->
<<<<<<< HEAD
${rdto.content}<br> 
=======
${rdto.content}<br>
<a class="reply" onmouseover="" style="cursor: pointer;">답글</a>					<a href="tftube_reply_delete">삭제</a>
<a class="reply_area">
<form name="f2">
<textArea></textArea>
<input type="button" value="입력" onClick="javascript:goReply()">
<input id="cancel" type="button" value="취소">
<br>
</form>
</a>

>>>>>>> 5586c0deef6c82b7607bff1c7a16006fe1eeeb45
<!--답글이 존재한다면 답글:답글갯수 -->
</tr>
</c:forEach>
</table>
	
		<%--
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