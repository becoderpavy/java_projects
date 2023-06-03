import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void main(String[] args) {
		String msg = "Hello dear,\n \nYour Account Created Sussefully \n"+
				"Your Account No:33196759832 ";
		String subject = "Bank Acccount Created Confirmation";
		String to = "daspabitra55@gmail.com";
		String from = "Forgot Password <no-reply@gmail.com>";

		 SendEmail(msg, subject, to, from);

		//sendAttachment(msg, subject, to, from);

	}

	private static void sendAttachment(String msg, String subject, String to, String from) {
		// variable gmail host
		String host = "smtp.gmail.com";

		// get system properties
		Properties properties = System.getProperties();
		System.out.println(properties);

		// setting important information to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// step-1 get session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("techlife246@gmail.com", "pabitradas1");
			}

		});

		session.setDebug(true);

		// step-2 compose msg
		MimeMessage m = new MimeMessage(session);

		try {
			// from email
			m.setFrom(from);

			// add reciepnt
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// add subject
			m.setSubject(subject);

			// attchment ..

			// file path
			String path = "C:\\Users\\Pabitra\\Downloads\\b.jpg";

			MimeMultipart mpart = new MimeMultipart();
			// text
			// file
			MimeBodyPart textmime = new MimeBodyPart();

			MimeBodyPart filemime = new MimeBodyPart();

			textmime.setText(msg);

			File file = new File(path);
			try {
				filemime.attachFile(file);
				mpart.addBodyPart(textmime);
				mpart.addBodyPart(filemime);

			} catch (IOException e) {
				e.printStackTrace();
			}

			m.setContent(mpart);

			Transport.send(m);

			System.out.println("Send Success");

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void SendEmail(String msg, String subject, String to, String from) {
		// TODO Auto-generated method stub

		// variable gmail host
		String host = "smtp.gmail.com";

		// get system properties
		Properties properties = System.getProperties();
		System.out.println(properties);

		// setting important information to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// step-1 get session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("techlife246@gmail.com", "pabitradas1");
			}
		});
		session.setDebug(true);

		// step-2 compose msg
		MimeMessage m = new MimeMessage(session);
		try {
			// from email
			m.setFrom(from);

			// add reciepnt
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// add subject
			m.setSubject(subject);
			m.setText(msg);

			// step-3 send messgae using transport class
			Transport.send(m);

			System.out.println("Send Success");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
