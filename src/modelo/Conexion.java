package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    private Connection conn = null;
    public Connection CrearBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
         if (conn!=null){
            JOptionPane.showMessageDialog(null,"OK base de datos listo");
            //String crearClientes="create table clientes(nombre varchar(50), cc varchar(50), fecha_nac varchar(50))";
            String crearCuentas="create table cuentas(numero varchar(50), nombre varchar(50), "
                    + "fecha_nac varchar(50), monto double, ultimo_retiro double, ultima_consignacion double)";
            String desc="disconnect;";
            try {
            //PreparedStatement pstm = conn.prepareStatement(crearClientes);
            PreparedStatement pstmm = conn.prepareStatement(crearCuentas);
            /*pstm.execute();
            pstm.close();*/
            pstmm.execute();
            pstmm.close();
            
            PreparedStatement pstm2 = conn.prepareStatement(desc);
            pstm2.execute();
            pstm2.close();
            
           JOptionPane.showMessageDialog(null,"BD Creada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
         }
      }catch(SQLException e){
       JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }
       return conn;
    }
    
    public Connection AccederBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB");
         if (conn!=null){
            JOptionPane.showMessageDialog(null,"OK base de datos listo");
         }
      }catch(SQLException e){
       JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }
       return conn;
    }
     
    public void cerracon (){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
