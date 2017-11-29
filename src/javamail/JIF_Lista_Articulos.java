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
public class JIF_Lista_Articulos extends javax.swing.JInternalFrame {
    
    cConexion conexion=new cConexion();
    Connection con=conexion.getConnection();
    Statement st;   ResultSet rs;
    DefaultTableModel modelo;
    
    public JIF_Lista_Articulos() {
        initComponents();
        
        listarArticulos();
    }
    
    void listarArticulos()
    {   try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT A.`CODIGO`, A.`DESCRIPCION`, TA.`TIPO`, A.`CANTIDAD` FROM ARTICULO A INNER JOIN TIPO_ARTICULO TA "
                + "ON A.`IDTIPOARTICULO`=TA.`ID` Order By A.Descripcion;");
            modelo=(DefaultTableModel) jTable1.getModel();
            while(rs.next())
            {   Object rowData[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
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
        setTitle("LISTA DE ARTICULOS");

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

        jLabel1.setText("Articulo");

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
                "Codigo", "Descripcion", "Tipo", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 420, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_Registrar_Articulo jdra=new JD_Registrar_Articulo(this,true);
        jdra.setCodigo();
        jdra.setVisible(true);
        if(jdra.isVisible()==false)
        {   limpiarTabla();
            listarArticulos();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()!=-1)
            mostrarJD_Reg_Art();
        else JOptionPane.showMessageDialog(this, "Porfavor seleccione un trabajador");
    }//GEN-LAST:event_jButton2ActionPerformed

    void mostrarJD_Reg_Art()
    {   JD_Registrar_Articulo jdrt=new JD_Registrar_Articulo(this,true);
        jdrt.jButton1.setText("Modificar");
        jdrt.setTitle("Modificar Articulo");
        jdrt.jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0)+"");
        jdrt.jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"");
        jdrt.jComboBox1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 2)+"");
        jdrt.jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3)+"");
        jdrt.setVisible(true);
        if(jdrt.isVisible()==false)
        {   limpiarTabla();
            listarArticulos();
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        try
        {   rs=st.executeQuery("SELECT A.`CODIGO`, A.`DESCRIPCION`, TA.`TIPO`, A.`CANTIDAD` FROM Articulo A INNER JOIN Tipo_Articulo TA ON A.`IDTIPOARTICULO`=TA.`ID` WHERE A.`DESCRIPCION`LIKE '%"+jTextField1.getText()+"%' ORDER BY A.`CODIGO`;");
            limpiarTabla();
            modelo=(DefaultTableModel) jTable1.getModel();
            while(rs.next())
            {   Object rowData[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                modelo.addRow(rowData);
            }
        }
        catch(SQLException e)   {   JOptionPane.showMessageDialog(this,"Error debido a: "+e.toString());}
    }//GEN-LAST:event_jTextField1CaretUpdate

    void limpiarTabla()
    {   int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--)           
            modelo.removeRow(jTable1.getRowCount()-1);        
    }
    
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        //        if (jTextField1.getText().length()==4)
        //            evt.consume();
        //        char caracter = evt.getKeyChar();
        //        if( ((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/))
        //            evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount()==2)
            mostrarJD_Reg_Art();
    }//GEN-LAST:event_jTable1MouseClicked


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
