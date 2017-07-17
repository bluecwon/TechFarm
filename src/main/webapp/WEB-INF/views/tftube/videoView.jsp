<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="main_top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <c:set var="like_status" value="${like_status}"/><!-- 컨트롤러에서받아옴 -->
<c:set var="unlike_status" value="${unlike_status}"/> --%>

<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
var like_status=${like_status};
var unlike_status=${unlike_status};
var no=${vdto.no};//현재 비디오 번호-무조건 있다.
var member_no=${memberDTO.no};
var subing_member_no=${vdto.member_no}//비디오 작성자-무조건 있다 */
var subing_status=${subing_status}  

/* 메서드 호출이 아니므로 실행잘될것으로 예상 */
//처음에 값ㄴ
/* var sub_status=${sub_status};   */
//에러가 발생하면 그아래것들이 다터짐. ㅇㅇ 
/* like & unlike */
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
 
$(function(){
	if(like_status==0){
	$("#like").hide();
	$("#like_disabled").show();
	}	
	else{	
	$("#like_disabled").hide();
	$("#like").show();
	}
	
	if(unlike_status==0){
	$("#unlike").hide();
	$("#unlike_disabled").show();	
	}
	else{	
	$("#unlike_disabled").hide();
	$("#unlike").show();
	}	
	
	if(subling_status==1){
	$("#sub_disabled").hide();
	$("#sub").show();
	}	
	else{	
	$("#sub_disabled").show();
	$("#sub").hide();
	}  
});

function likes()
{like_status--;location.href="tftube_videoView?no="+no+"&likep="+like_status;}
function likes_disabled()
{like_status++;location.href="tftube_videoView?no="+no+"&likep="+like_status;}

function unlikes(){unlike_status--;location.href="tftube_videoView?no="+no+"&unlikep="+unlike_status;}
function unlikes_disabled(){unlike_status++;location.href="tftube_videoView?no="+no+"&unlikep="+unlike_status;}


  function subing(){
	location.href="tftube_videoView?subed_member_no="+subing_member_no+"&mode=cancel";	
}

function subing_disabled(){
	location.href="tftube_videoView?subing_member_no="+subing_member_no+"&mode=injection";	
}  

function move_login(){
	alert("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
	location.href="login";
}

//태그를 안붙여주면 잘 못찾는 것 같다.
//하나씩만 열리도록 설정
	
	
	
});
</script>

<title>Insert title here</title>
</head>
<body>
<!-- video -->
<table>
<tr><td><video src="resources/tftube/uploadvideo/${vdto.video_name}" autoplay  
controls="controls" width="600" height="450"></video>
</td></tr>
<tr><td align="right">	조회수 ${readcount}회 <br></td></tr>
<tr>
<td align="left">
<button id="sub_disabled" onclick="subing_disabled()">구독</button>
<button id="sub" onclick="subing()" >구독중</button>
<td align="right"> 

<c:choose>
<c:when test="${member!=null}">
<button id="like_disabled" onclick="likes_disabled()">like</button>
<button id="like" onclick="likes()" >like</button><!-- it's not work -->
<fmt:formatNumber value="${vdto.likep}" pattern="#,##0"/>
<button id="unlike_disabled" onclick="unlikes_disabled()">unlike</button>
<button id="unlike" onclick="unlikes()" >unlike</button>
<fmt:formatNumber value="${vdto.unlikep}" pattern="#,##0"/>
</c:when>
<c:otherwise>
<button id="like_disabled" onclick="move_login()">like</button>
<button id="unlike_disabled" onclick="move_login()">unlike</button>
</c:otherwise>
</c:choose>
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
<a href="tftube_mychannel">${rdto.name}</a>  ${rdto.reg_date}<br> 

${rdto.content}<br>

<input type="hidden" name="re_step" value="${rdto.re_step}"/>

<c:choose>
<c:when test="${memberDTO==null}">
<a href="login" class="not_login">답글</a><br>
</c:when>
<c:otherwise>
<a class="reply_button" onmouseover="" style="cursor: pointer;">답글</a>

<c:if test="${rdto.member_no eq memberDTO.no}"> 				수정 |<a href="tftube_reply_delete?no=${vdto.no}">${paramScope.rdto}삭제</a> <br></c:if><br>

<c:if test="${re_reply_size>2}">
답글 ${re_reply_size}개 모두 보기	
</c:if>				

<a id="reply" class="reply_area">

<textArea name="content_reply"><c:if test="${rdto.re_level==1&&rdto.member_no!=memberDTO.no}">+${rdto.name}</c:if></textArea>

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