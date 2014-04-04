package flujoEntradaSalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EscribirFichero {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter p= new PrintWriter(new File("C:/Fichero.txt"));
		p.println("Mi Primer Fichero");
		for(int i=1;i<=5;i++)
		{
			p.println(i);
		}
		p.println("ADIOS");
		p.close();
	}
}
