<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<td height="700px" width="60%" valign="top" align="center">
			<div id="main">
			<c:forEach var="myboardlist" items="${myboardlist}">
			<br><br>
			<table border="1">
				<tr>
					<th width="500">${myboardlist.subject}</th>
					<th width="300">${myboardlist.id}</th>
					<th width="200">${myboardlist.reg_date}</th>
				</tr>
				<tr>
					<td colspan="3">${myboardlist.content}</td>
				</tr>
			</table>
			</c:forEach>
			</div>
</td>		