package socketudp;

import java.io.Serializable;

public class Mensaje implements Serializable{
	int tipo;
	String texto;
	
	public Mensaje(int tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}
}
