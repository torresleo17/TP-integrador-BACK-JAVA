package clases;

import java.time.LocalDate;

public abstract class PersonaR {
    private int idPersona;
    private String nombres;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private int dNI;
    private String sexo;
    
    // Constructor
    public PersonaR(int idPersona, String nombres, String apellido, LocalDate fechaDeNacimiento, int dNI, String sexo) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.dNI = dNI;
        this.sexo = sexo;
    }
    
    // Getters y setters
    public int getIdPersona() {
        return idPersona;
    }
    
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public int getDNI() {
        return dNI;
    }
    
    public void setDNI(int dNI) {
        this.dNI = dNI;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

