<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="main_top.jsp"%>

<form id="fileupload" action="tftube_video_insert" method="POST" enctype="multipart/form-data">
<table>
<tr><td>동영상 파일: <input type="file"  name="filename" accept="video/mp4" ></td></tr><!-- ,webm,ogg -->
<tr><td>제목: <input type="text" name="title" autofocus></td></tr>
<tr><td>설명: <input type="text" name="description"></td></tr>

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
</select>
<tr><td>미리보기 이미지:<input type="file" id="image" name="image">
<input type="submit" value="전송">
<input type="reset" value="취소">
</td></tr>

</table></form>
<!-- <img src="" height="200" id="image"> -->


<!-- <article>
  <p id="status">File API &amp; FileReader API not supported</p>   
  <div id="holder"></div>
</article> -->
<article>
  <p id="status"><!-- File API &amp; FileReader API not supported --></p>   
  <div id="holder"></div>
</article>
<script>

function check_files(){
	var image=document.getElementById("image");
	var file=document.getElementById("filename");
	
	if(!(filename.substring(filename.length()-3, filename.length()).equals("mp4"))){
		alert("mp4파일만 업로드 가능합니다.")		
	}
}
/* present image */
var upload = document.getElementsByTagName('input')[3],
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
    img.src = event.target.result;//이게 뭔지는 모르겠다만
    // note: no onload required since we've got the dataurl...I think! :)

    if (img.width > 160) { // holder width
      img.width = 160;
    }  
    
    holder.innerHTML = '';
    holder.appendChild(img);//holder에 새로운 이미지를 갔다 붙이는듯?
  };
  
  reader.readAsDataURL(file);
  return false;
};
</script>
<script>
/*function check_files(){
	var image=document.getElementById("image");
	var file=document.getElementById("filename");
	
	if(!(filename.substring(filename.length()-3, filename.length()).equals("mp4"))){
		alert("mp4파일만 업로드 가능합니다.")		
	}
}
var w=new Worker("worker_test_js")
w.postMessage(AA);

w.onmessage=function(event){
	var AA=event.data;
	var results=AA;//제일 노이해
	postMesssage(results);
}
 */
 
 /*
 function previewFile() {
	  var preview = document.getElementsById('image').file(0);
	  // var preview = document.querySelector('img'); 
	  var file =document.getElementsById('image').file(0);
	  // var file    = document.querySelector('input[type=file]').files[0]; 
	  var reader  = new FileReader();

	  reader.addEventListener("load", function () {
	    preview.src = reader.result;
	  }, false);

	  if (file) {
	    reader.readAsDataURL(file);
	  }// else{	reader.readAsDataURL(""); 
	  } 
	}*/ 
	
/* present image */
/* var upload = document.getElementsById('image'),
    holder = document.getElementById('holder'),
    state = document.getElementById('status');

if (typeof window.FileReader === 'undefined') {
  state.className = 'fail';
} else {
  state.className = 'success';
  state.innerHTML = ''/* 'File API & FileReader available' ;
}
 
upload.onchange = function (e) {
  e.preventDefault();//취소 가능하다면 취소

  var file = upload.files[0],
      reader = new FileReader();//파일 읽고 저장
  
  reader.onload = function (event) {//event handler executed 
    	  //when load event fired when content read with readAsArrayBuffer, readAsBinaryString, readAsDataURL or readAsText is available.
   var img = new Image();
   img.src = event.target.result;
    // note: no onload required since we've got the dataurl...I think! :)

    if (img.width > 160) { // holder width
      img.width = 160;
    }  
    
    holder.innerHTML = '';//?
    holder.appendChild(img);//?
  };
  
  reader.readAsDataURL(file);//? 파일읽기 -> 최종 이벤트 발생
  return false;
}; */
</script>
<%@include file="main_bottom.jsp"%>
</body>
</html>