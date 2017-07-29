<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 블로그 관리</title>
<link rel="stylesheet" type="text/css" href="resources/css/myBlog.css">
<link rel="stylesheet" type="text/css" href="resources/css/cssTop.css">
<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="resources///code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
function layoutChoice(num){  //makeBlog2 layout 변경
		document.getElementById('layout'+num).checked = true;

	for(var i=1; i<=6; i++){
		$('.layout'+i).attr("src",
		         "resources/images/layout/layout"+i+".jpg");
		$('.layoutedit'+i).slideUp(200);
	}
		 $('.layout'+num).attr("src",
     "resources/images/layout/layout"+num+"on.jpg");
		 
		$('.layoutedit'+num).slideDown(200);
	}
	
$(document).ready(function(){
	
	$("#menu1").click(function() { 
		$("#headertop").find(".header_menu").slideDown('normal').show();
	});
	$("#close").click(function() {
		$("#headertop").find(".header_menu").slideUp('fast').show();  
	});
	$("#myinfo").click(function() { 
		$("#headertop").find(".header_info").slideDown('normal').show();
	});
	$("#close2").click(function() {
		$("#headertop").find(".header_info").slideUp('fast').show();  
	});
	
	$('#pf').on('change', function(){
         readURL(this);
    });
	
	function readURL(input){
    //선택된 파일 있다면
    if(input.files && input.files[0]){
    //선택된 파일 이름 가져오기
    var fileName=
    input.files[0].name;
    //파일 이름에서 뒤의 3글자 가져오기
    var ext=fileName.substr(
    fileName.length-3, fileName.length);
         
    //확장자를 확인해서 jpg, gif, png가 아니면
    //함수를 빠져나감
     var isCheck=false; 
     if(ext.toLowerCase()=='jpg' || ext.toLowerCase()=='gif' || ext.toLowerCase()=='png'){
         isCheck=true;
      }
     if(isCheck==false){
      	 alert(".jpg .png .gif 파일만 등록 가능합니다.");
         return;
      }
		// 파일의 내용을 읽어 올 수 있는 파일 객체
        var reader = new FileReader();
        //읽을 파일을 설정
        reader.readAsDataURL(input.files[0]);          
        //파일의 내용이 메모리에 전부 로드되면
        //img 태그에 출력
        reader.onload=function(e){
        $('#pfimg').attr('src', e.target.result);
        }          
        } //end if
	} //end readURL
});

function check(href){
	if(${sessionScope.memberDTO == null}){
		alert("먼저 로그인해주세요");
	} else {
		location.href=href;
	}
};
function insert(){
	document.frm.submit();
};
function update(){
	document.f.submit();
};

	
 function checkDel(id){
	 var isDel = window.confirm("삭제한 블로그는 복구할 수 없습니다. 정말로 삭제하시겠습니까?")
	 if(isDel){
		 location.href="deleteBlog?id="+id
	 }
 }
 
 
</script>
</head>
<body>
    <div id="viewtitle">TF Blog</div>
<div id="headertop" align="right">
			<div class="topnav">
	  			<a rel="tooltip" title="메뉴"><img id="menu1" src="resources/home/imgs/menu_white.png" width="25" height="25"></a>&nbsp&nbsp&nbsp&nbsp
	  			<c:if test="${sessionScope.memberDTO eq null}">
	  			<a rel="tooltip" title="로그인" href="login">
	  				<img src="resources/home/imgs/login.png" width="25" height="25">
	  			</a>
	  			</c:if>
	  			<c:if test="${sessionScope.memberDTO ne null}">
	  				<abbr title="정보보기">
	  				<img id="myinfo" src="resources/home/imgs/profile.png" width="30" height="30">
	  				</abbr>
	  			</c:if>
	  			&nbsp&nbsp&nbsp&nbsp&nbsp 
			</div>
			<div class="header_menu" align="center">
			<table>
				<tr height="70px">
					<td align="center" width="80px"><a href="#" onclick="check('myAccount');"><img id="img_handle" src="resources/home/imgs/account.png" width="50px" height="50px"></a><br>내계정</td>
					<td align="center" width="80px"><a href="home"><img id="img_handle" src="resources/home/imgs/search.png" width="50px" height="50px"></a><br>검색</td>
					<td align="center" width="80px"><a href="#" onclick="check('listJames');"><img id="img_handle" src="resources/home/imgs/mail.png" width="50px" height="50px"></a><br>메일</td>
				</tr>
				<tr height="70px">
					<td align="center" width="80px"><a href="#" onclick="check('tfPlusIndex');"><img id="img_handle" src="resources/home/imgs/social.png" width="50px" height="50px"></a><br>SNS</td>
					<td align="center" width="80px"><a href="tftube_main"><img id="img_handle" src="resources/home/imgs/utube.png" width="50px" height="50px"></a><br>영상</td>
					<td align="center" width="80px"><a href="blogmain"><img id="img_handle" src="resources/home/imgs/document.png" width="50px" height="50px"></a><br>블로그</td>
				</tr>
				<tr height="70px">
					<td align="center" width="80px"><a href="#" onclick="check('tfNoteIndex?id=${sessionScope.memberDTO.id}');"><img id="img_handle" src="resources/home/imgs/memo.png" width="50px" height="50px"></a><br>메모</td>
					<td align="center" width="80px"><a href="#" onclick="check('tfchat_main');"><img id="img_handle" src="resources/home/imgs/chatting.png" width="50px" height="50px"></a><br>채팅</td>
					<td align="center" width="80px"><a href="#" onclick="check('listContacts');"><img id="img_handle" src="resources/home/imgs/calendar.png" width="50px" height="50px"></a><br>연락처</td>
				</tr>
			</table>
			<hr>
			<input type="button" id="close" value="Close"/>		
			</div>
			<div class="header_info" align="center">
				<div>
					<img src="resources/home/imgs/account.png" width="50px" height="50px">
				</div>
				<div>
				${sessionScope.memberDTO.name}님 환영합니다.<br>
				${sessionScope.memberDTO.id}<br>
				${sessionScope.memberDTO.email}<br>
				<a href="logout">로그아웃</a><br>
				</div>
				<hr>
				<input type="button" id="close2" value="Close"/>
			</div>
	</div>
	<table width="2000px" height="1000px">
		<tr>
			<td class="editsidebar" width="400px"  valign="top" align="center">
				<h2>
				<a href="myBlog?id=${optionDTO.id}" class="editmenu">내 블로그</a><hr>
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필</a><hr>
				<a href="editBlog?mode=neighbor&id=${optionDTO.id}">이웃</a><hr>
				<a href="editBlog?mode=layout&id=${optionDTO.id}">레이아웃</a><hr>
				<a href="editBlog?mode=skin&id=${optionDTO.id}">스킨</a><hr>
				<a href="editBlog?mode=board&id=${optionDTO.id}">게시판</a><hr>
				<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그</a><hr>
				</h2>
			</td>
			