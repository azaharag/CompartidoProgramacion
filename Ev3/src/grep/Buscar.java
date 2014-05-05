package grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Buscar {

	public static void main(String[] args) {
		ArrayList<ItemBusqueda> listado;
		listado=buscarCadena("e:/", "dtd",true,false);
		for(int i=0;i<listado.size();i++)
		{
			System.out.print(listado.get(i).getRuta());
			System.out.print(listado.get(i).getLinea());
			System.out.println();
		}
		

	}

	private static ArrayList<ItemBusqueda> buscarCadena(String ruta, String cadena, boolean igMayus, boolean recur) {
		ArrayList <ItemBusqueda> listado=new ArrayList<ItemBusqueda>();
		 if (igMayus && recur)
		   {listado=buscarIgnorarMayusculaRecursivo(ruta,cadena);
		   return listado;}
		   if (igMayus && !recur)
		   {listado=buscarMayuscula(ruta,cadena);
		   return listado;}
		    if (!igMayus && recur)
		    {listado=buscarRecursivo(ruta,cadena);
		    return listado;}
		     if (!igMayus && !recur)
		     {listado=buscarMayusculaRecursivo(ruta,cadena);
		     return listado;}
				return listado;
		
		
	}

	private static ArrayList<ItemBusqueda> buscarMayusculaRecursivo(String ruta, String cadena) {
		File f=new File(ruta);
		ArrayList<ItemBusqueda> encontrados= new ArrayList<ItemBusqueda>();
		File[]lista=f.listFiles();
		for (File e:lista)
		{
			if(e.isFile())
			{
				try{
					BufferedReader br=new BufferedReader(new FileReader(e));
					String linea;
					while((linea=br.readLine())!=null)
					{
						if(linea.indexOf(cadena)!=-1)
						{
							ItemBusqueda item=new ItemBusqueda(e.getAbsolutePath(),linea);
							encontrados.add(item);
						}
					br.close();
					}
				}catch(FileNotFoundException error)
				{
					error.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				buscarIgnorarMayusculaRecursivo(e.getAbsolutePath(), cadena);
			}
		}
		return encontrados;
	}

	private static ArrayList<ItemBusqueda> buscarRecursivo(String ruta,String cadena) {
		File f=new File(ruta);
		ArrayList<ItemBusqueda> encontrados= new ArrayList<ItemBusqueda>();
		File[]lista=f.listFiles();
		for (File e:lista)
		{
			if(e.isFile())
			{
				try{
					BufferedReader br=new BufferedReader(new FileReader(e));
					String linea;
					while((linea=br.readLine())!=null)
					{
						if(linea.indexOf(cadena)!=-1)
						{
							ItemBusqueda item=new ItemBusqueda(e.getAbsolutePath(),linea);
							encontrados.add(item);
						}
					}
					br.close();
				}catch(FileNotFoundException error)
				{
					error.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				buscarIgnorarMayusculaRecursivo(e.getAbsolutePath(), cadena);
			}
		}
		return encontrados;
	}

	private static ArrayList<ItemBusqueda> buscarMayuscula(String ruta,String cadena) {
		File f=new File(ruta);
		ArrayList<ItemBusqueda> encontrados= new ArrayList<ItemBusqueda>();
		File[]lista=f.listFiles();
		for (File e:lista)
		{
			if(e.isFile())
			{
				try{
					BufferedReader br=new BufferedReader(new FileReader(e));
					String linea;
					while((linea=br.readLine())!=null)
					{
						String lineaMayus=linea.toUpperCase();
						if(lineaMayus.indexOf(cadena)!=-1)
						{
							ItemBusqueda item=new ItemBusqueda(e.getAbsolutePath(),linea);
							encontrados.add(item);
						}
					}
					br.close();
				}catch(FileNotFoundException error)
				{
					error.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return encontrados;
	}

	private static ArrayList<ItemBusqueda> buscarIgnorarMayusculaRecursivo(String ruta, String cadena) {
		File f=new File(ruta);
		ArrayList<ItemBusqueda> encontrados= new ArrayList<ItemBusqueda>();
		File[]lista=f.listFiles();
		for (File e:lista)
		{
			if(e.isFile())
			{
				try{
					BufferedReader br=new BufferedReader(new FileReader(e));
					String linea;
					while((linea=br.readLine())!=null)
					{
						String lineaMayus=linea.toUpperCase();
						if(lineaMayus.indexOf(cadena)!=-1)
						{
							ItemBusqueda item=new ItemBusqueda(e.getAbsolutePath(),linea);
							encontrados.add(item);
						}
					}
					br.close();
				}catch(FileNotFoundException error)
				{
					error.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				buscarIgnorarMayusculaRecursivo(e.getAbsolutePath(), cadena);
			}
		}
		return encontrados;
	}

	
}
