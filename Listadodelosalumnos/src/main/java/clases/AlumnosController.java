package clases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AlumnosController")
public class AlumnosController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AlumnoDAO alumnoDAO;

    public AlumnosController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConexionR conexionR = new ConexionR();
            Connection conexion = conexionR.getConnection();
            alumnoDAO = new AlumnoDAO(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher = null;

        if (accion == null || accion.isEmpty()) {
            List<Alumno> alumnos = alumnoDAO.listarAlumnos();
            request.setAttribute("alumnos", alumnos);
            dispatcher = request.getRequestDispatcher("Alumnos.jsp");
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean eliminado = alumnoDAO.eliminarAlumno(id);
            if (eliminado) {
                request.setAttribute("mensaje", "Alumno eliminado correctamente");
            } else {
                request.setAttribute("mensaje", "Error al eliminar el alumno");
            }
            List<Alumno> alumnos = alumnoDAO.listarAlumnos();
            request.setAttribute("alumnos", alumnos);
            dispatcher = request.getRequestDispatcher("Alumnos.jsp");
        } else if (accion.equals("mostrar")) {
            int legajo = Integer.parseInt(request.getParameter("legajo"));
            Alumno alumno = alumnoDAO.mostrarAlumno(legajo);
            if (alumno != null) {
                request.setAttribute("alumno", alumno);
                dispatcher = request.getRequestDispatcher("MostrarAlumno.jsp");
            } else {
                request.setAttribute("mensaje", "No se encontró el alumno");
                List<Alumno> alumnos = alumnoDAO.listarAlumnos();
                request.setAttribute("alumnos", alumnos);
                dispatcher = request.getRequestDispatcher("Alumnos.jsp");
            }
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("nuevo.jsp");
        } else if (accion.equals("insertar")) {
            String nombres = request.getParameter("nombres");
            String apellido = request.getParameter("apellido");
            LocalDate fechaDeNacimiento = LocalDate.parse(request.getParameter("fechaDeNacimiento"));
            int dni = Integer.parseInt(request.getParameter("dni"));
            String sexo = request.getParameter("sexo");
            LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
            String email = request.getParameter("email");
            String grado = request.getParameter("grado");
            int legajo = Integer.parseInt(request.getParameter("legajo"));

            Alumno nuevoAlumno = new Alumno(nombres, apellido, fechaDeNacimiento, dni, sexo, fechaIngreso, email, grado, legajo);
            boolean insertado = alumnoDAO.insertarAlumno(nuevoAlumno);
            if (insertado) {
                request.setAttribute("mensaje", "Alumno agregado correctamente");
            } else {
                request.setAttribute("mensaje", "Error al agregar el alumno");
            }
            List<Alumno> alumnos = alumnoDAO.listarAlumnos();
            request.setAttribute("alumnos", alumnos);
            dispatcher = request.getRequestDispatcher("Alumnos.jsp");
        }

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
