package jdbcTablaCSV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class BaseDatos {

	private Connection con;

	public BaseDatos(String IP, String usuario, String passwd)
			throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		con = DriverManager
				.getConnection("jdbc:mysql://" + IP, usuario, passwd);

	}

	public void desconectar() {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> dameBases() throws SQLException {

		ArrayList<String> l = new ArrayList<String>();
		DatabaseMetaData meta = con.getMetaData();
		ResultSet res = meta.getCatalogs();
		while (res.next()) {

			l.add(res.getString("TABLE_CAT"));
		}
		res.close();
		return l;
	}

	public ArrayList<String> dameTablas(String base) throws SQLException {
		ArrayList<String> l = new ArrayList<String>();
		DatabaseMetaData meta = con.getMetaData();
		ResultSet res = meta.getTables(base, null, "%",null);
		while (res.next()) {
			if (res.getString("TABLE_TYPE").equals("TABLE"))
				l.add(res.getString("TABLE_NAME"));
		}
		res.close();
		return l;
	}

	public ArrayList<String> dameColumnas(String base, String tabla) throws SQLException {
		ArrayList<String> l = new ArrayList<String>();
		DatabaseMetaData meta = con.getMetaData();
		ResultSet res = meta.getColumns(base, null,tabla,"%");
		while (res.next()) {
			l.add(res.getString("COLUMN_NAME"));
		}
		res.close();
		return l;
	}

	public int exportarTablaCSV(String base, String tabla,String nombreCSV) throws SQLException, IOException {
		ArrayList<String> lista=dameColumnas(base,tabla);
		String nombre;
		if (nombreCSV==null) 
			nombre=base+"."+tabla+".csv"; //Nombre por defecto si no viene especificado
		else
			nombre=nombreCSV;
		PrintWriter pw=new PrintWriter(nombre);//Se crea fichero CSV
		//Generamos linea de cabecera del CSV conteniendo los nombres de columna 
		for(String col:lista)
		{
			pw.print(col+";");
		}
		pw.println();
		//Obtenemos todas las filas de la tabla
		Statement st=con.createStatement();
		String sql = "SELECT * FROM "+base+"."+tabla;
		ResultSet res=st.executeQuery(sql);
		int filas=0;
		while (res.next()) {
			for(String col:lista)//Por cada fila se recogen los valores de cada columna
			{
				pw.print(res.getString(col)+";");
			}
			pw.println();
			filas++;
		}
		res.close();
		
		pw.close();
		return filas;
	}

}