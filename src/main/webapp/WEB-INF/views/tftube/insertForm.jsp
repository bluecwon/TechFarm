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
<%@include file="main_top.jsp"%>
<form name="f" method="post" enctype="multipart/form-data" action="tftube_video_insert">

<table>
<tr><td>동영상 파일: <input type="file" id="filename" name="filename" accept="video/*" ></td></tr>
<tr><td>제목: <input type="text" name="title"></td></tr>
<tr><td>설명: <input type="text" name="description"></td></tr>

<tr><td>공개범위 
<select name="open">
<option value="t" selected>공개</option>
<option value="f">비공개</option>
</select></td></tr>

<tr><td>카테고리 
<select name="category">
<option value="movie/animation" selected>영화/애니메이션</option>
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

<tr><td>미리보기 이미지:<input type="file" id="image" name="image">

<input type="submit" value="전송">
<input type="reset" value="취소">
</td></tr>
</table>
</form> 

 <form id="fileupload" action="tftube_video_insert" method="POST" enctype="multipart/form-data">
        <!-- Redirect browsers with JavaScript disabled to the origin page -->
        <noscript><input type="hidden" name="redirect" value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
        <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
        <div class="row fileupload-buttonbar">
            <div class="col-lg-7">
                <!-- The fileinput-button span is used to style the file input field as button -->
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Add files...</span>
                    <input type="file" name="filename" multiple>
                </span>
                <button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start upload</span>
                </button>
                <button type="reset" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel upload</span>
                </button>
                <button type="button" class="btn btn-danger delete">
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" class="toggle">
                <!-- The global file processing state -->
                <span class="fileupload-process"></span>
            </div>
            <!-- The global progress state -->
            <div class="col-lg-5 fileupload-progress fade">
                <!-- The global progress bar -->
                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                </div>
                <!-- The extended global progress state -->
                <div class="progress-extended">&nbsp;</div>
            </div>
        </div>
        <!-- The table listing the files available for upload/download -->
        <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
    </form>



<%@include file="main_bottom.jsp"%>
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
<script src="resources/tftube/fileupload/js/vendor/jquery.ui.widget.js"></script>
<!-- The Templates plugin is included to render the upload/download listings -->
<script src="//blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="//blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="//blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- blueimp Gallery script -->
<script src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="resources/tftube/fileupload/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload.js"></script>
<!-- The File Upload processing plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload-process.js"></script>
<!-- The File Upload image preview & resize plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload-image.js"></script>
<!-- The File Upload audio preview plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload-audio.js"></script>
<!-- The File Upload video preview plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload-video.js"></script>
<!-- The File Upload validation plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload-validate.js"></script>
<!-- The File Upload user interface plugin -->
<script src="resources/tftube/fileupload/js/jquery.fileupload-ui.js"></script>
<!-- The main application script -->
<script src="resources/tftube/fileupload/js/main.js"></script>

</body>
</html>