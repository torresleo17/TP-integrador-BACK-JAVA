package clases;

import java.time.LocalDate;

public class ProfesoresR extends PersonaR {
    private int legajo;
    private LocalDate fechaIngreso;
    private String email;
    private String asignatura;
    private String turnosAsignados;
    
    // Constructor
    public ProfesoresR(int idPersona, String nombres, String apellido, LocalDate fechaDeNacimiento, int dNI, String sexo,
            int legajo, LocalDate fechaIngreso, String email, String asignatura, String turnosAsignados) {
        super(idPersona, nombres, apellido, fechaDeNacimiento, dNI, sexo);
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.asignatura = asignatura;
        this.turnosAsignados = turnosAsignados;
    }
    
    // Getters y setters
    public int getLegajo() {
        return legajo;
    }
    
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAsignatura() {
        return asignatura;
    }
    
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    public String getTurnosAsignados() {
        return turnosAsignados;
    }
    
    public void setTurnosAsignados(String turnosAsignados) {
        this.turnosAsignados = turnosAsignados;
    }
}

