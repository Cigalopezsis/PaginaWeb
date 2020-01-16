
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;//Representa la conexión con la base de datos.
import java.sql.DriverManager;//Lleva el control de los Drivers cargados
//en la JDBC memoria.
//Encargado de realizar la conexión con la base de datos.
import java.sql.PreparedStatement;//Ejecutar sentencias SQL
import java.sql.ResultSet;//Representa el resultado de la ejecución
//de una sentencia SQL
import java.sql.SQLException;
import static java.lang.System.out;

public class Conexionn {
    
    //Encargados de abrir una conexión con los métodos estáticos.
    public static final String URL = "jdbc:mysql://localhost:3306/rossangela?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    
    PreparedStatement ps; //La instancia de PreparedStatement contiene una sentencia
    //SQL que ya sido compilada. Por eso se llama preparada.
    ResultSet rs;//Contiene los resultados de una consulta
    //SQL por lo que es un conjunto de filas obtenidas
    //desde una base de datos.
    
    public static Connection getConection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//Registra el driver de conexión
            //para la base de datos; cada base de datos usa una distinta.
            
            con = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            out.println("Conexión establecida....");
            
        }
        catch (ClassNotFoundException | SQLException e) //Son los errores en tiempo de
            //ejecución son exepciones y 
        {
            System.err.println(e);
        }
        return con;
    }
    
    public void insertarDatos (String Altura, String unidadesal, String Peso, String unidadesPeso, String IMC, String Clasificacion)
    {
        Connection con = null;
            
            try
            {
                con = getConection();
                ps = (PreparedStatement)con.prepareStatement("INSERT INTO  IMC (Altura, unidades_altura, Peso, unidades_peso, IMC, Clasificacion_IMC) VALUES (?, ?, ?, ?, ?, ?)");//Evitar sql injection.
                             //Insert into lenguaje para insertear en la base de datos                                                                                             //SET para modificar un valor, con un WHERE para específicar donde, llave primaria =
                              // Nombre de la tabla, VALUES (número de variables a ingresar);
          
               ps.setString(1, Altura);
               ps.setString(2, unidadesal);
               ps.setString(3, Peso);
               ps.setString(4, unidadesPeso);
               ps.setString(5, IMC);
               ps.setString(6, Clasificacion);
              
          int res = ps.executeUpdate();//Lo ejecuta
          
          if (res > 0)//Si el resultado es mayor a cero se ingresan los datos en la base.
          {
              out.println("Datos ingresados correctamente");
          }
          else
          {
              out.println("Error en el ingreso de datos.");
             
          }
          con.close();
            }
            catch (Exception e)
                    {
                        System.err.println(e);
                    }
    }
    
    
}
