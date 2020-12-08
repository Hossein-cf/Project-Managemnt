package com.example.projectmanagemnt.test.test;

import com.sun.mail.pop3.POP3Store;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {
//    @RequestMapping("/sendemail")
//    public String sendEmail() {
//        try {
//            sendmail();
//        } catch (Exception e) {
//
//            return e.getMessage();
//        }
//
//        return "Email sent successfully";
//    }

    private static String sendmail() throws AddressException, MessagingException, IOException {
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

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shakryhsyn1@gmail.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        //attachPart.attachFile("/var/tmp/image19.png");
        //multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
        return "sending";

    }

    public static void receiveEmail(String pop3Host, String storeType,
                                    String user, String password) {
        try {
            //1) get the session object
            Properties properties = new Properties();
            properties.put("mail.pop3.host", pop3Host);

            properties.put("mail.pop3.port", "995");
//            properties.put("mail.pop3.starttls.enable", "true");
//            properties.put("mail.pop3.ssl.enable", "false");
//            properties.put("mail.pop3.starttls.required", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //2) create the POP3 store object and connect with the pop server
            POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);
            emailStore.connect(user, password);

            //3) create the folder object and open it
            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //4) retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            //5) close the store and folder objects
            emailFolder.close(false);
            emailStore.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readGmail(String host, String userName, String password) {

        /*this will print subject of all messages in the inbox of sender@gmail.com*/

        String receivingHost = "imap.gmail.com";//for imap protocol

        Properties props2 = System.getProperties();

        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here

        Session session2 = Session.getDefaultInstance(props2, null);

        try {

            Store store = session2.getStore("imaps");

            store.connect(receivingHost, userName, password);

            Folder folder = store.getFolder("INBOX");//get inbox

            folder.open(Folder.READ_ONLY);//open folder only to read

            Message message[] = folder.getMessages();


            for (int i = 0; i < message.length; i++) {

                //print subjects of all mails in the inbox

                System.out.println(message[i].getSubject());
                // System.out.println((Arrays.stream(message[i].getReplyTo()).spliterator().toString()));
                // System.out.println(message[i].getContentType());
                for (Address address : message[i].getFrom()
                ) {
                    StringBuilder su = new StringBuilder(address.toString());
                    System.out.println(su.substring(su.indexOf("<") + 1, su.length() - 1));

                }
                processMessageBody(message[i]);
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

    public static void processMessageBody(Message message) {
        try {
            Object content = message.getContent(); // check for string
            // then check for multipart
            if (content instanceof String) {
                System.out.println(content);

            } else if (content instanceof Multipart) {
                Multipart multiPart = (Multipart) content;
                procesMultiPart(multiPart);
            } else if (content instanceof InputStream) {
                InputStream inStream = (InputStream) content;
                int ch;
                while ((ch = inStream.read()) != -1) {
                    System.out.write(ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void procesMultiPart(Multipart content) {
        try {
            int multiPartCount = content.getCount();
            for (int i = 0; i < multiPartCount; i++) {
                BodyPart bodyPart = content.getBodyPart(i);
                Object o;
                o = bodyPart.getContent();
                if (o instanceof String) {
                    System.out.println(o);
                } else if (o instanceof Multipart) {
                    procesMultiPart((Multipart) o);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {

        String host = "imap.gmail.com";//change accordingly
        String mailStoreType = "pop3";
        String username = "projectmanagement747@gmail.com";
        String password = "6230064227";//change accordingly
/*
        receiveEmail(host, mailStoreType, username, password);
//        try {
//            System.out.println( sendmail());
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }
*/

        readGmail("imap.gmail.com", username, password);

    }
}