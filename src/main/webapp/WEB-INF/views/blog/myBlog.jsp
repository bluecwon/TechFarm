<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${optionDTO.blogname}</title>
<link rel="stylesheet" type="text/css" href="resources/css/myBlog.css">
</head>
<body>
	<c:if test="${optionDTO.layout==1}">
	<table width="1900px" height="1900px">
		<tr>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar1">
			<div id="sidebar1">
				<div align="right">
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필 관리</a>&nbsp;&nbsp;<br>
				</div>
				<div id=profile>
				<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="300px" height="300px"><br>
				${optionDTO.introduce}<br><br><br><br>
				</div><br><br><br>
				<hr>
				<div id="neighbor">
				이웃
				<hr>
				</div>
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar1 div end -->
			</td>
			<td height="80px" width="60%">
			<div id="header">
			<h1>${optionDTO.headerword}</h1>
			<div align="right">
			<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그 관리</a>&nbsp;&nbsp;
			</div>
			</div>
			</td>
		</tr>
		<tr>
			<td height="500px" width="60%" align="center" class="header"background="resources/upload/${optionDTO.id}/${optionDTO.header}" >
			
			</td>
		</tr>
		<tr>
			<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			메인
			</div>
			</td>
		</tr>	
	</table>
	</c:if> <!-- end layout1 -->
	<c:if test="${optionDTO.layout==2}">
	<table width="1900px" height="1900px">
		<tr>
			<td height="80px" width="60%">
			<div id="header">
			<h1>${optionDTO.headerword}</h1>
			<div align="right">
			<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그 관리</a>&nbsp;&nbsp;
			</div>
			</div>
			</td>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar2">
			<div id="sidebar2">
				<div align="right">
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필 관리</a>&nbsp;&nbsp;<br>
				</div>
				<div id=profile>
				<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="300px" height="300px"><br>
				${optionDTO.introduce}<br><br><br><br>
				</div><br><br><br>
				<hr>
				<div id="neighbor">
				이웃
				
				<hr>
				</div>
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar1 div end -->
			</td>
		</tr>
		<tr>
			<td height="500px" width="60%" align="center" class="header"background="resources/upload/${optionDTO.id}/${optionDTO.header}" >
			</td>
		</tr>
		<tr>
			<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			메인
			</div>
			</td>
		</tr>	
	</table>
	</c:if>
	<c:if test="${optionDTO.layout==3}">
	<table width="1900px" height="1900px">
		<tr>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar1">
			<div id="sidebar1">
				<div align="right">
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필 관리</a>&nbsp;&nbsp;<br>
				</div>
				<div id=profile>
				<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="300px" height="300px"><br>
				${optionDTO.introduce}<br><br><br><br>
				</div><br><br><br>
				<hr>
				<div id="neighbor">
				이웃
				
				<hr>
				</div>
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar1 div end -->
			</td>
			<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			메인
			</div>
			</td>
		</tr>
		<tr>
			<td height="80px" width="60%">
			<div id="header">
			<h1>${optionDTO.headerword}</h1>
			<div align="right">
			<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그 관리</a>&nbsp;&nbsp;
			</div>
			</div>
			</td>
		</tr>
		<tr>
			<td height="500px" width="60%" align="center" class="header"background="resources/upload/${optionDTO.id}/${optionDTO.header}" >
			</td>
		</tr>	
	</table>
	</c:if>
	<c:if test="${optionDTO.layout==4}">
	<table width="1900px" height="1900px">
		<tr>
			<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			메인
			</div>
			</td>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar2">
			<div id="sidebar2">
				<div align="right">
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필 관리</a>&nbsp;&nbsp;<br>
				</div>
				<div id=profile>
				<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="300px" height="300px"><br>
				${optionDTO.introduce}<br><br><br><br>
				</div><br><br><br>
				<hr>
				<div id="neighbor">
				이웃
				
				<hr>
				</div>
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar1 div end -->
			</td>
		</tr>
		<tr>
			<td height="80px" width="60%">
			<div id="header">
			<h1>${optionDTO.headerword}</h1>
			<div align="right">
			<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그 관리</a>&nbsp;&nbsp;
			</div>
			</div>
			</td>
		</tr>
		<tr>
			<td height="500px" width="60%" align="center" class="header"background="resources/upload/${optionDTO.id}/${optionDTO.header}" >
			</td>
		</tr>	
	</table>
	</c:if>
	<c:if test="${optionDTO.layout==5}">
	<table width="1900px" height="1900px">
		<tr>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar1">
			<div id="sidebar1">
				<div align="right">
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필 관리</a>&nbsp;&nbsp;<br>
				</div>
				<div id=profile>
				<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="300px" height="300px"><br>
				${optionDTO.introduce}<br><br><br><br>
				</div><br><br><br>
				<hr>
				<div id="neighbor">
				이웃
				
				<hr>
				</div>
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar1 div end -->
			</td>
			<td height="80px" width="60%">
			<div id="header">
			<h1>${optionDTO.headerword}</h1>
			<div align="right">
			<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그 관리</a>&nbsp;&nbsp;
			</div>
			</div>
			</td>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar2">
			<div id="sidebar2">
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar2 div end -->
			</td>
		</tr>
		<tr>
			<td height="500px" width="60%" align="center" class="header"background="resources/upload/${optionDTO.id}/${optionDTO.header}" >
			</td>
		</tr>
		<tr>
			<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			메인
			</div>
			</td>
		</tr>	
	</table>
	</c:if>
	<c:if test="${optionDTO.layout==6}">
	<table width="1900px" height="1900px">
		<tr>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar1">
			<div id="sidebar1">
				<div align="right">
				<a href="editBlog?mode=profile&id=${optionDTO.id}">프로필 관리</a>&nbsp;&nbsp;<br>
				</div>
				<div id=profile>
				<img src="resources/upload/${optionDTO.id}/${optionDTO.profile}" width="300px" height="300px"><br>
				${optionDTO.introduce}<br><br><br><br>
				</div><br><br><br>
				<hr>
				<div id="neighbor">
				이웃
				
				<hr>
				</div>
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar1 div end -->
			</td>
			<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			메인
			</div>
			</td>
			<td rowspan="3"  height="100%" width="20%" valign="top" align="center" class="sidebar2">
			<div id="sidebar2">
				<div id="board">
					<div align="right">
					<a href="makeBoard">게시판 만들기</a>&nbsp;&nbsp;<br>
					</div>
				</div>
			</div>  <!-- sidebar2 div end -->
			</td>
		</tr>
		<tr>
			<td height="80px" width="60%">
			<div id="header">
			<h1>${optionDTO.headerword}</h1>
			<div align="right">
			<a href="editBlog?mode=blog&id=${optionDTO.id}">블로그 관리</a>&nbsp;&nbsp;
			</div>
			</div>
			</td>
		</tr>
		<tr>
			<td height="500px" width="60%" align="center" class="header"background="resources/upload/${optionDTO.id}/${optionDTO.header}" >
			</td>
		</tr>	
	</table>
	</c:if>
</body>
</html>