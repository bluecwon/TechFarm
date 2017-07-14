<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>WebSocket chat client</title>
        <link rel="stylesheet" type="text/css" href="resources/tfchat/style.css" />
        <script type="text/javascript" src="resources/tfchat/chat.js"></script>
    </head>
    <body>
        <header>
            <h1>HTML5 WebSocket chat</h1>
        </header>
        <article>
            <label id="status-label">Status...</label>
            <input type="text" id="name-view" placeholder="Your name" />
            <input type="text" id="text-view" placeholder="Type your message..." />
            <input type="button" id="send-button" value="Send!" />
            <div class="clear"></div>
            <div id="chat-area"></div>
            <input type="button" id="stop-button" value="Disconnect" />
        </article>
        <footer></footer>
    </body>
</html>