package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

	private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String emailadres; //chatgpt
	
	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendEmail(String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("mohamed.azahaf@student.ehb.be");
		message.setFrom(emailadres);
		message.setSubject("NGO Applicatie: " + subject);
		message.setText(body);
		
		mailSender.send(message);
	}
}
