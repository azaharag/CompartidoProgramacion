package jdbc;

/**
  * Lista todas las bases de datos que hay en el SGBD
 */
import java.sql.*;
public class C_Listar_bases_de_datos {
  public static void main(String [] args) {
    Connection con = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/","root","");

      DatabaseMetaData meta = con.getMetaData();
      ResultSet res = meta.getCatalogs();
      System.out.println("Listado de bases de datos: "); 
      while (res.next()) {
         System.out.println("   "
           +res.getString("TABLE_CAT"));
      }
      res.close();

      con.close();
    } catch (java.lang.ClassNotFoundException e) {
      System.err.println("ClassNotFoundException: "
        +e.getMessage());
    } catch (SQLException e) {
      System.err.println("SQLException: "
        +e.getMessage());
    }
  }
}