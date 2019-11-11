package Formulario;

import claseConectar.conectar;
import static groovy.sql.Sql.resultSet;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClasesDisponibles extends javax.swing.JInternalFrame {

conectar cc= new conectar();
Connection cn= cc.conexion();
    
    DefaultTableModel model;

    public ClasesDisponibles() {
        initComponents();
         bloquear();
         this.cmbprofesorr.setModel(cc.Obt_profesores());
          cargar("");    
    
       
    }

    void bloquear() {
        txtcodigoc.setEnabled(false);
        txtclase.setEnabled(false);
        txtprecioclase.setEnabled(false);
        txtclase.setEnabled(false);
        txtprofesorr.setEnabled(false);
        cmbprofesorr.setEnabled(false);
        txtdias.setEnabled(false);
        txtpreciomes.setEnabled(false);
        btnguardar3.setEnabled(false);
        btnnuevo3.setEnabled(true);
        btncancelar3.setEnabled(false);
        btnactualizar3.setEnabled(false);
        
    }

    void limpiar() {
        txtcodigoc.setText("");
        txtclase.setText("");
        txtprecioclase.setText("");
        txtpreciomes.setText("");
        txtprofesorr.setText("");
        txtdias.setText("");
        
    }
        
        void desbloquear(){
    txtcodigoc.setEnabled(true);
    txtclase.setEnabled(true);
    txtprecioclase.setEnabled(true);
    txtpreciomes.setEnabled(true);
    txtprofesorr.setEnabled(true);
    txtdias.setEnabled(true);
    btnguardar3.setEnabled(true);
    btnnuevo3.setEnabled(false);
    btncancelar3.setEnabled(true);
    btnactualizar3.setEnabled(false);
    cmbprofesorr.setEnabled(true);
    

    }
        
void cargar(String valor){
                    
    String mostrar = "SELECT * FROM clases WHERE CONCAT(cod_clase,nom_clase,nom_proff,precio_clase,precio_mes) LIKE '%" + valor + "%'";
            String[] titulos = {"Codigo", "Clase", "Precio por Clase", "Precio por mes", "Profesor/a", "Días"};
            String[] Registros = new String[6];
            model = new DefaultTableModel(null, titulos);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(mostrar);
                while (rs.next()) {
                    Registros[0] = rs.getString("cod_clase");
                    Registros[1] = rs.getString("nom_clase");
                    Registros[2] = rs.getString("nom_proff");
                    Registros[3] = rs.getString("precio_clase");
                    Registros[4] = rs.getString("precio_mes");
                    Registros[5] = rs.getString("dias");
                    model.addRow(Registros);
                }
                tablaclases.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(ClasesDisponibles.class.getName()).log(Level.SEVERE, null, ex);
            }
     }

            void codigosclases(){
     int j;
        int cont=1;
        String num="";
        String c="";
         String SQL="select max(cod_clase) from clases";
       // String SQL="select count(*) from factura";
        //String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
        //String SQL="SELECT @@identity AS ID";
        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {              
                 c=rs.getString(1);
            }
           
                  
            if(c==null){
                txtcodigoc.setText("CL0001");
            }
            else{
                char r1=c.charAt(2);
            char r2=c.charAt(3);
            char r3=c.charAt(4);
            char r4=c.charAt(5);
            String r="";
            r=""+r1+r2+r3+r4;
            
                 j=Integer.parseInt(r);
                 GenerarCodigos gen= new GenerarCodigos();
                 gen.generar(j);
                 txtcodigoc.setText("CL"+gen.serie());
                          
            }
                         
                   
           } catch (SQLException ex) {
           Logger.getLogger(ClasesDisponibles.class.getName()).log(Level.SEVERE, null, ex);
        }
            }                
                              

                @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mmodificar = new javax.swing.JMenuItem();
        meliminar = new javax.swing.JMenuItem();
        txtcodigoc = new javax.swing.JTextField();
        btnguardar3 = new javax.swing.JButton();
        lblcodigoc = new javax.swing.JLabel();
        lblclase = new javax.swing.JLabel();
        txtclase = new javax.swing.JTextField();
        lblprofesorr = new javax.swing.JLabel();
        txtprofesorr = new javax.swing.JTextField();
        lblprecioclase = new javax.swing.JLabel();
        lblpreciomes = new javax.swing.JLabel();
        txtprecioclase = new javax.swing.JTextField();
        txtpreciomes = new javax.swing.JTextField();
        btnnuevo3 = new javax.swing.JButton();
        btncancelar3 = new javax.swing.JButton();
        btnactualizar3 = new javax.swing.JButton();
        btnsalirr = new javax.swing.JButton();
        lbldias = new java.awt.Label();
        txtdias = new javax.swing.JTextField();
        cmbprofesorr = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaclases = new javax.swing.JTable();

        mmodificar.setText("Modificar");
        mmodificar.setName("Modificar"); // NOI18N
        mmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mmodificar);

        meliminar.setText("Eliminar");
        meliminar.setName("Eliminar"); // NOI18N
        meliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(meliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("NUEVA CLASE");

        txtcodigoc.setBackground(new java.awt.Color(240, 240, 240));
        txtcodigoc.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        btnguardar3.setText("Agregar");
        btnguardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar3ActionPerformed(evt);
            }
        });

        lblcodigoc.setText("Codigo:");

        lblclase.setText("Clase:");

        txtclase.setBackground(new java.awt.Color(240, 240, 240));
        txtclase.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        lblprofesorr.setText("Profesor/a:");

        txtprofesorr.setBackground(new java.awt.Color(240, 240, 240));
        txtprofesorr.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        txtprofesorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprofesorrActionPerformed(evt);
            }
        });

        lblprecioclase.setText("Precio por clase:");

        lblpreciomes.setText("Precio por mes:");

        txtprecioclase.setBackground(new java.awt.Color(240, 240, 240));
        txtprecioclase.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        txtpreciomes.setBackground(new java.awt.Color(240, 240, 240));
        txtpreciomes.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        btnnuevo3.setText("Nuevo");
        btnnuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo3ActionPerformed(evt);
            }
        });

        btncancelar3.setText("Cancelar");
        btncancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar3ActionPerformed(evt);
            }
        });

        btnactualizar3.setText("Actualizar");
        btnactualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizar3ActionPerformed(evt);
            }
        });

        btnsalirr.setText("Salir");
        btnsalirr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirrActionPerformed(evt);
            }
        });

        lbldias.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lbldias.setText("Dias:");

        txtdias.setBackground(new java.awt.Color(240, 240, 240));
        txtdias.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        cmbprofesorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbprofesorrActionPerformed(evt);
            }
        });

        tablaclases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaclases.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tablaclases);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblprecioclase)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtprecioclase, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblcodigoc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcodigoc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblprofesorr)
                                    .addComponent(lblclase))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtclase, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbprofesorr, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtprofesorr, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btncancelar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnguardar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnnuevo3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsalirr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnactualizar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblpreciomes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpreciomes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbldias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtdias, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodigoc)
                            .addComponent(lblclase)
                            .addComponent(txtclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprecioclase)
                            .addComponent(txtprecioclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprofesorr)
                            .addComponent(cmbprofesorr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprofesorr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblpreciomes)
                                    .addComponent(txtpreciomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbldias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnguardar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnnuevo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnactualizar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalirr)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar3ActionPerformed
        String cod,clas,precc,precm,proff,profff,dias;
            String sql="";
            cod=txtcodigoc.getText();
            clas=txtclase.getText();
            precc=txtprecioclase.getText();
            precm=txtpreciomes.getText();
            proff=txtprofesorr.getText();
            dias=txtdias.getText();
            profff=cmbprofesorr.getSelectedItem().toString();
                        
            sql="INSERT INTO clases (cod_clase,nom_clase, nom_proff,precio_clase,precio_mes,dias) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, cod);
            pst.setString(2, clas);
            pst.setString(3, precc);
            pst.setString(4, precm);
            pst.setString(5, proff);
            pst.setString(6, dias);
                      
            int n=pst.executeUpdate();
            if(n>0){
            JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
            bloquear();
            }
            cargar("");
        } catch (SQLException ex) {
            Logger.getLogger(ClasesDisponibles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnguardar3ActionPerformed

    private void btnactualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizar3ActionPerformed
        try {
        PreparedStatement pst = cn.prepareStatement("UPDATE clases SET nom_clase='"
                +txtclase.getText()+ "',precio_clase='"
                +txtprecioclase.getText()+ "',nom_prof='"
                +cmbprofesorr.getSelectedItem()+ "',precio_mes='"
                +txtpreciomes.getText()+"',dias='"
                +txtdias.getText() + "' WHERE cod_prof='"+txtcodigoc.getText()+"'");
        pst.executeUpdate();
        cargar("");
          bloquear();
    } catch (Exception e) {
        System.out.print(e.getMessage());
    }
    
                    
    }//GEN-LAST:event_btnactualizar3ActionPerformed

    private void btnsalirrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirrActionPerformed
this.dispose();      
    }//GEN-LAST:event_btnsalirrActionPerformed

    private void btnnuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo3ActionPerformed
    desbloquear();
     limpiar();
     codigosclases();
     txtcodigoc.requestFocus();
    }//GEN-LAST:event_btnnuevo3ActionPerformed

    private void btncancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar3ActionPerformed
     bloquear(); 
    }//GEN-LAST:event_btncancelar3ActionPerformed

    private void txtprofesorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprofesorrActionPerformed
   
    }//GEN-LAST:event_txtprofesorrActionPerformed

    private void cmbprofesorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbprofesorrActionPerformed
    txtprofesorr.setText(cmbprofesorr.getSelectedItem().toString());
    }//GEN-LAST:event_cmbprofesorrActionPerformed

    private void meliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meliminarActionPerformed
      int fila= tablaclases.getSelectedRow();
    String cod="";
    cod=tablaclases.getValueAt(fila, 0).toString();
    if(fila>=0)
    {
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM clases WHERE cod_clase='"+cod+"'");
            pst.executeUpdate();
            cargar("");
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
    }
           
    }//GEN-LAST:event_meliminarActionPerformed

    private void mmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmodificarActionPerformed
      desbloquear();
     btnactualizar3.setEnabled(true);
    int filamodificar= tablaclases.getSelectedRow();
    if(filamodificar>=0)
    {
        txtcodigoc.setText(tablaclases.getValueAt(filamodificar, 0).toString());
        txtclase.setText(tablaclases.getValueAt(filamodificar, 1).toString());
        cmbprofesorr.setSelectedItem(tablaclases.getValueAt(filamodificar, 3).toString());
        txtdias.setText(tablaclases.getValueAt(filamodificar, 4).toString());
        txtprecioclase.setText(tablaclases.getValueAt(filamodificar, 5).toString());
        txtpreciomes.setText(tablaclases.getValueAt(filamodificar, 6).toString());
    }
     
    }//GEN-LAST:event_mmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar3;
    private javax.swing.JButton btncancelar3;
    private javax.swing.JButton btnguardar3;
    private javax.swing.JButton btnnuevo3;
    private javax.swing.JButton btnsalirr;
    private javax.swing.JComboBox<String> cmbprofesorr;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblclase;
    private javax.swing.JLabel lblcodigoc;
    private java.awt.Label lbldias;
    private javax.swing.JLabel lblprecioclase;
    private javax.swing.JLabel lblpreciomes;
    private javax.swing.JLabel lblprofesorr;
    private javax.swing.JMenuItem meliminar;
    private javax.swing.JMenuItem mmodificar;
    private javax.swing.JTable tablaclases;
    private javax.swing.JTextField txtclase;
    private javax.swing.JTextField txtcodigoc;
    private javax.swing.JTextField txtdias;
    private javax.swing.JTextField txtprecioclase;
    private javax.swing.JTextField txtpreciomes;
    private javax.swing.JTextField txtprofesorr;
    // End of variables declaration//GEN-END:variables

}
