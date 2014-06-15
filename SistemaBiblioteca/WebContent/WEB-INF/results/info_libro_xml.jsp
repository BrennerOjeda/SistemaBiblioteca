<?xml version="1.0" encoding="UTF-8"?>
<libro>
  <headings>
    <heading>Titulo</heading>
    <heading>Autores</heading>
    <heading>edicion</heading>
  </headings>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="datos" items="${datos_libro}">
  <datos>
    <titulo>${datos[0]}</titulo>
    <autores>${datos[1]}</autores>
    <edicion>${datos[2]}</edicion>
  </datos>
</c:forEach>
</libro>