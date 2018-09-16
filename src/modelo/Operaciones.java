package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Operaciones {
    
    public Object [][] select(String table, String fields, String where,Connection con) {
        int registros = 0;      
        String colname[] = fields.split(",");

        //Consultas SQL
        String q ="SELECT " + fields + " FROM " + table;
        String q2 = "SELECT count(*) as total FROM " + table;
        if(where!=null)
        {
            q+= " WHERE " + where;
            q2+= " WHERE " + where;
        }
         try{
           PreparedStatement pstm = con.prepareStatement(q2);
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
           res.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][fields.split(",").length];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
          try{
             PreparedStatement pstm = con.prepareStatement(q);
             ResultSet res = pstm.executeQuery();
             int i = 0;
             while(res.next()){
                for(int j=0; j<=fields.split(",").length-1;j++){
                    data[i][j] = res.getString( colname[j].trim() );
                }
                i++;         }
             res.close();
              }catch(SQLException e){
             System.out.println(e);
        }
        return data;
    }
    
    
    public boolean insert(String table, String fields, String values,Connection con) {
        
        boolean res=false;
        //Se arma la consulta
        String q=" INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            
           JOptionPane.showMessageDialog(null,"Insertado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        
        return res;
    }
     
     
    
    public Object[][] getInfo(Connection con, String fields, String table, String where) {
        
        Object[][] res = this.select(table, fields, where,con);
        if( res.length > 0)
            return res;
        else
            return null;
    }   
     
    public String getData(Connection con, String fields, String table, String where) {
        int registros = 0;      
        String colname[] = fields.split(",");
        String arr = null;
        
        //Consultas SQL
        String q ="SELECT " + fields + " FROM " + table;
        if(where!=null) {
            q+= " WHERE " + where;
        }
         try{
           PreparedStatement pstm = con.prepareStatement(q);
           ResultSet res = pstm.executeQuery();
            
            while (res.next()) {
                String em = res.getString("monto");System.out.println(em);
                arr = em.replace("\n", ",");
            }           
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }


        return arr;
    } 
     
    
    public boolean updateMonto(String table, double monto, double transaccion, String campo, String numero, Connection con) {
         
        boolean res=false;
        //Se arma la consulta
        String q = "UPDATE "+table+" SET monto = "+monto+", "+campo+" = "+transaccion+" WHERE "+
                "numero = "+"'"+numero+"'";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            
           JOptionPane.showMessageDialog(null,"Actualizado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        
        return res;
         
    }
    
    public boolean LimpiarTabla(String table, Connection con) {
        boolean res=false;
        //Se arma la consulta
        String q = "DELETE FROM "+table;
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
            
           JOptionPane.showMessageDialog(null,"Tabla limpia");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        
        return res;
    }
    
}
