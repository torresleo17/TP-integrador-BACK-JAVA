package clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PruebaAlumnoRDAO {

    public static void main(String[] args) {
        try (Connection conexion = new ConexionR().getConnection()) {
            AlumnoDAO alumnoDAO = new AlumnoDAO(conexion);

            List<Alumno> listaAlumnos = alumnoDAO.listarAlumnos();
            if (listaAlumnos != null) {
                for (Alumno alumno : listaAlumnos) {
                    System.out.println("ID: " + alumno.getId());
                    System.out.println("Nombres: " + alumno.getNombres());
                    System.out.println("Apellido: " + alumno.getApellido());
                    System.out.println("Fecha de Nacimiento: " + alumno.getFechaDeNacimiento());
                    System.out.println("DNI: " + alumno.getDni());
                    System.out.println("Sexo: " + alumno.getSexo());
                    System.out.println("Fecha de Ingreso: " + alumno.getFechaIngreso());
                    System.out.println("Email: " + alumno.getEmail());
                    System.out.println("Grado: " + alumno.getGrado());
                    System.out.println("Legajo: " + alumno.getLegajo());
                    System.out.println("-----------------------------");
                }
            } else {
                System.out.println("Error al obtener la lista de alumnos.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }
}


