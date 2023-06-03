package com;

import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Send {

	public static void main(String[] args) throws FileNotFoundException {

		// sendEmail();
		sendEmail();
		System.out.println("MAIL SENT SUCESSFULLY");

	}

	private static void sendEmail() {
		// we have to add this

		Properties emailProp = getEmailProp("smtp", "Outlook.office365.com", "25", "false");
		Session session = getEmailSession(emailProp, false, "", "");
		Message msg = null;
		String SUBJECT = "Doctor's Confirmation Mail";
		String CONTENT_TYPE = "text/html";
		try {
			msg = new MimeMessage(session);
			String[] recipients = { "sdey@encoress.com" };

			InternetAddress[] recipAddress = new InternetAddress[recipients.length];
			for (int index = 0; index < recipAddress.length; index++) {
				recipAddress[index] = new InternetAddress(recipients[index].trim());
			}
			msg.setFrom(new InternetAddress("sdey@matson.com"));
			msg.setRecipients(Message.RecipientType.TO, recipAddress);
			msg.setSubject(SUBJECT);
			msg.setContent("", CONTENT_TYPE);

			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText("Dear patient, your appointment is booked.");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);

			Transport.send(msg);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Session getEmailSession(Properties emailProp, boolean isAuthEnabled, final String userid,
			final String password) {
		if (isAuthEnabled) {
			return Session.getInstance(emailProp, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userid, password);
				}
			});
		} else {
			return Session.getInstance(emailProp);
		}
	}

	private static Properties getEmailProp(String protocol, String hostName, String port, String authEnabled) {
		Properties envProp = new Properties();
		envProp.put("mail.store.protocol", "smtp");

		envProp.put("mail.smtp.host", "mailhost.pp.matson.com");//

		envProp.put("mail.debug", "true");// Added New

		envProp.put("mail.smtp.auth", "false");
		return envProp;
	}

}
