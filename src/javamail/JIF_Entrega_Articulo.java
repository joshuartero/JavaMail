package javamail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MEGAELECTRIC
 * Configurar el correo para que permita el uso de JavaMail, en la siguiente direccion
 * https://accounts.google.com/ServiceLogin/signinchooser?service=accountsettings&passive=1209600&osid=1&continue=https%3A%2F%2Fmyaccount.google.com%2Flesssecureapps&followup=https%3A%2F%2Fmyaccount.google.com%2Flesssecureapps&emr=1&mrp=security&flowName=GlifWebSignIn&flowEntry=ServiceLogin
 */
public class JIF_Entrega_Articulo extends javax.swing.JInternalFrame {

    JCMail mail = new JCMail();
    DefaultTableModel modelo;
    String message;
    cConexion conexion=new cConexion();
    Connection con=conexion.getConnection();
    Statement st; ResultSet rs, rs2, rs3;
    public static char[] password={'c','c','m','p','p','2','0','1','7'};
    
    public JIF_Entrega_Articulo() {
        initComponents();
        modelo=(DefaultTableModel) jTable1.getModel();  
                
        cargarEntrega();
        cargarRecibe();
        cargarArticulos();
        setDefaultEntrega();
    }
    
    String setCodigoNS()
    {   Calendar c = new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH)+1);
        String annio = Integer.toString(c.get(Calendar.YEAR));
            annio=annio.substring(2, 4);
        String hora =c.get(Calendar.HOUR_OF_DAY)+"";
        if(hora.length()==1)
            hora="0"+hora;
        String minutos = c.get(Calendar.MINUTE)+"";
        if(minutos.length()==1)
            minutos="0"+minutos;
        String segundos = c.get(Calendar.SECOND)+"";
        if(segundos.length()==1)
            segundos="0"+segundos;
        return annio+mes+dia+hora+minutos+segundos;
    }
    
    void cargarEntrega()
    {   try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT P.`APELLIDOP`, P.`APELLIDOM`, P.`NOMBRES` FROM Trabajador T INNER JOIN Persona P "
                + "ON T.`DNI`=P.`DNI` ORDER BY P.`APELLIDOP`;");
            while(rs.next())
                jComboBox6.addItem(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+e.toString());}    
    }

    void cargarRecibe()
    {   try
        {   rs=st.executeQuery("SELECT P.`APELLIDOP`, P.`APELLIDOM`, P.`NOMBRES` FROM Trabajador T INNER JOIN Persona P "
                + "ON T.`DNI`=P.`DNI` ORDER BY P.`APELLIDOP`;");
            while(rs.next())
                jComboBox7.addItem(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+e.toString());}    
    }
    
    void cargarArticulos()
    {   try
        {   rs=st.executeQuery("SELECT DESCRIPCION FROM ARTICULO WHERE CANTIDAD >0;");
            while(rs.next())
                jComboBox5.addItem(""+rs.getString(1));
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+e.toString());}    
    }
    
    void setDefaultEntrega()
    {   jComboBox6.setSelectedItem("Ormachea Del Aguila Joshua");
    }
    
    String llenarMensaje()
    {   Calendar c = new GregorianCalendar();
        message="<h1>NOTA DE SALIDA : "+setCodigoNS()+"</h1>\n"+
                "<h4>RECIBIDO : "+jComboBox7.getSelectedItem()+"</h4>\n"+                
                "<h4>---------------------------------</h4>\n"+
                "<h4>Fecha y Hora : "+getFechaHora()+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+"</h4>\n"+
                "<h4>---------------------------------</h4>\n";
        for(int i=0;i<modelo.getRowCount();i++)
            message=message+"<h4>"+modelo.getValueAt(i, 0)+" "+modelo.getValueAt(i, 1)+"</h4>\n";
        message+="<h4>---------------------------------</h4>\n"+
        "<h3>ENTREGADO : "+jComboBox6.getSelectedItem()+"</h3>\n"+
        "<h4>AREA : "+jTextField2.getText()+"</h4>\n"+
        "<h6>NOTA: Los materiales entregados disminuyen del stock total de nuestro almacen, a su vez estan siendo cargados al record de retiro de materiales de cada trabajador y de cada Area</h6>";  
        return message;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("NOTA DE SALIDA");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setText("Articulo");

        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel17.setText("Cantidad");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Articulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jButton2.setText("Quitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Stock");

        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel12.setText("Entrega");

        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel13.setText("Recibe");

        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel15.setText("Area");

        jTextField2.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox7, 0, 216, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(modelo.getRowCount()!=0)
        {   mail.setFrom( "logisticaccmpp@gmail.com" );
            mail.setPassword( password );
            String correoDestinatario=correoTrabajador(jComboBox7.getSelectedItem().toString());
            if(correoDestinatario.length()!=0)
            {   mail.setTo( correoDestinatario );
                mail.setSubject( "Nota de Salida Nº "+setCodigoNS() );
                mail.setMessage( llenarMensaje() );
                mail.destinatarios[0]="joshua_as@hotmail.com";
                mail.destinatarios[1]="jormachea@procesosproductivos.com";
        //                mail.destinatarios[2]="joshua_as@hotmail.com";
        //                mail.destinatarios[3]="joshua_as@hotmail.com";
                int opc=JOptionPane.showConfirmDialog(this,"ESTA SEGURO QUE DESEA ENVIAR ESTE CORREO ?","",JOptionPane.YES_NO_OPTION);
                if(opc==JOptionPane.YES_OPTION)
                {   if(mail.SEND())
                        guardarEnBD();
                }            
            }
            else JOptionPane.showMessageDialog(this, "Destinatario No cuenta con correo");            
        }
        else JOptionPane.showMessageDialog(this, "Agrege almenos un articulo");            
    }//GEN-LAST:event_jButton1ActionPerformed
    
    void guardarEnBD()
    {   
        try
        {   for(int i=0;i<modelo.getRowCount();i++)
            {   st.executeUpdate("INSERT INTO Nota_salida VALUES ('"+setCodigoNS()+"','"+codigoTrabajador(jComboBox6.getSelectedItem().toString())+"',"
                + "'"+codigoTrabajador(jComboBox7.getSelectedItem().toString())+"','"+getFechaHora()+"','"+getIdArea()+"',"
                + "'"+getCodArticulo(""+modelo.getValueAt(i, 1))+"','"+modelo.getValueAt(i, 0)+"');");
            }              
            jTextField9.setText("");
            limpiarTabla();
            JOptionPane.showMessageDialog(this, "Nota de Salida Registrada !");
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
    }
    
    String correoTrabajador(String nombresApellidos)
    {   String correo="";
        try
        {   rs=st.executeQuery("SELECT T.Correo FROM Trabajador T INNER JOIN Persona P ON T.`DNI`=P.`DNI`WHERE "
                + "CONCAT(P.`APELLIDOP`, ' ',P.`APELLIDOM`, ' ',P.`NOMBRES`)='"+nombresApellidos+"';");
            if(rs.next())
                correo=rs.getString(1);
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
        return correo;  
    }    
    
    String codigoTrabajador(String nombresApellidos)
    {   String codigo="";
        try
        {   rs=st.executeQuery("SELECT T.Codigo FROM Trabajador T INNER JOIN Persona P ON T.`DNI`=P.`DNI`WHERE "
                + "CONCAT(P.`APELLIDOP`, ' ',P.`APELLIDOM`, ' ',P.`NOMBRES`)='"+nombresApellidos+"';");
            if(rs.next())
                codigo=rs.getString(1);
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
        return codigo;  
    }  
    
    String getFechaHora()
    {   String fechaHora="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fechaHora=sdf.format(dt);
        return fechaHora;
    }
    
    String getIdArea()
    {   String id="";
        try
        {   rs=st.executeQuery("SELECT Id FROM AREA WHERE AREA='"+jTextField2.getText()+"';");
            if(rs.next())
                id=rs.getString(1);
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
        return id;        
    }
    
    String getCodArticulo(String articulo)
    {   String cod="";
        try
        {   rs=st.executeQuery("SELECT Codigo FROM articulo WHERE Descripcion='"+articulo+"';");
            if(rs.next())
                cod=rs.getString(1);
        }
        catch(SQLException e){  JOptionPane.showMessageDialog(this, "Error Debido a : "+e.toString());}
        return cod;        
    }
    
    void limpiarTabla()
    {   int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--)           
            modelo.removeRow(jTable1.getRowCount()-1);        
    }  
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(!articuloEnLista(jComboBox5.getSelectedItem()+""))
       {    if(validarCantidad())
            {   Object[] row={jTextField9.getText(), jComboBox5.getSelectedItem()};
                modelo.addRow(row);        
            }
       }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    boolean articuloEnLista(String articulo)
    {   boolean encontrado=false;
        for(int i=0;i<modelo.getRowCount();i++)
        {   if(((String)modelo.getValueAt(i, 1)).compareTo(articulo)==0)
            {   JOptionPane.showMessageDialog(this, "Articulo ya en lista");
                encontrado=true;
            }
        }
        return encontrado;
    }
    
    boolean validarCantidad()
    {   boolean ok=true;
        if(jTextField9.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "Porfavor Ingrese Cantidad");
            jTextField9.requestFocus();
            ok=false;
        }
        else if(Integer.parseInt(jTextField1.getText())<Integer.parseInt(jTextField9.getText()))
        {   JOptionPane.showMessageDialog(this, "Cantidad Mayor que Stock");
            jTextField9.requestFocus();
            ok=false;
        }
        return ok;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()>=0)
            modelo.removeRow(jTable1.getSelectedRow());
        else
            JOptionPane.showMessageDialog(this, "Porfavor seleccione una fila");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        try
        {   st=con.createStatement();
            rs2=st.executeQuery("SELECT Cantidad FROM ARTICULO WHERE Descripcion='"+jComboBox5.getSelectedItem()+"';");
            if(rs2.next())
                jTextField1.setText(rs2.getString(1));
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+e.toString());} 
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) &&
           (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        try
        {   st=con.createStatement();
            rs3=st.executeQuery("SELECT A.`AREA` FROM Trabajador T INNER JOIN Persona P ON T.`DNI`=P.`DNI` INNER JOIN AREA A "
                    + "ON T.`IDAREA`=A.`ID` WHERE CONCAT(P.`APELLIDOP`, ' ', P.`APELLIDOM`, ' ', P.`NOMBRES`)="
                    + "'"+jComboBox7.getSelectedItem()+"';");
            if(rs3.next())
                jTextField2.setText(rs3.getString(1));
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+e.toString());} 
    }//GEN-LAST:event_jComboBox7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
