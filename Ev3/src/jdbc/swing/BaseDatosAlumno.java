package jdbc.swing;

import java.sql.*;

public class BaseDatosAlumno {
	Connection con;

	BaseDatosAlumno(String ip,String  usuario,String  passwd,String  bd) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		String cadenaConexion="jdbc:mysql://"+ip+"/"+bd;
		con = DriverManager
				.getConnection(cadenaConexion, usuario, passwd);
	}
	
	Alumno consultaAlumno(String  dni) throws SQLException
	{
		String prep="select * from alumno where dni=?";
		PreparedStatement ps=con.prepareStatement(prep);
		ps.setString(1, dni);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			Alumno a=new Alumno(rs.getString("dni"), rs.getString("nombre"), rs.getString("tutor"));
			return a;
		}else
		return null;	
	}
	
	void insertarAlumno(Alumno a) throws SQLException{
		
	}

	void borrarAlumno(String dni) throws SQLException{
		
	}
	void modificarAlumno(Alumno a) throws SQLException{
		
	}
	void desconectar() throws SQLException{
		con.close();
	}
}
