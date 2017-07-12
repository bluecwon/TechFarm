<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="main_top.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<img src="" style="position: relative;"><span style="position: absolute; top: 5px; right: 5px;">My profile</span></img>
<head>
<meta charset="UTF-8">
<c:set var="like" value="0"/>
<c:set var="unlike" value="0"/>
<style>
#like_disabled,#unlike_disabled{
   background-color: #D5D5D5;
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

#like,#unlike{
background-color: #6799FF;
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

/* function like() {
 //THIS FUNCTION WILL WORK WHEN THE USER CLICKS THE BUTTON
 document.getElementById ("show").innerHTML=likes; //WILL DISPLAY THE NUMBER OF LIKES!
 likes=likes+1;
} */
var like=${like};
var unlike=${unlike};
/* like & unlike */
$(function(){
	if(like==0){
	$("#like").hide();}
	else{	
	$("#like_disabled").hide();
	}
	
	if(unlike==0){
	$("#unlike").hide();}
	else{	
	$("#unlike_disabled").hide();
	}	
});
function like(){like--;location.href="tftube_videoView?like="+like}
function like_disabled(){like++;location.href="tftube_videoView?like="+like}

function unlike(){unlike--;location.href="tftube_videoView?unlike="+unlike}
function unlike_disabled(){unlike++;location.href="tftube_videoView?unlike="+unlike}

/* function like(){
	$("#like").click(function(){
		like--;		 
		$(this).hide(1);		
		$("#like_disabled").show('fast'); 
	});
}
function like_disabled(){		
	$("#like_disabled").click(function(){
		like=like+1;
		$(this).hide(1);
		$("#like").show('fast'); 	    
	});
}	

function unlike(){
	$("#unlike").click(function(){
		like=like-1;	
		$(this).hide(1);
		$("#unlike_disabled").show('fast');
	});
}

function unlike_disabled(){		
	$("#unlike_disabled").click(function(){
		like=like+1;
		$(this).hide(1);
	    $("#unlike").show('fast'); 
	});
} */

/* move */
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
	});
	
	$(".cancel").click(function(){ 		
		$("a#reply").hide();
		
	});		
});
</script>
<title>Insert title here</title>
</head>
<body>
<span class="likebtn-wrapper" data-white_label="true" data-identifier="item_1"></span>
<!-- Video -->
<table>
<tr><td><video src="resources/tftube/uploadVideo/${vdto.video_name}" autoplay  
poster="resources/tftube/uploadImage/${vdto.image}" controls="controls" width="600" height="450"></video>
</td></tr>
<tr><td align="right">	조회수 ${readcount}회 <br></td></tr>
<tr><td align="right"> 
<form>
<input type="button" id="like_disabled" onclick="like_disabled ()" value="like">like</button>
<input type="button" id="like" onclick="like ()" value="like">like</button>
<input type="button" id="unlike_disabled" onclick="unlike_disabled ()" value="unlike">unlike</button>
<input type="button" id="unlike" onclick="unlike ()" value="unlike">unlike</button>

</form>
<!-- <button id="like_disabled" onclick="like_disabled ()" value="like">like</button>
<button id="like" onclick="like ()" value="like">like</button>
<button id="unlike_disabled" onclick="unlike_disabled ()" value="unlike">unlike</button>
<button id="unlike" onclick="unlike ()" value="unlike">unlike</button> -->

</td></tr>
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
<textArea name="content"></textArea>
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
<td>
<!-- empty space in front of reply_reply -->


<c:if test="${rdto.re_level==1}">

<!-- <img src="" style="position: relative;"><span style="position: absolute; top: 5px; right: 5px;">My profile</span></img> -->


<!-- <img src="resources/tftube/imgs/vaccum.JPG" height="80" width="80"> -->

</c:if>


<a href="tftube_mychannel?name=${r_name}">${r_name}</a>   ${rdto.reg_date}<br>
<!-- id sysdate-reg_date 아니면 java에서 변환 -->
${rdto.content}<br>

<input type="hidden" name="re_step" value="${rdto.re_step}"/>
<c:choose>
<c:when test="${memberDTO==null}">
<a href="login" class="not_login">답글</a><br>
</c:when>
<c:otherwise>
<a class="reply_button" onmouseover="" style="cursor: pointer;">답글</a><br>
					
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