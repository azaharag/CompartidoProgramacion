package flujoEntradaSalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EscribirDatos {

	public static void main(String[] args) throws FileNotFoundException {
		char c='A';
		int n=8;
		double d=7.15;
		String t="HOLA",t2="ADIOS";
		
		PrintWriter p=new PrintWriter("c:/datos.txt");
		p.print(c);
		p.print(n);
		p.print(d);
		p.print(t);
		p.print(t2);
		p.close();
		
	
	}
}
