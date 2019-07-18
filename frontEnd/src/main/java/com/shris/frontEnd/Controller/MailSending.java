package com.shris.frontEnd.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
public class MailSending {

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String toemail, String subject, String message) {
		try {
			SimpleMailMessage semail = new SimpleMailMessage();
			semail.setTo(toemail);
			semail.setSubject(subject);
			semail.setText(message);
			System.out.println(toemail);
			mailSender.send(semail);
		} catch (Exception eMail) {
			System.out.println("fd" + eMail.getMessage());
		}

	}

	public String generateToken() {

		String token = UUID.randomUUID().toString();
		System.out.println("Token: " +token);
		String substring = token.substring(0, 9);
		String splitstring = substring.replace("-", "");
		return splitstring;
		
	}

}
