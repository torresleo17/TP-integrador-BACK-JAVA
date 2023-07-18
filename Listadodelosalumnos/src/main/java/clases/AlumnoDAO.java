package clases;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private Connection conexion;

    public AlumnoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Alumno> listarAlumnos() {
        PreparedStatement ps;
        ResultSet rs;
        List<Alumno> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT * FROM alumnos");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombres = rs.getString("nombres");
                String apellido = rs.getString("apellido");
                LocalDate fechaDeNacimiento = rs.getDate("fechaDeNacimiento").toLocalDate();
                int dni = rs.getInt("dni");
                String sexo = rs.getString("sexo");
                LocalDate fechaIngreso = rs.getDate("fechaIngreso").toLocalDate();
                String email = rs.getString("email");
                String grado = rs.getString("grado");
                int legajo = rs.getInt("legajo");

                Alumno alumno = new Alumno(id, nombres, apellido, fechaDeNacimiento, dni, sexo, fechaIngreso, email, grado, legajo);
                lista.add(alumno);
            }

            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarAlumno(int id) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM alumnos WHERE id = ?");
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Alumno mostrarAlumno(int legajo) {
        PreparedStatement ps;
        ResultSet rs;
        Alumno alumno = null;

        try {
            ps = conexion.prepareStatement("SELECT * FROM alumnos WHERE legajo = ?");
            ps.setInt(1, legajo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombres = rs.getString("nombres");
                String apellido = rs.getString("apellido");
                LocalDate fechaDeNacimiento = rs.getDate("fechaDeNacimiento").toLocalDate();
                int dni = rs.getInt("dni");
                String sexo = rs.getString("sexo");
                LocalDate fechaIngreso = rs.getDate("fechaIngreso").toLocalDate();
                String email = rs.getString("email");
                String grado = rs.getString("grado");
                int _legajo = rs.getInt("legajo");

                alumno = new Alumno(id, nombres, apellido, fechaDeNacimiento, dni, sexo, fechaIngreso, email, grado, _legajo);
            }

            return alumno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertarAlumno(Alumno alumno) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO alumnos (nombres, apellido, fechaDeNacimiento, dni, sexo, fechaIngreso, email, grado, legajo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApellido());
            ps.setObject(3, alumno.getFechaDeNacimiento());
            ps.setInt(4, alumno.getDni());
            ps.setString(5, alumno.getSexo());
            ps.setObject(6, alumno.getFechaIngreso());
            ps.setString(7, alumno.getEmail());
            ps.setString(8, alumno.getGrado());
            ps.setInt(9, alumno.getLegajo());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
