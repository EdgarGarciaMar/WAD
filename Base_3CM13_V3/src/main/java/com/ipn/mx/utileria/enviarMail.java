/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.utileria;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author edgargarcia
 */
public class enviarMail {

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        try {
            Properties p = new Properties();

            p.setProperty("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", "wad.ipn.mx@gmail.com");//Poner un correo unico
            p.setProperty("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(p);
            MimeMessage elmensaje = new MimeMessage(s);
            elmensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            elmensaje.setSubject(asunto);
            elmensaje.setText(mensaje);

            Transport t = s.getTransport("smtp");
            t.connect(p.getProperty("mail.smtp.user"), "1A2B3C4D");//contraseña del correo
            t.sendMessage(elmensaje, elmensaje.getAllRecipients());
            t.close();

        } catch (AddressException ex) {
            Logger.getLogger(enviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(enviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        enviarMail email = new enviarMail();
        String destinatario = "wad.ipn.mx@gmail.com";
        String asunto = "Prueba de java mail";
        String texto = "Correo de prueva ejecutado de forma exitosa...";
        email.enviarCorreo(destinatario, asunto, texto);
    }
}
