package clases;

import java.time.LocalDate;

public class Alumno {
    private int id;
    private String nombres;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private int dni;
    private String sexo;
    private LocalDate fechaIngreso;
    private String email;
    private String grado;
    private int legajo;

    public Alumno(int id,String nombres, String apellido, LocalDate fechaDeNacimiento, int dni, String sexo, LocalDate fechaIngreso, String email, String grado, int legajo) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.dni = dni;
        this.sexo = sexo;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.grado = grado;
        this.legajo = legajo;
    }

    
	public Alumno(String nombres2, String apellido2, LocalDate fechaDeNacimiento2, int dni2, String sexo2,
			LocalDate fechaIngreso2, String email2, String grado2, int legajo2) {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
}

