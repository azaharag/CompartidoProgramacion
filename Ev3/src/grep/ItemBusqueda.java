package grep;

public class ItemBusqueda {
	private String ruta;
	private String linea;
	
	ItemBusqueda(String ruta, String linea)
	{
		this.ruta=ruta;
		this.linea=linea;
	}

	public String getRuta() {
		return ruta;
	}

	public String getLinea() {
		return linea;
	}

	
}
