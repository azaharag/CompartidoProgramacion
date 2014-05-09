package jdbc;

import java.sql.*;

public class Insertar10Filas {

	public static void main(String[] args) {
		try {
			// Cargar clase de controlador de base de datos
			Class.forName("com.mysql.jdbc.Driver");
			// Crear el objeto de conexion a la base de datos
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://localhost/bd_alumno","root","admin");
			// Crear objeto Statement para realizar queries a la base de datos
			Statement sentencia_sql = conexion.createStatement();
			// Un objeto ResultSet, almacena los datos de resultados de una
			// consulta
			borrarContenido(sentencia_sql);
			
			insertarContenido(sentencia_sql);
			
			mostrarContenidoBis(sentencia_sql);
			
			Statement sentencia2_sql=conexion.createStatement();
			
			pasarMayusculas(sentencia_sql,sentencia2_sql);
			
			mostrarContenidoBis(sentencia_sql);
			
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	private static void pasarMayusculas(Statement sentencia2_sql, Statement sentencia_sql) throws SQLException {
		ResultSet rs = sentencia_sql
				.executeQuery("SELECT * FROM profesor");
		while (rs.next())
		{	String nombre=rs.getString(2);
			String dni=rs.getString(1);
			String sql="update profesor set nombre='"+nombre.toUpperCase()+"' where dni_profesor='"+dni+"'";
			sentencia2_sql.executeUpdate(sql);
		}
		rs.close();
	}

	private static void mostrarContenidoBis(Statement sentencia_sql) throws SQLException
	{
		ResultSet rs = sentencia_sql
				.executeQuery("SELECT * FROM profesor");
		System.out.println("DNI PROFESOR\t NOMBRE");
		while (rs.next())
			System.out.println(rs.getString(1) + "\t\t" + rs.getString("nombre"));
		rs.close();
	}

	private static void insertarContenido(Statement sentencia_sql) throws SQLException {
		for(int i=1;i<=10;i++)
		{
			String sql="INSERT INTO profesor VALUES('"+i+"','profesor "+i+"')";
			sentencia_sql.executeUpdate(sql);
		}
	}

	private static void borrarContenido(Statement sentencia_sql) throws SQLException {
		sentencia_sql.executeUpdate("DELETE FROM profesor where DNI_PROFESOR >=1 AND DNI_PROFESOR<=10");
		
	}
}
