package jdbc.swing;

import java.util.Date;

public class Alumno {
	
	String dni;
	String nombre;
	String dniTutor;//select a la otra tabla para ligar el tutor
	Date nacimiento;

	//costruir alumno a partir de lo que devuelva el resultSet
	//omitir el date
	public Alumno consultaAlumno(String dni,Connection conexion)
	{
		//preparar sentencia, hacer select
		//rs= select * from alumno where dni=?
		//if( rs.next())
		//{
			//cargar el objeto
		//}
		//else return null;
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
	
	
}
