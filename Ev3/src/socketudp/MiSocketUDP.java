package socketudp;

import java.net.DatagramSocket;
import java.net.SocketException;

public class MiSocketUDP extends DatagramSocket{
	
	public MiSocketUDP() throws SocketException {
		super();
	}

	public MiSocketUDP(int p) throws SocketException {
		super(p);
	}
	
	public void enviarMensaje(Object o, Direccion destino)
	{
		
	}

	public Object recibirMensaje(Direccion remitente, int timeout)
	{
		return null;
	}
}
