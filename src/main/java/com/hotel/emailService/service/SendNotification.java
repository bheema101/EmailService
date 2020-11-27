package com.hotel.emailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class SendNotification {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("bheemin518@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);

    }
}
