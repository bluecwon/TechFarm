<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="main_top.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<img src="" style="position: relative;"><span style="position: absolute; top: 5px; right: 5px;">My profile</span></img>
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

function GReply(){
	document.f.action="tftube_reply_insert?mode=general";
	document.f.submit();	
}

function DReply(){
	document.f.action="tftube_reply_insert?mode=deep";
	document.f.submit();	
}

//태그를 안붙여주면 잘 못찾는 것 같다.
//하나씩만 열리도록 설정
$(document).ready(function(){
	$(".reply_area").hide();	
	
	$("a.reply_button").click(function(){
	$(this).siblings().show('fast'); 
	});
	
	$("a.not_login").click(function(){
	alert("로그인이 필요한 서비스 입니다. 로그인 페이지로 이동합니다.");
	})
	
	$(".cancel").click(function(){ 		
		$("a#reply").hide();
		
	});		
});
</script>
<title>Insert title here</title>
</head>
<body>

<!-- Video -->
<table>
<tr><td><video src="resources/tftube/uploadVideo/${vdto.video_name}" autoplay  
poster="resources/tftube/uploadImage/${vdto.image}" controls="controls" width="600" height="450"></video>
</td></tr>
<tr><td align="right">	조회수 ${readcount}회 <br></td></tr>
<tr><td align="right"> <button id="button" onclick="like ()">like</button> </td></tr>
<br>
</table>

<!-- Video Edit and Delete -->
<table>
<tr><td>
<c:if test="${vdto.member_no eq memberDTO.no}">
<a href="tftube_video_edit">정보수정</a>								<a href="tftube_video_delete?no=${vdto.no}">삭제</a>
</c:if>
</td></tr>
<!-- information -->
 <tr><td> 
 <font size="18">${vdto.title}</font><br>
  게시일:${vdto.uploaddate.substring(0,10)}<br>			
	
 ${vdto.description}<!-- 간략히 버튼 추가 --><p> 
 </td></tr>
 </table>
 
 
<!-- Reply -->
<table>
<tr><td>댓글 ${r_size}개</td></tr>
<c:choose>
<c:when test="${memberDTO==null}">
<tr><td>로그인이 필요한 서비스 입니다. <a href="login">로그인</a>을 해주세요.</td></tr>
</c:when>
<c:otherwise>
<tr><td>
<form name="f" method="post" action="tftube_reply_insert">
<textArea name="content"></textArea><!--클릭시 로그인창 열리는 방법찾기 -->
<input type="hidden" name="video_name" value="${vdto.video_name}">
<input type="hidden" name="no" value="${vdto.no}">
<c:if test="${memberDTO!=null}">
<input type="button" value="입력" onClick="javascript:GReply()">
</c:if>
</td></tr>
</c:otherwise></c:choose>

</table>


<c:set var="i" value="0"/>

<table>

<!-- Reply list -->

<c:forEach var="rdto" items="${r_list}">
<tr>

<!-- empty space in front of reply_reply -->

<c:choose>
<c:when test="${rdto.re_level==1}">

<!-- <img src="" style="position: relative;"><span style="position: absolute; top: 5px; right: 5px;">My profile</span></img> -->


<!-- <img src="resources/tftube/imgs/vaccum.JPG" height="80" width="80"> -->


</c:when><c:otherwise></c:otherwise>
</c:choose>
<td>
<img src="" width="100" height="80"></img> 
<img src="" style="position: relative; top:8px" height="80">
<a href="tftube_mychannel?name=${r_name}">${r_name}</a>   ${rdto.reg_date}<br />
<!-- id sysdate-reg_date 아니면 java에서 변환 -->
${rdto.content}
<input type="hidden" name="re_step" value="${rdto.re_step}"/>
<c:choose>
<c:when test="${memberDTO==null}">
<a href="login" class="not_login">답글</a></img>
</c:when>
<c:otherwise>
<a class="reply_button" onmouseover="" style="cursor: pointer;">답글</a>
					<a href="tftube_reply_delete?r_no=${rdto.no}&no=${vdto.no}">삭제</a>
<a id="reply" class="reply_area">
<textArea name="content_reply"></textArea>
<input type="button" value="입력" onClick="javascript:DReply()">
<input class="cancel" type="button" value="취소">
<br>
</a>

</form>
</c:otherwise>
</c:choose>
<!--답글이 존재한다면 답글:답글갯수 -->
</tr>
</c:forEach>
<!-- end of Reply List -->
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