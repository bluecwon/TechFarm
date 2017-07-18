<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="like_status" value="${like_status}"/><!-- 컨트롤러에서받아옴 -->
<c:set var="unlike_status" value="${unlike_status}"/>
<c:out value="4변수 출력"/>
<c:out value="1:${like_status}"/>
<c:out value="2:${unlike_status}"/>
<c:out value="3:${vdto.no}"/>
<c:out value="4:${memberDTO.no}"/>
<c:out value="4변수 출력끝"/>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="resources/js/jquery-1.9.0.js" type="text/javascript">
var like_status=${like_status};
var unlike_status=${unlike_status};
var no=${vdto.no};//없을 가능성 농후
var member_no=${memberDTO.no};


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
});
	function likes()
	{like_status--;location.href="likeVideo?no="+no+"&likep="+like_status;}
	function likes_disabled()
	{like_status++;location.href="likeVideo?no="+no+"&likep="+like_status;}

	function unlikes(){unlike_status--;location.href="likeVideo?no="+no+"&unlikep="+unlike_status;}
	function unlikes_disabled(){unlike_status++;location.href="likeVideo?no="+no+"&unlikep="+unlike_status;}	
	
</script>

</head>
<body>
<c:choose>

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

</c:choose>
</body>
</html>