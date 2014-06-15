var url;

url = "http://localhost:8080/SistemaBiblioteca/controlador?";
function validarUsuario(){
	var u = document.getElementById("dni").value;
	var p = document.getElementById("password").value;
	
	url += "login="+u;
	url += "&password="+p;
	url += "&id="+Math.random();
	//alert(url);
	if(u == "" || p == ""){
		alert("¡Error existen campos vacios!");
	}
	else{
		location.assign(url);
		alert(url);
	}
}