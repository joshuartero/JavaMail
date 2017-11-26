package javamail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joshua
 */
public class JIF_Lista_Trabajadores extends javax.swing.JInternalFrame {
    
    cConexion conexion=new cConexion();
    Connection con=conexion.getConnection();
    Statement st;   ResultSet rs;
    DefaultTableModel modelo;
    
    public JIF_Lista_Trabajadores() {
        initComponents();
        listarTrabajadores();
    }
    
    void listarTrabajadores()
    {   try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT T.`CODIGO`, T.`DNI`, P.`NOMBRES`, P.`APELLIDOP`, P.`APELLIDOM`, Pu.`PUESTO`, A.`AREA`, T.Correo "
                    + "FROM Trabajador T INNER JOIN Persona P ON T.`DNI`=P.`DNI` INNER JOIN AREA A ON T.`IDAREA`=A.`ID` "
                    + "INNER JOIN Puesto Pu ON T.`IDPUESTO`=Pu.`ID` ORDER BY T.Codigo;");
            modelo=(DefaultTableModel) jTable1.getModel();
            while(rs.next())
            {   Object rowData[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                modelo.addRow(rowData);
            }
        }
        catch(SQLException e)   {   JOptionPane.showMessageDialog(this,"Error debido a: "+e.toString());}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField(8);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LISTA DE TRABAJADORES");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombres Y Apellidos");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "D.N.I.", "Nombres", "Apellido P", "ApellidoM", "Puesto", "Area", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(240);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_Registrar_Trabajador jdrt=new JD_Registrar_Trabajador(this,true);
        jdrt.setVisible(true);
        if(jdrt.isVisible()==false)
        {   limpiarTabla();
            listarTrabajadores();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void limpiarTabla()
    {   int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--)           
            modelo.removeRow(jTable1.getRowCount()-1);        
    }
    
    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        try
        {   rs=st.executeQuery("SELECT T.`CODIGO`, T.`DNI`, P.`NOMBRES`, P.`APELLIDOP`, P.`APELLIDOM`, Pu.`PUESTO`, A.`AREA`, T.`CORREO` FROM Trabajador T INNER JOIN Persona P ON T.`DNI`=P.`DNI` INNER JOIN AREA A ON T.`IDAREA`=A.`ID` INNER JOIN Puesto Pu ON T.`IDPUESTO`=Pu.`ID` WHERE CONCAT(P.`APELLIDOP`, ' ', P.`APELLIDOM`, ' ', P.`NOMBRES`) LIKE '%"+jTextField1.getText()+"%' ORDER BY T.Codigo");
            limpiarTabla();
            modelo=(DefaultTableModel) jTable1.getModel();
            while(rs.next())
            {   Object rowData[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                modelo.addRow(rowData);
            }
        }
        catch(SQLException e)   {   JOptionPane.showMessageDialog(this,"Error debido a: "+e.toString());}
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
//        if (jTextField1.getText().length()==4)
//            evt.consume();
//        char caracter = evt.getKeyChar();
//        if( ((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/))
//            evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()!=-1)
            mostrarJD_Reg_Trab();
        else JOptionPane.showMessageDialog(this, "Porfavor seleccione un trabajador");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount()==2)
            mostrarJD_Reg_Trab();
    }//GEN-LAST:event_jTable1MouseClicked

    void mostrarJD_Reg_Trab()
    {   JD_Registrar_Trabajador jdrt=new JD_Registrar_Trabajador(this,true);
        jdrt.jButton3.setText("Modificar");
        jdrt.setTitle("Modificar Trabajador");
        jdrt.jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0)+"");
        jdrt.jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"");
        jdrt.jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5)+"");
        jdrt.jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6)+"");
        jdrt.jTextField5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7)+"");
        jdrt.setVisible(true);
        if(jdrt.isVisible()==false)
        {   limpiarTabla();
            listarTrabajadores();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
