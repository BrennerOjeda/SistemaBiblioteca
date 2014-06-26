<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ayuda</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.countdown.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/wsclient.js?2032"></script>
	
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.countdown.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.css?123" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/smoothness/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
    
    <link rel="stylesheet" type="text/css" href="css/estilos.css"> 
<script src="./js/ajax-utils.js"
        type="text/javascript"></script>
<script src="./js/ajax-data.js"
        type="text/javascript"></script>
</head>
<body>
 <jsp:include page="header.jsp" flush="true" />

<div class="container container-body">
	<fieldset>
	    <legend>Atención online</legend>
		    
			    <div class="leftPanel">
			        <div class="userInfo">
			            <span class="disconnected" id="status">Desconectado</span>
			            Usuario: <input type="text" id="userName"/><span class="onLineUserName"></span>
			        </div>
			        
			        <div>
			        	<br></br>
			            <button id="connect" class="btn btn-primary" onclick="wsclient.connect(document.getElementById('userName').value);">Conectar</button>
			            <button id="disconnect" class="btn btn-primary" disabled="disabled" onclick="wsclient.disconnect();">Desconectar</button> 
			        </div>
			        
			        <div id="onLineUsersPanel">
			            <h4>Usuarios conectados:</h4>
			            <ul id="onlineUsers">
			            </ul>
			        </div>
			    </div>
	
		
			    <div id="conversations">
			        <ul>
			        </ul>
			    </div>
				    
    	</fieldset>
</div>
<script type="text/javascript">
    $(function(){
        $('#conversations').tabs();
    });
</script>
</body>
</html>