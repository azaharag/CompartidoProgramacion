package flujoEntradaSalida;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class EscribirDatos2 {

	public static void main(String[] args) throws IOException {
		char c='A';
		int n=8;
		double d=7.15;
		String t="HOLA",t2="ADIOS";
		DataOutputStream out=new DataOutputStream (new FileOutputStream("c:/datos.txt"));
		out.writeChar(c);
		out.writeInt(n);
		out.writeDouble(d);
		out.writeUTF(t);
		out.writeUTF(t2);
		out.close();
		System.out.println("FIN DE PROGRAMA");

	}

}
