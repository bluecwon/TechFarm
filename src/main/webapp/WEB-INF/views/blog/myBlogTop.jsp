<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${optionDTO.blogname}</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/smarteditor/js/HuskyEZCreator.js"/>" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="resources/css/myBlog.css">
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/writeForm.js"/>"></script>

<script type="text/javascript" charset="utf-8">
sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
function checkDelBoard(no){
	 var isDel = window.confirm("삭제한 게시글은 복구할 수 없습니다. 정말로 삭제하시겠습니까?")
	 if(isDel){
		 location.href="deleteBoard?no="+no
	 }
}
function checkDelReply(replyno){
	 var isDel = window.confirm("삭제한 댓글은 복구할 수 없습니다. 정말로 삭제하시겠습니까?")
	 if(isDel){
		 location.href="deleteReply?replyno="+replyno
	 }
}
function login(){
	 var login = window.confirm("로그인 후 가능한 서비스입니다. 로그인 페이지로 이동하시겠습니까?")
	 if(login){
		 location.href="login"
	 }
 }
</script>
</head>
<body>
	<table width="1900px" height="1900px">
		<tr>