<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function back(){	
	location.href="/techfarm/";
}
</script>
<meta charset="UTF-8">
<title>채널 만들기</title>
</head>
<body>
<div align="center" style="font-size:15px;width:500px; height:400px; position:absolute; top:0; right:0; bottom:0; left:0;
margin:auto;">
<form action="createChannel" method="post">
<p>
환영합니다. 고객님.<p>
TFtube를 로그인하여 사용하기 위해선 채널 생성이 필요합니다.<p>
원하시는 채널명을 입력해주세요.<p>
<input type="text" name="channelname">
<input type="submit" value="확인"> 	<input type="button" onclick="back()" value="홈">
</form>
</div>
</body>
</html>