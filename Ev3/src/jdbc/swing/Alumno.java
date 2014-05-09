package jdbc.swing;

import java.util.Date;

public class Alumno {
	
	String dni;//si no tiene dni no se crea
	String nombre;
	String dniTutor;//select a la otra tabla para ligar el tutor
	Date nacimiento;

	

	public Alumno(String dni, String nombre, String dniTutor) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.dniTutor = dniTutor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDniTutor() {
		return dniTutor;
	}

	public void setDniTutor(String dniTutor) {
		this.dniTutor = dniTutor;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", dniTutor="
				+ dniTutor + "]";
	}
	
	
}
