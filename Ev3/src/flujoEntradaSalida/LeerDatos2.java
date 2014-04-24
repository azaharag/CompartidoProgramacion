package flujoEntradaSalida;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerDatos2 {

	public static void main(String[] args) throws IOException {
		char c;
		int n;
		double d;
		String t,t2;
		DataInputStream in=new DataInputStream (new FileInputStream("c:/datos.txt"));
		c=in.readChar();
		n=in.readInt();
		d=in.readDouble();
		t=in.readUTF();
		t2=in.readUTF();
		System.out.println(c);
		System.out.println(n);
		System.out.println(d);
		System.out.println(t);
		System.out.println(t2);

	}

}
