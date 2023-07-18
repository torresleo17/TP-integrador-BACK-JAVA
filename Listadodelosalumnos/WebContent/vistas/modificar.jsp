<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="clases.AlumnoDAO" %>
<%@ page import="clases.Alumno" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="clases.ConexionR" %>
<%@ page import="clases.AlumnosController" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Alumno</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Modificar Alumnos</h1>

		<div class="row">
			
		<form class="p-5" action="" method="post">
			
			<div class="mb-3">				
				<input type="hidden" class="form-control" id="id" name="id" value="">
			</div>
			
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre</label>
				<input type="text" class="form-control" id="nombre" name="nombre" value="">
			</div>
			
			<div class="mb-3">
				<label for="apellido" class="form-label">Apellido</label>
				<input type="text" class="form-control" id="apellido" name="apellido" value="">
			</div>
			
			<div class="mb-3">
				<label for="apellido" class="form-label">DNI</label>
				<input type="number" class="form-control" id="dni" name="dni" value="">
			</div>
			
			<div class="mb-3">
				<label for="apellido" class="form-label">mail</label>
				<input type="text" class="form-control" id="mail" name="mail" value="">
			</div>
			
			<button type="submit" class="btn btn-primary">Modificar</button>
			
		</form>
		
		</div>	
	</div>
</body>
</html>
