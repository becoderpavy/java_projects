package com.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendEmail {

	public static void main(String[] args) {
		SendEmail se = new SendEmail();
		String msg = se.sendSimpleEmail();
		System.out.println(msg);
	}

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("spring.mail.username")
	private String sender;

	public String sendSimpleEmail() {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo("techlife246@gmail.com");
			mailMessage.setSubject("Email Verification");
			mailMessage.setText("Hello How are you");
			javaMailSender.send(mailMessage);
			return "Mail sent SuccesFully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error while Sending Mail";
		}
	}

}
