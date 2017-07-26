<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<meta charset="UTF-8">
<%@ include file="header.jsp"%>
<section>
	<article>
	<table>
		<tr>
			<td valign="top" align="center"><h2>${areamode}게시판</h2></td>
			<td class="tdspace" align="center">
				<table class="topbox" width="900px"  height="500px">
					<tr>
					<th class="top" height="70px"><h2>프로필</h2></th>
					<th class="top" ><h2>작성자</h2></th>
					<th class="top" ><h2>글제목</h2></th>
					<th class="top" ><h2>게시판</h2></th>
					</tr>	
					<c:forEach var="arealist" items="${arealist}" varStatus="status">
					<tr>
					<th class="top"><img src="resources/upload/${arealist.id}/${areaprofile[status.index]}" width="60" height="60" class="homemenu"/></th>
					<th class="top">${arealist.id}</th>
					<th class="top"><a href="viewBoard?no=${arealist.no}" class="deconone">${arealist.subject}</a></th>
					<th class="top">(${arealist.title})게시판</th>
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	</article>  
</section>
<%@ include file="aside.jsp"%>
<%@ include file="footer.jsp"%>