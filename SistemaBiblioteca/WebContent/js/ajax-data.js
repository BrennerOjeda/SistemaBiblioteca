// Build a table from purely client-side information.
// To test the getTable function.

function clientTable(displayRegion) {
  var headings = ["Quarter", "Apples", "Oranges"];
  var rows = [["Q1", randomSales(), randomSales()],
              ["Q2", randomSales(), randomSales()],
              ["Q3", randomSales(), randomSales()],
              ["Q4", randomSales(), randomSales()]];
  var table = getTable(headings, rows);
  htmlInsert(displayRegion, table);
}

function randomSales() {
  var sales = 1000 + (Math.round(Math.random() * 9000));
  return("$" + sales);
}

// See combined version at end that can handle
// any of XML, JSON, or String data.

function xmlCityTable(inputField, resultRegion) {
  var address = "show-cities";
  var data = "cityType=" + getValue(inputField) +
             "&format=xml";
  ajaxPost(address, data, 
           function(request) { 
             showXmlCityInfo(request, resultRegion); 
           });
}

function showXmlCityInfo(request, resultRegion) {
	console.log("en showXmlCityInfo");
  if ((request.readyState == 4) &&
      (request.status == 200)) {
	console.log("en showXmlCityInfo Adentro");
	console.log(resultRegion);
	if(resultRegion == "tabla-libro"){
	    var xmlDocument = request.responseXML;
	    console.log("xmlDocument"+xmlDocument);
	    var headings = getXmlValues(xmlDocument, "heading");
	    console.log(headings);
	    var cities = xmlDocument.getElementsByTagName("libro");
	    var rows = new Array(cities.length);
	    var subElementNames = ["codigo", "titulo", "autor","edicion","disponible"];
	    for(var i=0; i<cities.length; i++) {
	      rows[i] = 
	        getElementValues(cities[i], subElementNames);
	    }
	    var table = getTable(headings, rows);
	    htmlInsert(resultRegion, table);
	}
	else if(resultRegion == "tabla-usuario"){
		 var xmlDocument = request.responseXML;
		 console.log("xmlDocument"+xmlDocument);
		 var headings = getXmlValues(xmlDocument, "heading");
		 console.log(headings);
		 var cities = xmlDocument.getElementsByTagName("usuario");
		 var rows = new Array(cities.length);
		 var subElementNames = ["codigo", "nombre", "telefono","email","estado"];
		 for(var i=0; i<cities.length; i++) {
		    rows[i] = 
		      getElementValues(cities[i], subElementNames);
		 }
		 var table = getTable(headings, rows);
		 htmlInsert(resultRegion, table);
	}
  }
}

function jsonCityTable(inputField, resultRegion) {
  var address = "show-cities";
  var data = "cityType=" + getValue(inputField) +
             "&format=json";
  ajaxPost(address, data, 
           function(request) { 
             showJsonCityInfo(request, resultRegion); 
           });
}

function showJsonCityInfo(request, resultRegion) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    var rawData = request.responseText;
    var data = eval("(" + rawData + ")");
    var table = getTable(data.headings, data.cities);
    htmlInsert(resultRegion, table);
  }
}

function stringCityTable(inputField, resultRegion) {
  var address = "show-cities";
  var data = "cityType=" + getValue(inputField) +
             "&format=string";
  ajaxPost(address, data, 
           function(request) { 
             showStringCityInfo(request, resultRegion); 
           });
}

function showStringCityInfo(request, resultRegion) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    var rawData = request.responseText;
    var rowStrings = rawData.split(/[\n\r]+/);
    var headings = rowStrings[0].split("#");
    var rows = new Array(rowStrings.length-1);
    for(var i=1; i<rowStrings.length; i++) {
      rows[i-1] = rowStrings[i].split("#");
    }
    var table = getTable(headings, rows);
    htmlInsert(resultRegion, table);
  }
}


function infoTabla(resultRegion) {
	  var address = "";
	  console.log("en el metodo cityTBLE");
	  var format = "xml";
	  var data = "format=xml";
	  // Dependiendo que vamos a insertar en la interfaz elegimos un servlet
	  if (resultRegion == "tabla-libro"){
		  address = "Controlador_libros";
	  }
	  else if(resultRegion == "tabla-usuario"){
		  address = "Controlador_usuarios";
	  }
	  var responseHandler = findHandler(format); // traducir el formato del archivo
	  ajaxPost(address, data, 
	           function(request) { 
	             responseHandler(request, resultRegion); 
	           });
	}

// Reminder: unlike in Java, in JavaScript it is OK to 
// use == to compare strings.

function findHandler(format) {
  if (format == "xml") {
    return(showXmlCityInfo);
  } else if (format == "json") {
    return(showJsonCityInfo);
  } else {
    return(showStringCityInfo);
  }
}