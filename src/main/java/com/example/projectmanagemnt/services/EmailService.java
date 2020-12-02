package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.email.ReceiveEmailModel;
import com.example.projectmanagemnt.models.email.SendEmailModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
@RestController
public class EmailService {
    @RequestMapping("/sendEmail")
    public void sendEmail(@RequestBody() SendEmailModel email) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("projectmanagement747@gmail.com", "6230064227");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("projectmanagement747@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
        msg.setSubject(email.getSubject());
        msg.setContent(email.getDescription(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(email.getDescription(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        //attachPart.attachFile("/var/tmp/image19.png");
        //multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);

        System.out.println("sendnnnnnnnnnnnnnnnnnn");
    }

    public  void readGmail() {
        /*this will print subject of all messages in the inbox of sender@gmail.com*/

        String receivingHost = "imap.gmail.com";//for imap protocol

        Properties props2 = System.getProperties();

        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here

        Session session2 = Session.getDefaultInstance(props2, null);

        try {

            Store store = session2.getStore("imaps");

            store.connect(receivingHost, "projectmanagement747@gmail.com", "6230064227");

            Folder folder = store.getFolder("INBOX");//get inbox

            folder.open(Folder.READ_ONLY);//open folder only to read

            Message message[] = folder.getMessages();


            for (int i = 0; i < message.length; i++) {

                //print subjects of all mails in the inbox
                ReceiveEmailModel email = new ReceiveEmailModel();

                email.setSubject(message[i].getSubject());
                // System.out.println((Arrays.stream(message[i].getReplyTo()).spliterator().toString()));
                // System.out.println(message[i].getContentType());
                for (Address address : message[i].getFrom()) {
                    StringBuilder su = new StringBuilder(address.toString());
                    email.setFrom(su.substring(su.indexOf("<") + 1, su.length() - 1));
                }
               email.setDescription(processMessageBody(message[i]));
                new DB().addEmail(email);
                //anything else you want


                System.err.println("------------------------------");
            }

            //close connections

            folder.close(true);

            store.close();

        } catch (Exception e) {

            System.out.println(e.toString());

        }

    }

    public  String processMessageBody(Message message) {
        try {
            Object content = message.getContent(); // check for string
            // then check for multipart
            if (content instanceof String) {
                return content+"";

            } else if (content instanceof Multipart) {
                Multipart multiPart = (Multipart) content;
                return procesMultiPart(multiPart);
            } else if (content instanceof InputStream) {
                InputStream inStream = (InputStream) content;
                int ch;
                String result = "";
                while ((ch = inStream.read()) != -1) {
                    result += ch;
                }
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String  procesMultiPart(Multipart content) {
        try {
            int multiPartCount = content.getCount();
            for (int i = 0; i < multiPartCount; i++) {
                BodyPart bodyPart = content.getBodyPart(i);
                Object o;
                o = bodyPart.getContent();
                if (o instanceof String) {
                  return o+"";
                } else if (o instanceof Multipart) {
                   return (Multipart)o+"";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}


