import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail {
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String[] args) {
        try {
            Mail mail = new Mail();
            mail.setupServerProperties();
            mail.draftEmail();
            mail.sendEmail();
        } catch (MessagingException | IOException e) {
            e.printStackTrace(); // Print the error for debugging
        }
    }

    private void sendEmail() throws MessagingException {
        String fromUser = "your_email@gmail.com";
        String fromUserPassword = "your_app_password"; // Use App Password
        String emailHost = "smtp.gmail.com";

        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    private MimeMessage draftEmail() throws MessagingException, IOException {
        String[] emailRecipients = {"recipient1@example.com", "recipient2@example.com"};
        String emailSubject = "Test Mail";
        String emailBody = "Test Body of my email";

        mimeMessage = new MimeMessage(newSession);
        for (String recipient: emailRecipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }
        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html"); // Correct content type
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);

        return mimeMessage;
    }

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587"); // Correct port for TLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
}