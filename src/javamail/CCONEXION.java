package javamail;

/**
 *
 * @author Joshua Ormachea
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CCONEXION
{   
    Connection con=null; 
    Statement st;   ResultSet rs;
    String servidor="", usuarioDB, passwordDB;
    
    public CCONEXION()
    {   try
        {   Class.forName("com.mysql.jdbc.Driver");
            servidor = "mysql.hostinger.es";
            usuarioDB="u662755134_scs";
            passwordDB="gunjoshuas"; 
            con= DriverManager.getConnection(servidor,usuarioDB,passwordDB); 
            st = con.createStatement();
            JOptionPane.showMessageDialog(null,"EXITO EN LA CONEXION");
        }
        catch(SQLException | ClassNotFoundException ex)
        {   JOptionPane.showMessageDialog(null, ex, "ERROR EN LA CONEXION CON LA BD"+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }       
    }
    
    public Connection getCon() {
        return con;
    }    
}
