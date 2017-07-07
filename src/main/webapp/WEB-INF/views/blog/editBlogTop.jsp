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
	
 function checkDel(id,header,profile){
	 var isDel = window.confirm("정말로 삭제하시겠습니까?")
	 if(isDel){
		 location.href="deleteBlog?id="+id+"&header="+header+"&profile="+profile
	 }
 }	
</script>
</head>
<body>
	<table width="1000px" height="1000px">
		<tr>
			<td height="80px" width="100%" colspan="2">
			<img src="resources/images/TechFarmdotBlog.jpg" onclick="location.href='http://52.79.140.54/TechFarm/'" style="cursor:pointer;" width="400" height="100" />
			<div align="right" style="padding-right: 12px;">
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
				<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그</a><hr>
				</h2>
			</td>
			