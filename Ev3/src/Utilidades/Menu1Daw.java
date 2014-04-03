package Utilidades;


public class Menu1Daw {
	private String titulo;// Titulo del menu. "" si no se desea titulo
	private String tituloFin;// Titulo de la opcion de fin. "" si no se desea
								// opcion de fin.
	private int maxOpciones; // Numero mï¿½ximo de opciones que admite el menu
	private int cntOpciones; // Opciones del menu <= maxOpciones. Lo incrementa
								// el
	// metodo aniadeOpcion
	private String[] opciones;
	private boolean numerico;// true:opciones 1,2,3,...,0-opcion fin.

	// false:A,B,C,...S-opcion fin

	public Menu1Daw(String titulo, String tituloFin, int maxOpciones,
			boolean numerico) {
		this.titulo = titulo;
		this.tituloFin = tituloFin;
		this.maxOpciones = maxOpciones;
		this.opciones = new String[maxOpciones];
		this.cntOpciones = 0;
		this.numerico = numerico;
	}

	public boolean hayTitulo() {
		return !titulo.equals("");
	}

	public boolean hayTituloFin() {
		return !tituloFin.equals("");
	}

	public void aniadeOpcion(String o) {
		if (cntOpciones == maxOpciones)
			return;
		opciones[cntOpciones] = o;
		cntOpciones++;
	}

	public void mostrar() {
		if (hayTitulo())
			System.out.println(titulo);
		for (int i = 0; i < cntOpciones; i++) {
			if (numerico)
				System.out.print(i + 1);
			else
				System.out.print((char) ('A' + i));
			System.out.println("-" + opciones[i]);
		}
		if (hayTituloFin()) {
			if (numerico)
				System.out.print(0);
			else
				System.out.print("S");
			System.out.println("-" + tituloFin);
		}
	}

	public int pideOpcion() {
		String t;
		boolean bien;
		MiScanner s = new Utilidades.MiScanner();
		do {
			System.out.print("\nSeleccione opción:");
			t=s.nextLine();
			t=t.toUpperCase(); //Pasa a mayusculas, no afecta a los numeros
			if (numerico)
			{
				bien=numeroValido(t);
			}
			else
			{
				bien=letraValida(t);
					
			}
			if (!bien)
				System.out.println("ï¿½ Opción no valida !");
		} while (!bien);
		if (numerico)
			return Integer.parseInt(t);
		else
			return t.charAt(0);
	}

	boolean numeroValido(String t)
	{
		if (t.matches("[0-9]"))
		{
			int n=Integer.parseInt(t);
			return n>=1 && n<=cntOpciones || hayTituloFin() && n==0;
		}
		else
		return false;
	}

	boolean letraValida(String t)
	{
		
		if (t.matches("[A-Z]"))
		{
			char c=t.charAt(0);
			return c>='A' && c<=('A'+cntOpciones-1) || hayTituloFin() && c=='S';
		}
		else
			return false;
	}
}
