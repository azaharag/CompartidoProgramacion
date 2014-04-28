package EscribirLeerObjetos;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EscribeLeeObjetos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
//		//Crea objetos y los escribe a un fichero
//		Cliente c1 = new Cliente("Angel", 28);
//		Cliente c2 = new Cliente("Ana", 44);
//
//		ObjectOutputStream salida = null;
//		try {
//			// apertura del fichero
//			salida = new ObjectOutputStream(new FileOutputStream("cliente.obj"));
//			salida.writeObject("Datos del cliente");
//			salida.writeObject(c1);
//			salida.writeObject(c2);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (salida != null)
//				try {
//					salida.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}

		//Lee los objetos grabados en cliente.obj
		ObjectInputStream entrada = null;
		try {
			// apertura del fichero
			entrada = new ObjectInputStream(new FileInputStream("cliente.obj"));
			String t=(String) entrada.readObject();
			Cliente obj1=(Cliente) entrada.readObject();
			Cliente obj2=(Cliente) entrada.readObject();
			
			System.out.println("===== Objetos leidos del fichero ===============");
			System.out.println(t);
		 
			System.out.println(obj2.nombre+" "+obj2.edad);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (entrada != null)
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		System.out.println("FIN PROGRAMA.");

	}

}
