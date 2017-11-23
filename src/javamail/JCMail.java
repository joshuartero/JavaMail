package javamail;

import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.swing.JOptionPane;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

public class JCMail 
{   private String from = "";//tu_correo@gmail.com
    private String password = "";//tu password: 123456 🙂
    private InternetAddress[] addressTo;
    private String Subject = "";//titulo del mensaje
    private String MessageMail = "";//contenido del mensaje
    public String[] destinatarios;

    public JCMail()
    {
    }
    
    void setTamañoDestinatarios(int tamaño)
    {   destinatarios=new String[tamaño];
    }
    
    boolean SEND()
    {   boolean enviado=false;
        try 
        {   Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.user", "usuario");
            props.put("mail.smtp.port", 25);
            
            SMTPAuthenticator auth = new SMTPAuthenticator( getFrom(), getPassword() );
            Session session = Session.getDefaultInstance(props, auth);
            session.setDebug(false);
            //Se crea destino y origen del mensaje
            MimeMessage mimemessage = new MimeMessage(session);            
            InternetAddress addressFrom = new InternetAddress( getFrom() );            
            mimemessage.setFrom(addressFrom);                        
            Address []destinos = new Address[destinatarios.length];//Aqui usamos el arreglo de destinatarios
            for(int i=0;i<destinos.length;i++){
                destinos[i]=new InternetAddress(destinatarios[i]);
            }             
//            mimemessage.setRecipients(Message.RecipientType.TO, addressTo);
            mimemessage.setRecipients(Message.RecipientType.TO, destinos);

            mimemessage.setSubject( getSubject() );
            MimeBodyPart mimebodypart = new MimeBodyPart();
            mimebodypart.setText( getMessage() );
            mimebodypart.setContent( getMessage() , "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimebodypart);            
            mimemessage.setContent(multipart);            
            mimemessage.setSentDate(new Date());
            Transport.send(mimemessage);
            enviado=true;
            JOptionPane.showMessageDialog(null, "Correo enviado. Enjoy!!!");
        } 
        catch (MessagingException ex) 
        {   JOptionPane.showMessageDialog(null, "Error debido a: "+ex.toString());
            enviado=false;
        }
        return enviado;
    }
    //remitente
    public void setFrom(String mail){ this.from = mail; }
    public String getFrom(){ return this.from; }
    //Contraseña
    public void setPassword(char[] value){
        this.password = new String(value);
    }
    public String getPassword(){ return this.password; }
    //destinatarios
    public void setTo(String mails){
        String[] tmp =mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
    }
    public InternetAddress[] getTo(){ return this.addressTo; }
    //titulo correo
    public void setSubject(String value){ this.Subject = value; }
    public String getSubject(){ return this.Subject; }
    //contenido del mensaje
    public void setMessage(String value){ this.MessageMail = value; }
    public String getMessage(){ return this.MessageMail; }

}