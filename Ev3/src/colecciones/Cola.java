package colecciones;

import java.util.ArrayList;

public class Cola<T> extends ArrayList<T> {

	//añadir elemento a la cola
	void encolar(T dato)
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
	//eliminar el elemento frontal del la cola
	void desencolar()
	{
		if(this.size()>0)
		{
			this.remove(0);
		}
	}
	
	Object frente()
	{
		Object elemento=null;
		if(this.size()>0)
		{
			elemento=this.get(0);
		}
		return elemento;
	}
	
	boolean vacia()
	{
		return this.isEmpty();
	}
}
