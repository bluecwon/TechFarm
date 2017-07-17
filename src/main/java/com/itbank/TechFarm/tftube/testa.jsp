<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.red{color:red;}
</style>
<title>Insert title here</title>
<script src="js/jquery-1.9.0.js"></script>
<script>
$(document).ready(function(){
	$("body *").not(".three").addClass("red");
	
});


</script>
</head>
<body>
<li class="one">1</li>

<li class="one">1</li>

<li>2</li>

<li class="three">3</li>
</body>
</html>