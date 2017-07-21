<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
			<div id="sidebar">
				<h3>인기</h3>
				<ul>
				    <li>음악</li>
				    <li>스포츠</li>
				    <li>게임</li>
				    <li>영화</li>
				    <li>TV프로그램</li>
				    <li>뉴스</li>
				    <li>실시간</li>
				</ul>       
				<h4>내 정보</h4>
				<ul>
					<c:if test="${memberDTO!=null}">
						<li><a href="tftube_mychannel">내 채널</a></li>
						<li><a href="tftube_recentvideo_listRecent_member_no">최근 본 동영상</a></li>
						<li><a href="likeVideo_list">관심 동영상</a></li>
					</c:if>
				</ul>                        
			</div>
	        <div id="comments">
	            <h3>1</h3>
	            <p>
	                <span>1</span>
					123
	            </p>
	        </div>
	   
	    </div>
	    <div id="footer">
	    	youTube 언어:한국어 콘텐츠위치:한국 제한모드:사용안함 최근본동영상 도움말<br>
	    	정보/프레스/저작권/크리에이터/광고/개발자/+YouTube<br>
	    	이용약관/개인정보보호/정책 및 안전/의견 보내기/새로운 기능 테스트하기/2017YouTube.LLC
	    </div>
</body>
</html>