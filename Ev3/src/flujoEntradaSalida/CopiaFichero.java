package flujoEntradaSalida;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CopiaFichero {

	public static void main(String[] args) throws FileNotFoundException {
		//Copiar un fichero con DIS y DOS.
		//Usar JFileChooser y preguntar a la hora de sobreescribir.
		
		JFileChooser jfc=new JFileChooser();
		File o,d;
		int confirmado = 0;
		jfc.setCurrentDirectory(new File("c:/"));
		jfc.showDialog(null, "Seleccionar");
		o=jfc.getSelectedFile();
		jfc.showDialog(null, "Seleccionar");
		d=jfc.getSelectedFile();
		if(d.exists())
		{
			confirmado=JOptionPane.showConfirmDialog(null, "¿Desea Sobreescribir?", "¿Desea Sobreescribir?", 
			JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		}
		if(confirmado==JOptionPane.YES_OPTION)
		{
		copiarFichero(o,d);
		}
		else
		{
			System.out.println("No se ha copiado porque ha decidido no sobreescribir");
		}
	}
	static void copiarFichero(File o,File d) throws FileNotFoundException
	{
		DataInputStream in=null;
		DataOutputStream out=null;
		try{
			in=new DataInputStream(new FileInputStream(o));
			out=new DataOutputStream(new FileOutputStream(d));
			while(true)
			{
				out.writeByte(in.readByte());
			}
		}
		catch(EOFException e)
		{
			//Fin fichero
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(in!=null && out!=null)
			{
				try{
					in.close();
					out.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
