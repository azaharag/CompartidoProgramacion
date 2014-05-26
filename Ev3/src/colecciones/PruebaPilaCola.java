package colecciones;


public class PruebaPilaCola {
	public static void main(String[] args) {

	Pila <Integer> p= new Pila<Integer>();
	Cola <Integer> c=new Cola<Integer>();
	System.out.println("======PILAS======");
	p.apilar(1);
	p.apilar(2);
	p.apilar(3);
	System.out.println(p.cima());
	p.desapilar();
	System.out.println(p.cima());
	p.desapilar();
	System.out.println(p.cima());
	p.desapilar();
	System.out.println("======COLAS======");
	c.encolar(1);
	c.encolar(2);
	c.encolar(3);
	System.out.println(c.frente());
	c.desencolar();
	System.out.println(c.frente());
	c.desencolar();
	System.out.println(c.frente());
	c.desencolar();
	}
}
