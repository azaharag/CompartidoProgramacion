package flujoEntradaSalida;

import java.util.Scanner;

public class Corta3 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String t;
		System.err.print("Introduzca cadena (fin para acabar)");
		do{
			t=s.nextLine();
			String t2=t.substring(0,3);
			System.out.println(t2);
		}while(!t.equalsIgnoreCase("fin"));
	}
}
