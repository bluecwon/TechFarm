<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var subing_member_no=${vdto.member_no}//비디오 작성자-무조건 있다 
var subing_status=${subing_status} 
function subing(){
	location.href="subChannel?subed_member_no="+subing_member_no+"&no="+${vdto.no}+"&mode=cancel";	
}

function subing_disabled(){
	location.href="subChannel?subing_member_no="+subing_member_no+"&no="+${vdto.no}+"&mode=injection";	
}  

function move_login(){
	alert("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
	location.href="login";
}

$(function(){
	if(subling_status==1){
		$("#sub_disabled").hide();
		$("#sub").show();
		}	
		else{	
		$("#sub_disabled").show();
		$("#sub").hide();
		}  	
});


</script>
</head>
<body>

<button id="sub_disabled" onclick="subing_disabled()">구독</button>
<button id="sub" onclick="subing()" >구독중</button>
</body>
</html>