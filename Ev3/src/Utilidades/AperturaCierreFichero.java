package Utilidades;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import Utilidades.MiScanner;

public class AperturaCierreFichero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiScanner s = new MiScanner();

		DataOutputStream f = null;
		try {
			// apertura del fichero
			f = new DataOutputStream(new FileOutputStream("C:/Cadena.txt"));

			System.out.print("Cadena?");
			String t = s.nextLine();

			f.writeUTF(t);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		System.out.println("FIN PROGRAMA.");
	}
}
