package socketudp;

import java.net.InetAddress;

public class Direccion {

	InetAddress IPAddress;
	int puerto;
	
	public Direccion(InetAddress iPAddress, int puerto) {
		IPAddress = iPAddress;
		this.puerto = puerto;
	}
}
