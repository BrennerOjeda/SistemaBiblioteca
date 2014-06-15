<?xml version="1.0" encoding="UTF-8"?>
<usuarios>
  <headings>
    <heading>Codigo</heading>
    <heading>Nombre</heading>
    <heading>Telefono</heading>
    <heading>Email</heading>
    <heading>Estado</heading>
  </headings>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="usuario" items="${lista_usuarios}">
  <usuario>
    <codigo>${usuario.get(0)}</codigo>
    <nombre>${usuario.get(1)}</nombre>
    <telefono>${usuario.get(2)}</telefono>
    <email>${usuario.get(3)}</email>
    <estado>${usuario.get(4)}</estado>
  </usuario>
</c:forEach>
</usuarios>