package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AlumnosControllerTest {
    public static void main(String[] args) {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");

            // Crear una instancia de AlumnoDAO
            AlumnoDAO alumnoDAO = new AlumnoDAO(conexion);

            // Ejecutar métodos de prueba
            listarAlumnosTest(alumnoDAO);
            mostrarAlumnoTest(alumnoDAO);
            eliminarAlumnoTest(alumnoDAO);
            insertarAlumnoTest(alumnoDAO);

            // Cerrar la conexión
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarAlumnosTest(AlumnoDAO alumnoDAO) {
        System.out.println("=== Listar Alumnos ===");
        List<Alumno> alumnos = alumnoDAO.listarAlumnos();
        if (alumnos != null && !alumnos.isEmpty()) {
            for (Alumno alumno : alumnos) {
                System.out.println(alumno.getId() +" "+alumno.getNombres()+" "+ alumno.getApellido()+" "+alumno.getLegajo());
            }
        } else {
            System.out.println("No se encontraron alumnos.");
        }
        System.out.println("======================");
    }

    public static void mostrarAlumnoTest(AlumnoDAO alumnoDAO) {
        System.out.println("=== Mostrar Alumno ===");
        int legajo = 1001; // Reemplazar con un legajo válido
        Alumno alumno = alumnoDAO.mostrarAlumno(legajo);
        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("No se encontró el alumno.");
        }
        System.out.println("======================");
    }

    public static void eliminarAlumnoTest(AlumnoDAO alumnoDAO) {
        System.out.println("=== Eliminar Alumno ===");
        int id = 14; // Reemplazar con un ID válido
        boolean eliminado = alumnoDAO.eliminarAlumno(id);
        if (eliminado) {
            System.out.println("Alumno eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el alumno.");
        }
        System.out.println("=======================");
    }

    public static void insertarAlumnoTest(AlumnoDAO alumnoDAO) {
        System.out.println("=== Insertar Alumno ===");
        // Crear un objeto Alumno con los datos necesarios
        Alumno alumno = new Alumno(0, "pepe", "pepe", LocalDate.of(2020, 6, 1), 387765890, "F", LocalDate.of(2021, 4, 4), "pepe@gmail.com", "5t", 9898767);

        boolean insertado = alumnoDAO.insertarAlumno(alumno);
        if (insertado) {
            System.out.println("Alumno agregado correctamente.");
        } else {
            System.out.println("Error al agregar el alumno.");
        }
        System.out.println("=======================");
    }

}
