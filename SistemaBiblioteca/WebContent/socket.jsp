<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Subastas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.countdown.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/wsclient.js?2032"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/subastas.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.countdown.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/subastas.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/default.css?123" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/smoothness/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
</head>
<body>
<br/><br/><br/>
<hr/>
<div class="container container-body">
    <div class="leftPanel">
        <div class="userInfo">
            <span class="disconnected" id="status">Desconectado</span>
            Nombre: <input type="text" id="userName"/><span class="onLineUserName"></span>
        </div>
        <div>
        	<br></br>
            <button id="connect" class="btn btn-primary" onclick="wsclient.connect(document.getElementById('userName').value);">Conectar</button>
            <button id="disconnect" class="btn btn-primary" disabled="disabled" onclick="wsclient.disconnect();">Desconectar</button>
        </div>
        <div id="onLineUsersPanel">
            <h3>Usuarios conectados:</h3>
            <ul id="onlineUsers">
            </ul>
        </div>
    </div>

    <div id="conversations">
        <ul>
        </ul>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#conversations').tabs();
    });
</script>
</body>
</html>