<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="main_top.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#button {
   background-color: #4CAF50;
   border: none;
   color: white;
   padding: 15px 32px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   font-size: 16px;
   margin: 4px 2px;
   cursor: pointer;
}
</style>
<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
var likes =0; 
function like() {
 //THIS FUNCTION WILL WORK WHEN THE USER CLICKS THE BUTTON
 document.getEelementById ("show").innerHTML=likes; //WILL DISPLAY THE NUMBER OF LIKES!
 likes=likes+1;
}

function goReply(){
	document.f.action="tftube_reply_insert";
	document.f.submit();	
}

$(document).ready(function(){
	$(".reply_area").hide();	
	
	$("a.reply_button").click(function(){
	$(this).siblings().show('fast'); 
	});
	
	$("a.not_login").click(function(){
	alert("로그인이 필요한 서비스 입니다. 로그인 페이지로 이동합니다.");
	})
	
	$(".cancel").click(function(){ 
		$(this).hide();	
	});		
});
</script>
<title>Insert title here</title>
</head>
<body>

<!-- Video -->
<video src="resources/tftube/uploadVideo/${vdto.video_name}" autoplay  
poster="resources/tftube/uploadImage/${vdto.image}" controls="controls" width="600" height="450"></video>
<br>

<!-- Edit and Dselete -->
<table>
<tr><td>
<c:if test="${vdto.member_no eq memberDTO.no}">
<a href="tftube_video_edit">정보수정</a>								<a href="tftube_video_delete?no=${vdto.no}">삭제</a>
</c:if>
</td></tr>
<!-- information -->
 <tr><td> 
 <font size="18">${vdto.title}</font><br>
  게시일:${vdto.uploaddate.substring(0,10)}<!-- 게시일 -->				조회수 ${readcount}회 <br>
  

<button id="button" onclick="like ()">like</button> <p>	
 ${vdto.description}<!-- 간략히 버튼 추가 --><p> 
 </td></tr>
 </table>
 
 
<!-- Reply -->

댓글 ${r_size}개<br>
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
<form name="f">
<textArea name="content"></textArea><!--클릭시 로그인창 열리는 방법찾기 -->
<input type="hidden" name="video_name" value="${vdto.video_name}">
<input type="hidden" name="no" value="${no}">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="re_step" value="<%=re_step%>">
<input type="hidden" name="re_level" value="<%=re_level%>">
<c:if test="${memberDTO!=null}">
<input type="button" value="입력" onClick="javascript:goReply()">
</c:if>

</c:otherwise></c:choose>


<c:set var="i" value="0"/>
<table>
<c:forEach var="rdto" items="${r_list}">
<tr>
<td>
<a href="tftube_mychannel?name=${r_name}">${r_name}</a>   ${rdto.reg_date}<br><!-- id sysdate-reg_date 아니면 java에서 변환 -->
${rdto.content}<br>
<c:choose>
<c:when test="${memberDTO==null}">

<a href="login" class="not_login">답글</a>
</c:when>
<c:otherwise>
<div id="reply"> 

<a class="reply_button" onmouseover="" style="cursor: pointer;">답글</a>
					<a href="tftube_reply_delete">삭제</a>
<a class="reply_area">
<textArea></textArea>
<input type="button" value="입력" onClick="javascript:goReply()">
<input class="cancel" type="button" value="취소">
<br>
</a>
</div>
</form>
</c:otherwise>
</c:choose>
<%-- <c:set var="i" value="${i=i+1}"/> --%>
<!--답글이 존재한다면 답글:답글갯수 -->
</tr>
</c:forEach>
</table>
<!-- end of Reply -->
	
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