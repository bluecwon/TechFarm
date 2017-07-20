<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<td height="700px" width="60%" valign="top" align="center">
			<hr width="95%">
			<div id="boardList">
			<div align="left">
				<h2>${title}</h2><br>
			</div>
					<table class="viewBoard"  width="100%">
						<tr>
							<td width="10%" align="center" id="view">제목</td>
							<td width="70%" class="view" id="view">${boardDTO.subject}</td>
							<td width="20%" class="view" align="center" id="view">${optionDTO.nickname}(${optionDTO.id})</td>
						</tr>
						<c:if test="${boardDTO.file1 != ''}">
						<tr>
							<td width="100%" colspan="3" align="center"><a href="fileDownload?fil1=${boardDTO.file1}">${boardDTO.file1}</a>
						</tr>
						</c:if>
						<tr>
							<td width="100%" height="500" colspan="3" valign="top" id="view">${boardDTO.content}</td>
						</tr>
						<tr>
							<td colspan="3" align="right" id="view"> 
							<a href="listBoard?title=${title}&boardno=${boardDTO.boardno}">목록</a>&nbsp;&nbsp;
							<a href="updateBoard?title=${title}&no=${boardDTO.no}">수정</a>&nbsp;&nbsp;
							<a href="javascript:checkDelBoard('${boardDTO.no}');">삭제</a>&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td width="10%" align="center">댓글</td> 
							<c:choose>
							<c:when test="${membermode=='guest'}">
							<td width="70%"><input type="text" name="replycontent" disabled></td>
							</c:when>
							<c:otherwise>
							<td width="70%"><input type="text" name="replycontent" ></td>
							</c:otherwise>
							</c:choose>
							<td width="20%" align="center">등록</td>
						</tr>
						<tr>
							<td colspan="3">
							
							
							<div class="div_add">
										<div class="meta">
											<div class="comments"><a href="javascript:;">댓글 보기</a></div>
											<div class="user">작성자 : ${dto.profileBoardId}</div>
										</div>
										
										<!-- 댓글 -->
										<table class="jjm494_add">
											<c:set var="ch" value="0"/>
											<c:forEach var="dto" items="${newsAddList}">
												<c:choose>
													<c:when test="${dto.profileBoardFK == profileBoardNum}">
													<c:set var="ch" value="1"/>
														<tr>
															<th scope="row">
																<c:set var="addCheck" value="0"/>
																<c:forEach var="addDto" items="${myProfileAllList}">
																	<c:if test="${dto.profileAddId == addDto.myId}">
																		<c:if test="${dto.re_level > 0}">
																		<c:forEach begin="1" end="${dto.re_level}">
																			..
																		</c:forEach>
																		</c:if>
																		<img id="img_size" src="${myProfileUpPath}/${addDto.photo}" style="width:50px; height:25px;"/>
																		<c:set var="addCheck" value="1"/>
																	</c:if>
																</c:forEach>
																<c:if test="${addCheck==0}">
																	<img src="resources/tfPlus/images/default/basicImg.JPG" style="width:50px; height:25px;">
																</c:if>
																${dto.profileAddName}
																<c:if test="${dto.profileAddId == sessionScope.memberDTO.id}"> <!--로그인아이디와 댓글주인이 같으면 댓글 삭제가능 -->
																	<a href="tfPlusNewsAddDelete?addPK=${dto.profileAddPK}&profileName=${newsBoardName}&id=${newsprofileId}&my=${my}&myId=${sessionScope.memberDTO.id}">삭제</a>
																</c:if>
															</th>
															<td>
																<div class="subMenuDiv_add">
																	${dto.profileAddContents}
																	<a href="javascript:;">답글</a>
																	<form name="f" action="tfPlusNewsProfileAddPro" method="post">
																		<table class="jjm494_subAdd">
																			<tr>
																				<th scope="row">
																		        	<c:if test="${myProfileDTO != null}">
																		        		<img id="img_size" src="${myProfileUpPath}/${myProfileDTO.photo}" style="width:25px; height:15px;"/>
																		        	</c:if>
																		        	<c:if test="${myProfileDTO == null}">
																		        		<img src="resources/tfPlus/images/default/basicImg.JPG" style="width:25px; height:15px;">
																		        	</c:if>
																					<spen style="font-size:10px">${sessionScope.memberDTO.name}</spen>
																				</th>
																				<td>
																					<input name="profileAddContents" type="text" class="form-poshytip" title="내용을 입력하세요" style="background-color:#e2e2e2;"/>
																					<input type="submit" value="등록">
																					<!-- 히든으로 넘어갈 정보들 -->
																						<input type="hidden" value="${sessionScope.memberDTO.id}" name="profileAddId" id="to" />
																						<input type="hidden" value="${sessionScope.memberDTO.name}" name="profileBoardName" id="to" />
																						<input type="hidden" value="${profileBoardNum}" name="profileBoardFK" id="to" />
																						
																						<input type="hidden" value="${newsBoardName}" name="profileName" id="to" />
																						<input type="hidden" value="${newsprofileId}" name="id" id="to" />
																						<input type="hidden" value="${num}" name="num" id="to" />
																						<input type="hidden" value="${my}" name="my" id="to" />
																						
																						<input type="hidden" value="${dto.profileAddPK}" name="profileAddPK" id="to"/>
																						<input type="hidden" value="${dto.re_step}" name="re_step" id="to"/>
																						<input type="hidden" value="${dto.re_level}" name="re_level" id="to"/>
																					<!-- 히든으로 넘어갈 정보들 -->
																				</td>
																			</tr>
																		</table>
																	</form>
																</div>
															</td>
														</tr>
													</c:when>
												</c:choose>
											</c:forEach>
											<c:if test="${ch != 1}">
												<tr>
													<th></th>
													<td>등록된 댓글이 하나도 없습니다.</td>
												</tr>
											</c:if>
										</table>
										
										<form name="f" action="tfPlusNewsProfileAddPro" method="post">
											<table class="jjm494_add">
											    <tr>
											        <th scope="row">
											        	<c:if test="${myProfileDTO != null}">
											        		<img id="img_size" src="${myProfileUpPath}/${myProfileDTO.photo}" style="width:50px; height:25px;"/>
											        	</c:if>
											        	<c:if test="${myProfileDTO == null}">
											        		<img src="resources/tfPlus/images/default/basicImg.JPG" style="width:50px; height:25px;">
											        	</c:if>
											        	${sessionScope.memberDTO.name}
											        </th>
											        <td>
											        	<input name="profileAddContents" type="text" class="form-poshytip" title="내용을 입력하세요." style="background-color:#e2e2e2;"/>
											        	<input type="submit" value="등록"/>
														<!-- 히든으로 넘어갈 정보들 -->
															<input type="hidden" value="${sessionScope.memberDTO.id}" name="profileAddId" id="to" />
															<input type="hidden" value="${sessionScope.memberDTO.name}" name="profileBoardName" id="to" />
															<input type="hidden" value="${profileBoardNum}" name="profileBoardFK" id="to" />
															
															<input type="hidden" value="${newsBoardName}" name="profileName" id="to" />
															<input type="hidden" value="${newsprofileId}" name="id" id="to" />
															<input type="hidden" value="${num}" name="num" id="to" />
															<input type="hidden" value="${my}" name="my" id="to" />
															
															<input type="hidden" value="0" name="re_step" id="to"/>
															<input type="hidden" value="0" name="re_level" id="to"/>
														<!-- 히든으로 넘어갈 정보들 -->
													</td>
											    </tr>
											</table>
										</form>
										<!-- 댓글 끝 -->
										
									</div>
							
							
							
							
							</td>
						</tr>
					</table>			
			</div>
</td>	