<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 블로그 관리</title>
<link rel="stylesheet" type="text/css" href="resources/css/myBlog.css">
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
	/* $('li.color')
		.bind('mouseover' , function () {$(this).addClass('gray');})
		.bind('mouseout' , function () {$(this).removeClass('gray');})
	$('div.file')
		.bind('mouseover' , function () {$(this).addClass('gray');})
		.bind('mouseout' , function () {$(this).removeClass('gray');})
		
	$('div.file').mouseup(function(e){
		if(e.which=='3'){
			$(this).find('ul.menu').stop().slideDown(200);
		}else if(e.which=='1'){
			$(this).find('ul.menu').stop().slideUp(200);
		}
	});
	
	$('img.homemenu').mouseup(function(e){
		alert(e.which); 
	}); */
	
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
	
 function checkDel(id){
	 var isDel = window.confirm("정말로 삭제하시겠습니까?")
	 if(isDel){
		 location.href="deleteBlog?id="+id
	 }
 }
 
 
</script>
</head>
<body>
	<table width="1000px" height="1000px">
		<tr>
			<td height="80px" width="100%" colspan="2">
			<img src="resources/images/TechFarmdotBlog.jpg" onclick="location.href='http://localhost:8081/TechFarm/'" style="cursor:pointer;" width="400" height="100" />
			<div align="right" style="padding-right: 12px;"><!-- 52.79.140.54 -->
			<a href="myBlog?id=${optionDTO.id}">내 블로그</a>
			</div>
			<hr>
			</td>
		</tr>
		<tr>
			<td class="sidebar1" width="80px" valign="top" align="center">
				<h2>
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필</a><hr>
				<a href="editBlog?mode=layout&id=${optionDTO.id}">레이아웃</a><hr>
				<a href="editBlog?mode=skin&id=${optionDTO.id}">스킨</a><hr>
				<a href="editBlog?mode=neighbor&id=${optionDTO.id}">이웃</a><hr>
				<a href="editBlog?mode=board&id=${optionDTO.id}">게시판</a><hr>
				<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그</a><hr>
				</h2>
			</td>
			