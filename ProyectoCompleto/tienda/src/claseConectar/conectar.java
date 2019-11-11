package claseConectar;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author elaprendiz http://www.youtube.com/user/JleoD7
 */

public class conectar {
Connection conect = null;


   public Connection conexion()
    {
      try {
             
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/tienda_academia","root","VALERIA2019");
           //JOptionPane.showMessageDialog(null, "conectado");
           //Cargamos el Driver Access
           //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //Conectar en red base 
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=//servidor/bd_cw/cw.mdb";
           //Conectar Localmente
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=D:/cwnetbeans/cw.mdb";
          //conect = DriverManager.getConnection(strConect,"",""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
        
    }
     
        public boolean getProbar(String u, String p) {

        boolean s = false;
        try {

            String sql = "SELECT * FROM usuario WHERE user='" + u + "' AND password='" + p + "'";
            System.out.println("sql");
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                s = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
        
        
        public ResultSet consulta(String sql){
            ResultSet rs=null;
            try{
                PreparedStatement st=conect.prepareStatement(sql);
                rs=st.executeQuery();               
            }catch(SQLException e){
                System.err.println("Error consulta :" + e.getMessage());
               
            }
            return rs;
        }
        
        
        public DefaultComboBoxModel Obt_profesores(){
            DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
            ListaModelo.addElement("Seleccione un profesor");
            ResultSet rs=this.consulta("SELECT * FROM profesores order by nom_prof,ape_prof");
            
            try{
                while   (rs.next()){
                    ListaModelo.addElement(rs.getString("nom_prof"));
                    
                }
                rs.close();
            }catch(SQLException ex){
                
                System.err.println(ex.getMessage());
                
            }
            return ListaModelo;
        }
        
        public DefaultComboBoxModel Obt_clases(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
            ListaModelo.addElement("Seleccione una clase");
            ResultSet rs=this.consulta("SELECT * FROM clases order by nom_clase");

 try{
                while   (rs.next()){
                    ListaModelo.addElement(rs.getString("nom_clase"));
                    
                }
                rs.close();
            }catch(SQLException ex){
                
                System.err.println(ex.getMessage());
                
            }
            return ListaModelo;
        }

        
        
        
}
        
