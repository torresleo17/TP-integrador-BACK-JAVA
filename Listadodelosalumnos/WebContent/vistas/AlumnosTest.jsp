<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="clases.AlumnosController" %>
<%@ page import="clases.AlumnoDAO" %>
<%@ page import="clases.ConexionR" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="clases.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prueba de Alumnos</title>
</head>
<body>
    <h1>Prueba de Alumnos</h1>

    <%-- Crear una instancia de ConexionR y obtener la conexión --%>
    <%
        ConexionR conexionR = new ConexionR();
        Connection conexion = null;
        try {
            conexion = conexionR.getConnection();
            out.println("Conexión establecida correctamente");
        } catch (SQLException e) {
            out.println("Error al establecer la conexión: " + e.getMessage());
        }
    %>

    <%-- Crear una instancia de AlumnoDAO pasando la conexión --%>
    <%
        AlumnoDAO alumnoDAO = new AlumnoDAO(conexion);
    %>

    <%-- Listar los alumnos --%>
    <%
        List<Alumno> alumnos = alumnoDAO.listarAlumnos();
    %>

    <h2>Lista de Alumnos:</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
            <% for (Alumno alumno : alumnos) { %>
                <tr>
                    <td><%= alumno.getId() %></td>
                    <td><%= alumno.getNombres() %></td>
                    <td><%= alumno.getApellido() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <%-- Cerrar la conexión --%>
    <% conexion.close(); %>
</body>
</html>
