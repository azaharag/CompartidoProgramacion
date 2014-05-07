package jdbc;

//Se conecta a la BD de ejemplo "world" en un servidor MySQL y muestra las 2 primeras columnas de la tabla "city"


import java.sql.*;

public class A_Conectar_con_mysql {
	public static void main(String args[]) {
		try {
			// Cargar clase de controlador de base de datos
			Class.forName("com.mysql.jdbc.Driver");
			// Crear el objeto de conexion a la base de datos
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://192.168.1.37/world","root","root");
			// Crear objeto Statement para realizar queries a la base de datos
			Statement sentencia_sql = conexion.createStatement();
			// Un objeto ResultSet, almacena los datos de resultados de una
			// consulta
			ResultSet rs = sentencia_sql
					.executeQuery("SELECT * FROM city");
			System.out.println("Codigo\tNombre");
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
			rs.close();
			
			sentencia_sql.executeUpdate("INSERT INTO empleado VALUES (1,'Pepe Lopez GUTI',19,12000)");
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}