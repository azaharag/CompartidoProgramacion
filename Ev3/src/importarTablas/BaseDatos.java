package importarTablas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class BaseDatos {

	Connection conexion;
	
	public BaseDatos(String IP,String usuario,String contra) throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager
					.getConnection("jdbc:mysql://"+IP,usuario,contra);
	}
	
	public void extraerTabla(String base,String tabla,String fich) throws FileNotFoundException, SQLException
	{
		ArrayList<String> cols=dameColumnas(base,tabla);
		PrintWriter pw;
		Statement sentencia_sql = conexion.createStatement();
		ResultSet rs;
		if(fich!=null)
		{
			pw = new PrintWriter("c:/Estructura/"+fich);
		}
		else
		{
			pw = new PrintWriter("c:/Estructura/"+base+"."+tabla+".csv");
		}
		for(String col:cols){
			pw.print(col+";");
		}
		pw.println();
		
		rs=sentencia_sql.executeQuery("SELECT * FROM "+base+"."+tabla);
		while(rs.next())
		{
			for(String col:cols)
			{
				pw.print(rs.getString(col)+";");
			}
			pw.println();
		}
		rs.close();
		pw.close();
	}
	
	public void importarTabla(File f)
	{
		StringTokenizer st=new StringTokenizer(f.getPath(),".");
		String tab,bas;
		bas=st.nextToken();
		tab=st.nextToken();
		
		if(existeTabla(bas, tab))
		{
			if(existeTabla(tab,bas))
			{
				JOptionPane.showMessageDialog(null, "La tabla ya existe","Error" ,JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//crear la tabla e insertar los datos
						crearTabla(bas,tab,f);
			}
		}
		else
		{
			//crear la base de datos y la tabla
				crearBase(bas);
				crearTabla(bas,tab,f);
		}
	}
	
	private boolean existeTabla(String tab,String base)
	{
		ArrayList<String> tablas=dameTablas(base);
		for(String t:tablas)
		{	 
			if(tab.equals(t))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean existeBase(String base, String tab)
	{
		ArrayList<String> bd=dameBaseDatos();
		for(String i:bd)
		{	
			if(base.equals(i))
			{
				return true;
			}
		}
		return false;
	}
	
	private void crearTabla(String base,String tabla,File f) 
	{
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String linea=br.readLine();
			StringTokenizer st=new StringTokenizer(linea,";");
			String prep="create table "+base+"."+tabla+"(";
			while(st.hasMoreTokens())
			{
				prep=prep+st.nextToken()+" varchar(50), ";
			}
			prep=prep+")";
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		insertarDatos();
	}

	private void insertarDatos() 
	{
		
		
	}

	private void crearBase(String base)
	{
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			String prep="create database "+base;
			sentencia.executeUpdate(prep);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	boolean ficheroCorrecto(File f)
	{
		String t=f.getName();
		String patron="[A-Z a-z]+\\.[A-Z a-z]+\\.csv";
		if(t.matches(patron))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<String> dameBaseDatos()
	{
		DatabaseMetaData meta;
		ResultSet res;
		ArrayList<String> bases=new ArrayList<String>();;
		try {
			meta = conexion.getMetaData();
			res=meta.getCatalogs();
			
			while (res.next())
			{
				bases.add(res.getString("TABLE_CAT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bases;
	}
	
	public ArrayList<String> dameTablas(String base)
	{
		DatabaseMetaData meta;
		ResultSet res;
		ArrayList<String> tablas = new ArrayList<String>();
		try {
			meta = conexion.getMetaData();
			res=meta.getTables(base, null, "%", null);
			
			while (res.next())
			{
				if(res.getString("TABLE_TYPE").equals("TABLE"))
				tablas.add(res.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tablas;
	}
	
	public ArrayList<String> dameColumnas(String base, String table)
	{
		DatabaseMetaData meta;
		ResultSet res;
		ArrayList<String> columnas = new ArrayList();
		try {
			meta = conexion.getMetaData();
			res=meta.getColumns(base,null,table,"%");
			
			while (res.next())
			{
				columnas.add(res.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnas;
	}
	public void desconectar()
	{
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
