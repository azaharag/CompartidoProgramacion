package colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Utilidades.MiScanner;

public class PruebaColecciones {

	public static void main(String[] args) {
		//si se repite decir duplicado. Mostrar la lista de números
		//List<String> lista=new ArrayList<String>();
		MiScanner s=new MiScanner();
		Set <Integer> conjunto =new HashSet<Integer>();
//		System.out.println("Introduce un número (-1 para salir)");
//		int n=s.nextInt();
//		while(n!=-1)
//		{
//			if(!conjunto.add(n))
//			{
//				System.out.println("DUPLICADO");
//			}
//			n=s.nextInt();
//		}
//		
//		for(Integer i:conjunto)
//		{
//			System.out.println(i);
//		}
//		
		Set <Integer> conjunto2 =new TreeSet<Integer>();
		System.out.println("Introduce un número (-1 para salir)");
		int num=s.nextInt();
		while(num!=-1)
		{
			if(!conjunto2.add(num))
			{
				System.out.println("DUPLICADO");
			}
			num=s.nextInt();
		}
		
		for(Integer i:conjunto2)
		{
			System.out.println(i);
		}
		
	}

}
