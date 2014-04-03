package swing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Matriz {

	double [][] m;
	
	public Matriz(String t) {
		ArrayList <Integer> d = null;
		StringTokenizer st=new StringTokenizer(t,"\n");
		int cont=0;
		while(st.hasMoreTokens())
		{
			cont++;
			String linea=st.nextToken();
			StringTokenizer st2=new StringTokenizer(linea);
			while(st2.hasMoreTokens())
			{
				String digito=st2.nextToken();
						d.add(Integer.parseInt(digito));
					if(filaCorrecta(d))
					{
						for(int j=0;j<d.size();j++)
						{
							m[cont][j]=d.get(j);
						}
					}
			}
		}
		if(matrizCorrecta(m))
		{
			
		}
		
	}

	private boolean matrizCorrecta(double[][] matriz) {
		if(matriz.length==matriz[0].length && (matriz.length>=1 ||matriz.length<=5) )
		{
			return true;
		}
		return false;
	}

	private boolean filaCorrecta(ArrayList<Integer> d) {
		for(int i=0;i<d.size();i++)
		{
			if(d.get(i)<0 || d.get(i)>4)
			{
				return false;
			}
		}
		return true;
		
	}
	public boolean compatible(Matriz otra) {
		if(m.length==otra.m.length && m[0].length==otra.m[0].length)
		{
			return true;
		}
		return false;
	}

	public String suma(Matriz otra) {
		double [][] aux=new double [m.length][m[0].length];
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<m[0].length;j++)
			{
				aux[i][j]=m[i][j]+otra.m[i][j];
			}
		}
		return Arrays.toString(aux);
	}
	
}
