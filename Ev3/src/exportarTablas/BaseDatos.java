package exportarTablas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

	Connection conexion;
	
	public BaseDatos(String IP,String usuario,String contra)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager
					.getConnection("jdbc:mysql://"+IP,usuario,contra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
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
			pw = new PrintWriter("c:/Estructura/"+base+"."+tabla+".cvs");
		}
		for(String col:cols){
			pw.print(col+";");
		}
		pw.println();
		
		rs=sentencia_sql.executeQuery("SELECT * FROM "+base+"."+tabla);
		
	}
	
	public ArrayList<String> dameBaseDatos()
	{
		DatabaseMetaData meta;
		ResultSet res;
		ArrayList<String> bases = null;
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
		ArrayList<String> tablas = null;
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
		ArrayList<String> columnas = null;
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
}
