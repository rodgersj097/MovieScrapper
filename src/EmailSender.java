import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class EmailSender {
        public static void main(String[] args) {
            String recipient = "rodgersj097@gmail.com";
            String sender = "rodgersj097@gmail.com";
            String host = "smtp.gmail.com";
            String port = "465";
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.port", port);
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.socketFactory.port", port);
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.socketFactory.fallback", "false");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.ssl.checkserveridentity", "false");
            properties.put("mail.smtp.ssl.trust", "*");
            properties.put("mail.smtp.connectiontimeout", "10000");

            Session session = Session.getDefaultInstance(properties, new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("rodgersj097@gmail.com", "Password");
                }

            });

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sender));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("New Movies at Barrie Theatre");
                message.setText(String.valueOf(Scrapper.getMovies()));

                Transport.send(message);
            } catch (AddressException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

