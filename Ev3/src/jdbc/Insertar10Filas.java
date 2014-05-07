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
//			ResultSet rs = sentencia_sql
//					.executeQuery("SELECT * FROM city");
//			System.out.println("Codigo\tNombre");
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
//			rs.close();
			sentencia_sql.executeUpdate("DELETE FROM profesor where DNI_PROFESOR >=1 AND DNI_PROFESOR<=10");
			for(int i=0;i<=10;i++)
			{
				String sql="'"+i+1+"'"+","+"'Profesor "+ i+1+"'";
				String mio="INSERT INTO profesor VALUES(t)";
				System.out.println(mio);
				sentencia_sql.executeUpdate(mio);
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

}
