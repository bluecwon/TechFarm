<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<!-- 상단 부분 -->
<!--content -->
	<div id="content">

		    
		<table class="jjm494">		
			<c:if test="${noteList.size()==0}">
				<tr>
					<td>
						작성된 노트가 하나도 없습니다.
					</td>
					<th scope="row" align="center">
						<a href="note_insert">
							<img src="resources/tfNote/plus.jpg" style="width:100px; height:50px;">
						</a>
					</th>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${noteList}">	
				<tr>
					<th scope="row">
						<a href="note_content?num=${dto.num}">
							제목 : ${dto.title}
						</a>
					</th>
					<td>
						<a href="note_update?num=${dto.num}">수정</a>
						<a href="note_delete?num=${dto.num}&id=${dto.id}">삭제</a>
					</td>
				</tr>
			</c:forEach>	
		</table>


	</div>
<!--//content -->
<!-- 하단 부분 -->
<%@include file="../footer.jsp"%>
