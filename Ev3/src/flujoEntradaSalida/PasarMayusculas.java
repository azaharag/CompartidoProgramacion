package flujoEntradaSalida;

import java.util.Scanner;

public class PasarMayusculas {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String t;
		do{
			t=s.nextLine();
			System.out.println(t.toUpperCase());
		}while(!t.equalsIgnoreCase("fin"));
	}
}
