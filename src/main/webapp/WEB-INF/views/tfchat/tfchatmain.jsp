<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/resources/tfchat/header.jsp" %>
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
			
                 host = '192.168.52.35';
                 port = '3000';
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
	            	send();
	          	});
				
             	// 방만들기 버튼 클릭 시 처리
                $("#createRoomButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();
                    var roomName = $('#roomNameInput').val();
                    var id = $('#idInput').val();
                    var inviteId=$('inviteId').val();
                    
                    var output = {command:'create', roomId:roomId, roomName:roomName, roomOwner:id};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }
                    
                    var inviteinfo={command:'invite', roomId:roomId, inviteId:inviteId, roomOwner:id};

                    socket.emit('room', output);
                    socket.emit('invite', inviteinfo);
                });
             	//초대하기 버튼 클릭시
                $("#inviteButton").bind('click', function(event) {
                    var roomId = $('#roomIdInput').val();
                    var roomName = $('#roomNameInput').val();
                    var id = $('#idInput').val();
                    var inviteId=$('#inviteId').val();
                    var inviteRoom=$('#roomIdInput').val();
                    var inviteRoomOwner=$('#idInput').val();
                    
                    var output = {command:'create', roomId:roomId, roomName:roomName, roomOwner:id};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));
                    var inviteinfo={inviteId:inviteId, inviteRoom:inviteRoom, inviteRoomOwner:inviteRoomOwner};
                    console.log('서버로 보낼 데이터 : ' + JSON.stringify(inviteinfo));
                    if (socket == undefined) {
                        alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                        return;
                    }

                    socket.emit('room', output);
                    socket.emit('invite', inviteinfo);
                    $('#recepientInput').val(roomId);
                    
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
             	
                $('#dataInput').keypress(function(event){
        			var keycode = (event.keyCode ? event.keyCode : event.which);
        			if(keycode == '13'){
        				send();	
        			}
        			event.stopPropagation();
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
    	            	if(!('${sessionScope.memberDTO.id}'==message.sender)){
    	            		addToDiscussion('other', message.sender, message.data);
    	            	}
                    	
                    });
                    
                    socket.on('invite', function(data) {
                        console.log(JSON.stringify(data));
                        var roomId=data.inviteRoom;
                        println(roomId);
                        var output = {command:'join', roomId:roomId};
                        console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

                        if (socket == undefined) {
                            alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
                            return;
                        }
                        socket.emit('room', output);
                        $('#recepientInput').val(roomId);
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
                    // 현재 접속 아이디 받아오기
                    socket.on('currentId', function(data) {
                        console.log(JSON.stringify(data));

                        println('<p>접속자 이벤트 : ' + data.command + '</p>');
                        println('<p>접속자 리스트를 받았습니다.</p>');
                        if (data.command == 'list') { // 방 리스트
                        	var idCount = data.ids.length;
                        	$("#idList").html('<p>접속자 리스트 ' + idCount + '명</p>');
                        	for (var i = 0; i < idCount; i++) {
                        		$("#idList").append('<p>접속자 #' + i + ' : ' + data.ids[i]+'</p>');
                        	}
                        }
                    });

                });

                socket.on('disconnect', function() {
                    println('웹소켓 연결이 종료되었습니다.');
                });

            }
			
            function addToDiscussion(writer, sender, msg) {
    			println("addToDiscussion 호출됨 : " + writer + ", " + msg);
    			if(sender=='system'){
    				var contents = "<div align='center'><p>-------"+msg+"-------<p></div>";
    				println("추가할 HTML : " + contents);
       			    $(".discussion").append(contents);
    			}else{
    				var contents = "<li class='" + writer + "'>"
        			 + "  <div class='messages'>"
        			 +      sender + ": <br>"
          		 	 + "    <p>" + msg + "</p>"
        			 + "  </div>"
        			 + "  <div class='time'>"
        			 + "    <time datetime='2016-02-10 18:30'>18시 30분</time>"
        			+ "  </div>"
      			 	 + "</li>";
   			   	println("추가할 HTML : " + contents);
   			    $(".discussion").append(contents);
    			}
			    var maxScroll=document.getElementById('result').scrollHeight;
			    $("#result").scrollTop(maxScroll);
    		}
            
            function send(){
            	var sender = $('#senderInput').val();
            	var recepient = $('#recepientInput').val();
            	var data = $('#dataInput').val();

          		var output = {sender:sender, recepient:recepient, command:'groupchat', type:'text', data:data};
            	console.log('서버로 보낼 데이터 : ' + JSON.stringify(output));

           		if (socket == undefined) {
             		alert('서버에 연결되어 있지 않습니다. 먼저 서버에 연결하세요.');
           			return;
             	}

           		socket.emit('message', output);
           		
           		addToDiscussion('self', sender, data);
           		$('#dataInput').val('');
            }
            
			function println(data) {
				console.log(data);
				// $('#result').append('<p>' + data + '</p>');
			}
        </script>
	</head>
<body>
	<h3>현재 접속인원</h3>
	<input type="hidden" id="idInput" value="${sessionScope.memberDTO.id}" />
	<input type="hidden" id="roomIdInput" value="${sessionScope.memberDTO.id}" />
	<input type="hidden" id="roomNameInput" value="${sessionScope.memberDTO.id}" />
	<input type="hidden" id="senderInput" value="${sessionScope.memberDTO.id }" />
	<input type="hidden" id="chattype" value="groupchat">
	<input type="hidden" id="recepientInput"/>
	<div id="idresult">
    <div id="idList">
	</div>
		<input type="text" id="inviteId"/>
		<input type="button" id="inviteButton" value="초대하기"/>
	</div>
    <br>
        
    <div id="chatresult">
    <div class="ui segment" id="result">	
	  <ol class="discussion">
	  </ol>
	</div>
	<input type="text" id="dataInput"/>
    <input type="button" id="sendButton" value="전송" />
	</div>
    
        
</body>
</html>