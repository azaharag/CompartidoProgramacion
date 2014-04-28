package EscribirLeerObjetos;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	String nombre;
	int edad;
	
	public Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

}
