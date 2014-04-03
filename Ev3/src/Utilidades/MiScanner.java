package Utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MiScanner {

	private Scanner s;

	public MiScanner() {
		s = new Scanner(System.in);
	}

	public int nextInt() {
		int n;
		n = s.nextInt();
		s.nextLine();// Lee la tecla Enter para evitar problemas en siguientes
						// lecturas
		return n;
	}

	public double nextDouble() {
		double n;
		n = s.nextDouble();
		s.nextLine();// Lee la tecla Enter para evitar problemas en siguientes
						// lecturas
		return n;
	}

	public String nextLine() {

		return s.nextLine();
	}

	public int leeEntero(String mensajeError) {
		int n = 0;
		boolean bien;
		do {
			bien = true;
			try {
				n = this.nextInt();
			} catch (Exception e) {
				if (mensajeError!=null)
					System.out.println(mensajeError);
				bien = false;
				s.nextLine(); //Para vaciar el buffer de lectura
			}

		} while (!bien);
		return n;
	}
	
	public double leeDoble(String mensajeError) {
		double n = 0;
		boolean bien;
		do {
			bien = true;
			try {
				n = this.nextDouble();
			} catch (Exception e) {
				if (mensajeError!=null)
					System.out.println(mensajeError);
				bien = false;
				s.nextLine(); //Para vaciar el buffer de lectura
			}

		} while (!bien);
		return n;
	}
	public GregorianCalendar leeFechaGC(String plantilla, String mensajeError) {
		GregorianCalendar f=new GregorianCalendar();
		SimpleDateFormat sdf=new SimpleDateFormat(plantilla);
		sdf.setLenient(false);
		boolean bien;
		do {
			bien = true;
			try {
				f.setTime(sdf.parse(this.nextLine()));
			} catch (Exception e) {
				if (mensajeError!=null)
					System.out.println(mensajeError);
				bien = false;
			}
		} while (!bien);
		return f;
	}
	
	public Date leeFecha(String plantilla, String mensajeError) {

		Date d=null;
		SimpleDateFormat sdf=new SimpleDateFormat(plantilla);
		sdf.setLenient(false);
		boolean bien;
		do {
			bien = true;
			try {
				d=sdf.parse(this.nextLine());
			} catch (Exception e) {
				if (mensajeError!=null)
					System.out.println(mensajeError);
				bien = false;
			}
		} while (!bien);
		return d;
	}
}
