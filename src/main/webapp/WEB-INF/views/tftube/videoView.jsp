<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="main_top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="like_status" value="${like_status}"/><!-- 컨트롤러에서받아옴 -->
<c:set var="unlike_status" value="${unlike_status}"/>
<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
var like_status=${like_status};
var unlike_status=${unlike_status};
var no=${vdto.no};//현재 비디오 번호-무조건 있다.
var member_no=${memberDTO.no}; 
 var subing_member_no=${vdto.member_no}//비디오 작성자-무조건 있다 
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
</script> 
 -->
<title>Insert title here</title>
</head>
<body>
<!-- video -->
<div id="2-2-1" style="overflow:auto;"> <!-- start of 2-1-1 -->
<table>
<tr><td><video src="resources/tftube/uploadvideo/${vdto.video_name}" autoplay  
controls="controls" width="600" height="450"></video>
</td></tr>
<tr><td align="right">	조회수 ${readcount}회 <br></td></tr>
<tr>
<td align="left">
<!-- <button id="sub_disabled" onclick="subing_disabled()">구독</button>
<button id="sub" onclick="subing()" >구독중</button> -->
<%@include file="videoView_subscribe.jsp" %>
<%-- <jsp:include page="videoView_subscribe.jsp"/> --%>
<td align="right">
<%@include file="videoView_like.jsp" %> 
<%-- <jsp:include page="videoView_like.jsp"/> --%>
<%-- <c:choose>

<c:when test="${memberDTO!=null}">
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
</c:choose> --%>
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
	
	
 ${vdto.description}<p> 
 </td></tr>
 </table>
 <%@include file="videoView_reply.jsp"%>
 <%-- <%@include file="videoView_reply.jsp" %> --%>
 
<!-- Reply -->

	
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
 </div><!-- end of 2-2-1 -->
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