<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="clases.AlumnoDAO" %>
<%@ page import="clases.Alumno" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="clases.ConexionR" %>
<%@ page import="clases.AlumnosController" %>

<%
    Connection conexion = null;
    try {
        conexion = new ConexionR().getConnection();
        AlumnoDAO alumnoDAO = new AlumnoDAO(conexion);
        List<Alumno> alumnos = alumnoDAO.listarAlumnos();
        if (alumnos != null && !alumnos.isEmpty()) {
            request.setAttribute("alumnos", alumnos);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Alumnos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        .text-center {
            text-align: center;
        }
        .btn {
            padding: 5px 10px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
        }
        .btn-info {
            background-color: #3498db;
        }
        .btn-danger {
            background-color: #e74c3c;
        }
    </style>
    <script>
        function confirmarEliminacion(id) {
            var respuesta = confirm("¿Estás seguro de que deseas eliminar este alumno?");
            if (respuesta) {
                window.location.href = "AlumnosController?accion=eliminar&id=" + id;
            }
        }
    </script>
</head>
<body>
    <h1 class="text-center">Listado de Alumnos</h1>
    <div class="container">
        <div class="row">
            <a class="btn btn-primary col-4 m-4" href="nuevo.jsp">Agregar Alumno</a>
        </div>

        <table class="table table-primary">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellido</th>
                    <th>Fecha de Nacimiento</th>
                    <th>DNI</th>
                    <th>Sexo</th>
                    <th>Fecha de Ingreso</th>
                    <th>Email</th>
                    <th>Grado</th>
                    <th>Legajo</th>
                    <th class="text-center">Modificar</th>
                    <th class="text-center">Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");

                
                    for (Alumno alumno : alumnos) {
                        String rutaM = "modificar.jsp?id=" + alumno.getId();
                        String rutaE = "javascript:void(0);";
                %>
                <tr>
                    <td><%= alumno.getId() %></td>
                    <td><%= alumno.getNombres() %></td>
                    <td><%= alumno.getApellido() %></td>
                    <td><%= alumno.getFechaDeNacimiento() %></td>
                    <td><%= alumno.getDni() %></td>
                    <td><%= alumno.getSexo() %></td>
                    <td><%= alumno.getFechaIngreso() %></td>
                    <td><%= alumno.getEmail() %></td>
                    <td><%= alumno.getGrado() %></td>
                    <td><%= alumno.getLegajo() %></td>
                    <td class="text-center"><a href="<%= rutaM %>"><i class="fas fa-arrow-right btn btn-info"></i></a></td>
                    <td class="text-center"><a href="#" onclick="confirmarEliminacion('<%= alumno.getId() %>')"><i class="fas fa-trash btn btn-danger"></i></a></td>
                </tr>
                <% 
                    }
                
                %>
                <tr>
                    <td colspan="12">No se encontraron alumnos.</td>
                </tr>
                <% 
                    
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
