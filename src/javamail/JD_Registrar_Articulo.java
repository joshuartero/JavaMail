package javamail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Joshua
 */
public class JD_Registrar_Articulo extends javax.swing.JDialog {

    JIF_Lista_Articulos jifla;
    cConexion conexion=new cConexion();
    Connection con=conexion.getConnection();
    Statement st;   ResultSet rs;
    
    public JD_Registrar_Articulo(JIF_Lista_Articulos jifla, boolean modal) {
        super(JOptionPane.getFrameForComponent(jifla), modal);
        this.jifla=jifla;
        initComponents();
        cargarTipoArticulo();        
        this.setLocationRelativeTo(this);
    }

    void setCodigo()
    {   try
        {   rs=st.executeQuery("Select MAX(Codigo) From Articulo");
            if(rs.next())
               jTextField1.setText( (Integer.parseInt(rs.getString(1))+1)+"" );
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
    }
    
    void cargarTipoArticulo()
    {   try
        {   st=con.createStatement();
            rs=st.executeQuery("Select Tipo From Tipo_Articulo");
            while(rs.next())
                jComboBox1.addItem(rs.getString(1));
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Codigo");

        jTextField1.setEnabled(false);

        jLabel2.setText("Descripcion");

        jLabel3.setText("Tipo");

        jLabel4.setText("Stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, 298, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        funcion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    void funcion()
    {   if(jButton1.getText().compareTo("Registrar")==0)
        {   if(!camposNoVacios())
            {   int opc=JOptionPane.showConfirmDialog(this, "Desea Registrar Este Articulo?", "CONFIRMAR REGISTRO", JOptionPane.YES_NO_OPTION);
                if(opc==JOptionPane.YES_OPTION)
                {   registrar();
                }
            }   
        }
        if(jButton1.getText().compareTo("Modificar")==0)
        {   if(!camposNoVacios())
            {   int opc=JOptionPane.showConfirmDialog(this, "Desea Modificar Este Articulo?", "CONFIRMAR MODIFICACION", JOptionPane.YES_NO_OPTION);
                if(opc==JOptionPane.YES_OPTION)
                {   modificar();
                }
            } 
        }
    }
    
    boolean camposNoVacios()
    {   boolean vacios=false;
        if(jTextField2.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "Porfavor Ingrese Descripcion");
            jTextField2.requestFocus();
            vacios=true;
        }
        else if(jTextField3.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "Porfavor Ingrese Stock");
            jTextField3.requestFocus();
            vacios=true;
        }        
        return vacios;
    }
    
    void registrar()
    {   try
        {   st=con.createStatement();
            st.executeUpdate("INSERT INTO ARTICULO VALUES ('"+jTextField1.getText()+"','"+jTextField2+"', "
                + "(Select Id from Tipo_Articulo Where Tipo='"+jComboBox1.getSelectedItem()+"') ,'"+jTextField3.getText()+"');");
            JOptionPane.showMessageDialog(this, "Articulo Registrado !");
            dispose();
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
    }
    
    void modificar()
    {   try
        {   st.executeUpdate("Update Articulo Set Descripcion='"+jTextField2.getText()+"', "
                + "IdTipoArticulo=(Select Id From Tipo_Articulo Where Tipo='"+jComboBox1.getSelectedItem()+"'), "
                + "Cantidad='"+jTextField3.getText()+"' Where Codigo='"+jTextField1.getText()+"'");
            JOptionPane.showMessageDialog(this, "Datos Actualizados !");
            dispose();
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
