package colecciones;

import java.util.ArrayList;

public class Pila<T> extends ArrayList<T> {

	void apilar (T dato)
	{
		if(dato!=null)
		{
			this.add(dato);
		}
		else
		{
			System.out.println("Introduzca dato no nulo");
		}
	}
	
	Object cima()
	{
		Object elemento=null;
		if(this.size()>0)
		{
			elemento=this.get(this.size()-1);
		}
		return elemento;
	}
	
	void desapilar()
	{
		if(this.size()>0)
		{
			this.remove(this.size()-1);
		}
	}
	
	boolean vacia()
	{
		return this.isEmpty();
	}
}
