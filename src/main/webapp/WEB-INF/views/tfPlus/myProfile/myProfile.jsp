<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<!-- 상단 부분 -->

<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- 이미지 미리보기 -->
<link rel="stylesheet" href="resources/tfPlus/css/myProfile.css"/>
<div id="main">	
	<div class="wrapper clearfix">
		<div id="page-content" class="clearfix">
			<script type="text/javascript" src="js/form-validation.js"></script>
			<form name="f" id="contactForm" action="tfPlusNewsProfileWritingPro?id=${sessionScope.memberDTO.id}" method="post" enctype="multipart/form-data">
				<h2 class="page-heading"><span>내 프로필 정보 등록</span></h2>
				<p></p>	
				<fieldset>
					<table class="jjm494_myProfile">
						<tr>
							<td>
								<div class="filebox bs3-primary preview-image">
									<input class="upload-name" value="파일선택" disabled="disabled" style="width: 200px;">
									<label for="input_file">프로필 사진등록</label> 
									<input type="file" id="input_file" class="upload-hidden"> 
								</div>
							</td>
						</tr>
						<tr>
							<td align="center">
								취미등록 : 
								<select class="selectOption" name="checkOption">
									<option>게임</option>
									<option>운동</option>
									<option>학업</option>
									<option>미용</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="center">
								<input type="submit" value="만들기"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
			<!-- 사용자 정보 사이드 메뉴 시작 -->
        	<aside id="contact-sidebar">
        		<div class="block">
	        		<h4>사용자 정보</h4>
	        		<img src="resources/tfPlus/images/default/basicImg.JPG" style="width:100px; height:50px;">
	        		<p>이름 : ${sessionScope.memberDTO.name}</p>
	        		<ul class="address-block">
	        			<li class="address">ID : ${sessionScope.memberDTO.id}</li>
	        			<li class="email"><a href="mailto:email@server.com">${sessionScope.memberDTO.email}</a></li>
	        		</ul>
        		</div>	        	
        	</aside>
        	<div class="clearfix"></div>
			<!-- 사용자 정보 사이드 메뉴 끝 -->
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var fileTarget = $('.filebox .upload-hidden');
			fileTarget.on('change', function(){
				if(window.FileReader){
					// 파일명 추출
					var filename = $(this)[0].files[0].name;
				} else { // Old IE 파일명 추출
					var filename = $(this).val().split('/').pop().split('\\').pop();
				};
				$(this).siblings('.upload-name').val(filename);
			});
			//preview image 
			var imgTarget = $('.preview-image .upload-hidden');
			imgTarget.on('change', function(){
			var parent = $(this).parent();
			parent.children('.upload-display').remove();
			if(window.FileReader){
				//image 파일만
				if (!$(this)[0].files[0].type.match(/image\//)) return;
					var reader = new FileReader();
					reader.onload = function(e){
						var src = e.target.result;
						parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
					}
				reader.readAsDataURL($(this)[0].files[0]);
			} else {
				$(this)[0].select();
				$(this)[0].blur();
				var imgSrc = document.selection.createRange().text;
				parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');
				var img = $(this).siblings('.upload-display').find('img');
				img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";        
			}
		});
	});
</script>

<!-- 하단 부분 -->
<%@include file="../footer.jsp"%>