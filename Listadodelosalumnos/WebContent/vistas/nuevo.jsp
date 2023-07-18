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
    <title>Nuevo Alumno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="text-center">Agregar Alumno</h1>

        <div class="row">
            <form class="p-5" action="AlumnosController?accion=insertar" method="post">

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>

                <div class="mb-3">
                    <label for="apellido" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>
                </div>

                <div class="mb-3">
                    <label for="fechaDeNacimiento" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" id="fechaDeNacimiento" name="fechaDeNacimiento" required>
                </div>

                <div class="mb-3">
                    <label for="dni" class="form-label">DNI</label>
                    <input type="number" class="form-control" id="dni" name="dni" required>
                </div>

                <div class="mb-3">
                    <label for="sexo" class="form-label">Sexo</label>
                    <input type="text" class="form-control" id="sexo" name="sexo" required>
                </div>

                <div class="mb-3">
                    <label for="fechaIngreso" class="form-label">Fecha de Ingreso</label>
                    <input type="date" class="form-control" id="fechaIngreso" name="fechaIngreso" required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>

                <div class="mb-3">
                    <label for="grado" class="form-label">Grado</label>
                    <input type="text" class="form-control" id="grado" name="grado" required>
                </div>

                <div class="mb-3">
                    <label for="legajo" class="form-label">Legajo</label>
                    <input type="number" class="form-control" id="legajo" name="legajo" required>
                </div>

                <button type="submit" class="btn btn-primary">Insertar</button>
            </form>
        </div>
    </div>
</body>
</html>

