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
		out.writeChars(t);//Escribe cada car�cter de texto como dos bytes.El editor de texto interpreta seg�n la tabla ASCII,
		//por lo que queda un null y el car�cter.
		out.writeBytes(t);//Por cada car�cter un byte
		out.writeUTF(t);//Para programas que entiendan unicode. Est� en UTF-8 sin BOM.
		//El segundo car�cter es el tama�o del String
		out.close();
		System.out.println("FIN DE PROGRAMA");

	}

}
