package flujoEntradaSalida;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerDatos {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader("c:/datos.txt"));
		char c;
		int n;
		double d;
		String t,v;
	
		v=br.readLine();
		c=v.charAt(0);
		v=br.readLine();
		n=Integer.valueOf(v);
		v=br.readLine();
		d=Double.valueOf(v);
		t=br.readLine();
		br.close();
		System.out.println(c);
		System.out.println(n);
		System.out.println(d);
		System.out.println(t);
	}

}
