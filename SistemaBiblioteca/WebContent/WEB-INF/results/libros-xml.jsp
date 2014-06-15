<?xml version="1.0" encoding="UTF-8"?>
<libros>
  <headings>
    <heading>Codigo</heading>
    <heading>Titulo</heading>
    <heading>Autor</heading>
    <heading>Edicion</heading>
    <heading>Disponibilidad</heading>
  </headings>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="libro" items="${lista_libros}">
  <libro>
    <codigo>${libro.get(0)}</codigo>
    <titulo>${libro.get(1)}</titulo>
    <autor>${libro.get(2)}</autor>
    <edicion>${libro.get(3)}</edicion>
    <disponible>${libro.get(4)}</disponible>
  </libro>
</c:forEach>
</libros>