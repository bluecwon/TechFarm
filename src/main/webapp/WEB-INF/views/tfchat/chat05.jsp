<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TF chat</title>
		
		<script src="resources/js/jquery-3.1.1.min.js"></script>     
		<script src="resources/js/socket.io.js"></script>
        
        <script>
            var host;
            var port;
            var socket;
            
         	// 문서 로딩 후 실행됨
            $(function() {
			
                 host = $('#hostInput').val();
                 port = $('#portInput').val();
                 connectToServer();
                 
                 var id = $('#idInput').val();
                 var output = {id:id};
                 console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));
                 if (socket == undefined) {
                     alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                     return;
                 }
                 socket.emit('login', output);

				// 전송 버튼 클릭 시 처리
                $("#sendButton").bind('click', function(event) {
                	
                	// chattype 구분
                	var chattype = $('#chattype option:selected').val();

                	var sender = $('#senderInput').val();
                    var recepient = $('#recepientInput').val();
                    var data = $('#dataInput').val();

                    var output = {sender:sender, recepient:recepient, command:chattype, type:'text', data:data};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));
                	
                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('message', output);
                });
				
             	// 방만들기 버튼 클릭 시 처리
                $("#createRoomButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();
                    var roomName = $('#roomNameInput').val();
                    var id = $('#idInput').val();
                    
                    var output = {command:'create', roomId:roomId, roomName:roomName, roomOwner:id};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('room', output);
                });
             	
             	// 방이름바꾸기 버튼 클릭 시 처리
                $("#updateRoomButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();
                    var roomName = $('#roomNameInput').val();
                    var id = $('#idInput').val();
                    
                    var output = {command:'update', roomId:roomId, roomName:roomName, roomOwner:id};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('room', output);
                });

             	// 방없애기 버튼 클릭 시 처리
                $("#deleteRoomButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();
                    
                    var output = {command:'delete', roomId:roomId};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('room', output);
                });

             	// 방입장하기 버튼 클릭 시 처리
                $("#joinRoomButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();

                    var output = {command:'join', roomId:roomId};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('room', output);
                });
             	
             	// 방나가기 버튼 클릭 시 처리
                $("#leaveRoomButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();

                    var output = {command:'leave', roomId:roomId};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('room', output);
                });
             	
            });
            
			// 서버에 연결하는 함수 정의
            function connectToServer() {

                var options = {'forceNew':true};
                var url = 'http://' + host + ':' + port;
                socket = io.connect(url, options);

                socket.on('connect', function() {
                	println('웹소켓 서버에 연결되었습니다. : ' + url);

                    socket.on('message', function(message) {
                        console.log(JSON.stringify(message));

                        println('<p>수신 메시지 : ' + message.sender + ', ' + message.recepient + ', ' + message.command + ', ' + message.data + '</p>');
                    });

                    socket.on('response', function(response) {
                    	console.log(JSON.stringify(response));
                    	println('응답 메시지를 받았습니다. : ' + response.command + ', ' + response.code + ', ' + response.message);
                    });

                    // 그룹 채팅에서 방과 관련된 이벤트 처리
                    socket.on('room', function(data) {
                        console.log(JSON.stringify(data));

                        println('<p>방 이벤트 : ' + data.command + '</p>');
                        println('<p>방 리스트를 받았습니다.</p>');
                        if (data.command == 'list') { // 방 리스트
                        	var roomCount = data.rooms.length;
                        	$("#roomList").html('<p>방 리스트 ' + roomCount + '개</p>');
                        	for (var i = 0; i < roomCount; i++) {
                        		$("#roomList").append('<p>방 #' + i + ' : ' + data.rooms[i].id + ', ' + data.rooms[i].name + ', ' + data.rooms[i].owner + '</p>');
                        	}
                        }
                    });

                });

                socket.on('disconnect', function() {
                    println('웹소켓 연결이 종료되었습니다.');
                });

            }
            
			function println(data) {
				console.log(data);
				$('#result').append('<p>' + data + '</p>');
			}
        </script>
	</head>
<body>
	<h3>채팅 클라이언트 05 : 그룹 채팅하기</h3>
	<br>
    <div>
        <input type="hidden" id="hostInput" value="52.79.140.54" />
        <input type="hidden" id="portInput" value="3000" />
    </div>
    <br>
    <div>
		<input type="hidden" id="idInput" value="${sessionScope.memberDTO.id}" />
	</div>
    <br>
    <div>
		<input type="text" id="roomIdInput" value="meeting01" />
		<input type="text" id="roomNameInput" value="청춘들의대화" />

		<input type="button" id="createRoomButton" value="방만들기" />
		<input type="button" id="updateRoomButton" value="방이름바꾸기" />
		<input type="button" id="deleteRoomButton" value="방없애기" />
	</div>
	<br>
	<div id="roomList">
		
	</div>
    <br>
    <div>
		<input type="button" id="joinRoomButton" value="방입장하기" />
		<input type="button" id="leaveRoomButton" value="방나가기" />
	</div>
	<br>
    <div>
    	<div><span>보내는사람 아이디 :</span> <input type="text" id="senderInput" value="test01" /></div>
	    <div><span>받는사람 아이디 :</span> <input type="text" id="recepientInput" value="ALL" /></div>

	    <!-- command 선택 <select> 채팅, 그룹채팅 -->
	    <select name="chattype" id="chattype">
			<option value="chat">채팅</option>
			<option value="groupchat" selected>그룹채팅</option>
		</select>

	    <div><span>메시지 데이터 :</span> <input type="text" id="dataInput" value="안녕!"/> </div>
		<br>
		<input type="button" id="sendButton" value="전송" />
	</div>    
        
    <hr/>
    <p>결과 : </p>
    <div id="result"></div>
        
</body>
</html>