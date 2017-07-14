<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="main_top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="like" value="${like}"/>
<c:set var="unlike" value="${unlike}"/>
<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
var like=${like};
var unlike=${unlike};
var no=${vdto.no}
/* like & unlike */
$(function(){
	if(like==0||like==null){
	$("#like").hide();
	$("#like_disabled").show();
	}	
	else{	
	$("#like_disabled").hide();
	$("#like").show();
	}
	
	if(unlike==0||like==null){
	$("#unlike").hide();}
	else{	
	$("#unlike_disabled").hide();
	}	
});
function like()
{like--;location.href="tftube_videoView?no="+no+"&like="+like;}
function like_disabled()
{like++;location.href="tftube_videoView?no="+no+"&like="+like;}

function unlike(){unlike--;location.href="tftube_videoView?no="+no+"&unlike="+unlike;}
function unlike_disabled(){unlike++;location.href="tftube_videoView?no="+no+"&unlike="+unlike;}

/* function like(){
	$("#like").click(function(){
		like--;		 
		$(this).he(1);		
		$("#like_disabled").show('fast'); 
	});
}
function like_disabled(){		
	$("#like_disabled").click(function(){
		like=like+1;
		$(this).he(1);
		$("#like").show('fast'); 	    
	});
}	

function unlike(){
	$("#unlike").click(function(){
		like=like-1;	
		$(this).he(1);
		$("#unlike_disabled").show('fast');
	});
}

function unlike_disabled(){		
	$("#unlike_disabled").click(function(){
		like=like+1;
		$(this).he(1);
	    $("#unlike").show('fast'); 
	});
} */

/* move */
/* function GReply(){
	document.f1.action="tftube_reply_insert?mode=general";
	document.f1.submit();	
}

function DReply(){
	document.f2.action="tftube_reply_insert?mode=deep";
	document.f2.submit();	
} */

//태그를 안붙여주면 잘 못찾는 것 같다.
//하나씩만 열리도록 설정
$(function(){
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
<!-- video -->
<table>
<tr><td><video src="resources/tftube/uploadvideo/${vdto.video_name}" autoplay  
poster="resources/tftube/uploadImage/${vdto.image}" controls="controls" width="600" height="450"></video>
</td></tr>
<tr><td align="right">	조회수 ${readcount}회 <br></td></tr>
<tr><td align="right"> 
<!-- 
<form>
 <input type="button" ="like_disabled" onclick="like_disabled ()" value="like"></button>
<input type="button" ="like" onclick="like ()" value="like"></button>
<input type="button" ="unlike_disabled" onclick="unlike_disabled ()" value="unlike"></button>
<input type="button" ="unlike" onclick="unlike ()" value="unlike"></button>

</form>
 -->
<button id="like_disabled" onclick="like_disabled()">like</button>
<button id="like" onclick="like()" >like</button><!-- it's not work -->
<button id="unlike_disabled" onclick="unlike_disabled()" value="unlike">unlike</button>
<button id="unlike" onclick="unlike()" >unlike</button>

</td></tr>
</table>
<br>
<!-- video Edit and Delete -->
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
<form name="f1" method="post" action=tftube_reply_insert>
<textArea name="content"></textArea>
<input type="hidden" name="video_name" value="${vdto.video_name}">
<input type="hidden" name="no" value="${vdto.no}">
<input type="hidden" name="mode" value="general">
<input type="submit" value="입력">
</form>
</td></tr>
</c:otherwise></c:choose>

</table>



<!-- Reply list -->
<table>
<c:forEach var="rdto" items="${r_list}">
<tr>
<td>
<!-- empty space in front of reply_reply -->
<c:if test="${rdto.re_level==1}">
<div class = "imaj"><!-- float -->
<img src="" width="80" height="80">
</div>
</c:if>

<!-- re_reply -->
<form name="f2" method="post" action="tftube_reply_insert">
<!-- reply contents with reply information -->

<div class = "titl"><!--empty space securement-->
<a href="tftube_mychannel?name=${rdto.member_no}">${rdto.name}</a>  ${rdto.reg_date}<br> 

${rdto.content}<br>

<input type="hidden" name="re_step" value="${rdto.re_step}"/>

<c:choose>
<c:when test="${memberDTO==null}">
<a href="login" class="not_login">답글</a><br>
</c:when>
<c:otherwise>
<a class="reply_button" onmouseover="" style="cursor: pointer;">답글</a>

<c:if test="${rdto.member_no eq memberDTO.no}"> 				수정 |<a href="tftube_reply_delete?no=${vdto.no}&reply=${rdto}">삭제</a> <br></c:if><br>
<c:if test="${re_reply_size>2}">
답글 ${re_reply_size}개 모두 보기	
</c:if>				

<a id="reply" class="reply_area">

<textArea name="content_reply"><c:if test="${rdto.re_level==1&&rdto.member_no!=memberDTO.no}">+${rdto.name}</c:if>

</textArea>

<input type="hidden" name="video_name" value="${vdto.video_name}">
<input type="hidden" name="mode" value="deep">
<input type="submit" value="입력">
<input class="cancel" type="button" value="취소">
</a>
</div>

</c:otherwise>
</c:choose>
</form>
<!--답글이 존재한다면 답글:답글갯수 -->
</tr>

</c:forEach>
</table>
<!-- end of Reply List -->
	
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
<style>
#like_disabled{
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
#unlike_disabled{
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

#like{
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
#unlike{
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
</html>