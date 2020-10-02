package UserDao;


import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class EmailNotifiaction {
	public  void sendotpemail(String email,String number) {
		String senderEmailId = "priyankamalakolikar11@gmail.com";
		String senderPass ="xxxxx";//enter your password here
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmailId, senderPass);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("otp verification");
			message.setText(number);
			// send message
			Transport.send(message);
			System.out.println("email sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
