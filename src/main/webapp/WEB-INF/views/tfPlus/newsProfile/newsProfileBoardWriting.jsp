<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="stylesheet" media="all" href="resources/tfPlus/css/style.css"/>
		<link rel="stylesheet" media="all" href="resources/tfPlus/css/windowOpen.css"/>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- 이미지 미리보기 -->
		<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> <!-- 이미지 미리보기 -->
		
		<title>Insert title here</title>
	</head>
	<body>
	
		<form name="f" id="contactForm" action="#" method="post" enctype="multipart/form-data">
			<fieldset>
				<table class="jjm494">
					<tr>
						<th scope="row">글제목</th>
						<td>
							<input type="text" class="form-poshytip" title="글 제목을 입력하세요"/>
						</td>
					</tr>
					<tr>
						<th scope="row">글내용</th>
						<td>
							<textarea  name="profileContents"  id="comments" rows="2" cols="6" class="form-poshytip" title="글 내용을 입력하세요"></textarea>
						</td>
					</tr>
					<tr>
						<th scope="row">이미지</th>
						<td>
							<div style="text-align:center;">
								<input id="file1" type="file" style="width:500px;" accept="image/*" onchange="fileInfo(this)"/><br>
								<div id="img_box"></div>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" colspan="2" align="center">
							<input type="button" onClick="javascript:input();" value="만들기"/>
							<input type="button" onClick="self.close();" value="취소"/>
						</th>
					</tr>
				</table>
			</fieldset>
		</form>

		<script type="text/javascript">
			function input() {
				window.close();
			}
			function fileInfo(f){
				var file = f.files; 
				var reader = new FileReader();
				reader.onload = function(rst){
					$('#img_box').html('<img src="' + rst.target.result + '" width="300px" height="100px">');
				}
				reader.readAsDataURL(file[0]);
			}
		</script>
		
	</body>
</html>