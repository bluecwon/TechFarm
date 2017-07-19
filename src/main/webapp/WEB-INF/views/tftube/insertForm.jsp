<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@include file="main_top.jsp" %>
<div id="2-2-1">
<form name="f" method="post" enctype="multipart/form-data" action="tftube_video_insert">

<table>
<tr><td>파일: <input type="file" id="filename" name="filename" accept="video/*" >
<p id="file_check"></p></td></tr>
<tr><td>제목: <input type="text" id="title" name="title">
<p id="title_check"></p></td></tr>
<tr><td>설명: <input type="text" id="description" name="description">
<p id="description_check"></p></td></tr>
<tr><td>카테고리 
<select name="category">
<option value="movie" selected>영화</option>
<option value="animation">애니메이션</option>
<option value="car">자동차</option>
<option value="music">음악</option>
<option value="sport">동물</option>
<option value="sports">스포츠</option>
<option value="travel/event">여행/이벤트</option>
<option value="game">게임</option>
<option value="blog/person">블로그/인물</option>
<option value="comedy">코미디</option>
<option value="entertainment">엔터테인먼트</option>
<option value="news/">뉴스/정치</option>
<option value="nohow/style">노하우/스타일</option>
<option value="education">교육</option>
<option value="technology">과학기술</option>
<option value="none_profit/social_movement">비영리/사회운동</option>
</select></td></tr>

<tr><td>공개범위 
<select name="open">
<option value="t" selected>공개</option>
<option value="f">비공개</option>
</select></td></tr>



<tr><td>미리보기 이미지:<input type="file" id="image" name="image">
<p id="image_check"></p>
<button type="submit" onClick="check_file()">전송</button>
<!-- <input type="submit" value="전송"> -->
<input type="reset" value="취소">
</td></tr>
</table>
</form> 

<article>
  <p id="status"><!-- File API &amp; FileReader API not supported --></p>   
  <div id="holder"></div>
</article>

<script>

function check_file(){
	
	var image=document.getElementById("image");
	var file=document.getElementById("filename");
	var title=document.getElementById("title");
	var description=document.getElementById("description");
	
	var file_check=document.getElementById('file_check');
	var title_check=document.getElementById('title_check');;
	var description_check=document.getElementById('description_check');;
	var image_check=document.getElementById('image_check');;
	
	if(!(file.substring(file.length()-3, file.length()).equals("mp4"))){
		file_check.innerHTML = 'mp4 동영상만 업로드 가능 합니다';
		
	}else if(file==null){
		file_check.innerHTML = '업로드 하실 동영상을 선택하세요.'; 	
	}
	if(title==null){
		title_check.innerHTML = '제목을 입력해주세요.'; 	
	}
	if(description==null){
		description_check.innerHTML = '내용을 입력해주세요.'; 	
	}	
	if(image==null){
		image_check.innerHTML = '미리보기 이미지를 선택하세요.'; 	
	}	
	if(file==null||title==null||description==null||image==null){return;}
	document.f.summit();
}
/* present image */
 var upload=document.getElementById('image'), 
 /* var upload = document.getElementsByTagName('input')[3], */ 
    holder = document.getElementById('holder'),
    state = document.getElementById('status');

if (typeof window.FileReader === 'undefined') {
  state.className = 'fail';
} else {
  state.className = 'success';
  state.innerHTML = ''/* 'File API & FileReader available' */;
}
 
upload.onchange = function (e) {
  e.preventDefault();

  var file = upload.files[0],
      reader = new FileReader();
  reader.onload = function (event) {
    var img = new Image();
    img.src = event.target.result;
    
    img.width = 200;
    img.height=160;
        
    holder.innerHTML = '';
    holder.appendChild(img);
  };
  reader.readAsDataURL(file);
  return false;
};

</script>
</div>
<%@include file="main_bottom.jsp" %>
</body>
</html>