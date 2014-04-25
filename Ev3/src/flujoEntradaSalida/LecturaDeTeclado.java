package flujoEntradaSalida;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Utilidades.MiScanner;

public class LecturaDeTeclado {

	public static void main(String[] args) throws IOException  {
		MiScanner s=new MiScanner ();
		DataOutputStream out=new DataOutputStream(new FileOutputStream("c:/cadena.txt"));
		String t;
		System.out.print("Escribe la cadena: ");
		t=s.nextLine();
		out.writeChars(t);//Escribe cada carácter de texto como dos bytes.El editor de texto interpreta según la tabla ASCII,
		//por lo que queda un null y el carácter.
		out.writeBytes(t);//Por cada carácter un byte
		out.writeUTF(t);//Para programas que entiendan unicode. Está en UTF-8 sin BOM.
		//El segundo carácter es el tamaño del String
		out.close();
		System.out.println("FIN DE PROGRAMA");

	}

}
