<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=300 height=300"> -->
<title>Insert title here</title>
</head>
<body>

<form name="f" method="post" enctype="multipart/form-data" action="tftube_video_insert">
<table>
<tr><td>파일: <input type="file" name="filename" accept="video/*" ></td></tr> 
<c:choose>
<c:when test="${filename!=null}">
<c:when test="${filename.substring(filename.length()-3,filename.length()).equals('mp4')}"/>
<c:otherwise>
<script type="text/javascript">
alert("확장자가 mp4인 동영상 파일만 업로드 가능합니다.")
location.href="tftube_insert"
</script>
</c:otherwise>
</c:when>
</c:choose>
<tr><td>제목: <input type="text" name="title"></td></tr>
<tr><td>설명: <input type="text" name="description"></td></tr>
<tr><td>공개범위 
<select name="open">
<option value="T" selected>공개</option>
<option value="F">비공개</option>
</select>
<tr><td>미리보기 이미지:<input type="file" name="image">

<input type="submit" value="전송">
<input type="reset" value="취소">
</td></tr>
</table>
</form> 

 <article>
  <p id="status"><!-- File API &amp; FileReader API not supported --></p>   
  <div id="holder"></div>
</article>
<script>
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
    img.src = event.target.result;
    // note: no onload required since we've got the dataurl...I think! :)

    if (img.width > 160) { // holder width
      img.width = 160;
    }  
    
    holder.innerHTML = '';
    holder.appendChild(img);
  };
  reader.readAsDataURL(file);
  return false;
};
</script>

  




</body>
</html>