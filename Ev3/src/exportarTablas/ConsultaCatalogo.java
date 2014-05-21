package exportarTablas;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaCatalogo {

	public static void main(String[] args) {
		try {
			// Cargar clase de controlador de base de datos
			Class.forName("com.mysql.jdbc.Driver");
			// Crear el objeto de conexion a la base de datos
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://172.25.245.53","root","admin");
			DatabaseMetaData meta=conexion.getMetaData();
			ResultSet res=meta.getCatalogs();
			System.out.println("Listado de bases de datos: ");
			while(res.next()){
				System.out.println(" "+res.getString("TABLE_CAT"));
			
			}
			res.close();
		      ResultSet rs = meta.getTables("sakila", null, "%", null);
		      // Display the result set data.
		      System.out.println("Tablas de sakila");
		      System.out.println("============");
		      while(rs.next()) {
		    	  if(rs.getString("TABLE_TYPE").equals("TABLE"))
		            System.out.println(rs.getString("TABLE_NAME"));
		      }
		      rs=meta.getColumns("sakila", null, "actor", "%");
		      System.out.println("Columnas de actor");
		      System.out.println("============");
		      while(rs.next())
		      {
		    	  System.out.println(rs.getString("COLUMN_NAME")+" "+rs.getString("DATA_TYPE")+" "+rs.getString("TYPE_NAME"));
		      }
		      rs.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} 
	}

}
