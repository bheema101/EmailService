package com.hotel.emailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hotel.emailService.model.MailDto;
@Service
public class SendNotification {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(MailDto mailDto) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailDto.getToEmailAddress());
        msg.setSubject(mailDto.getMailSubject());
        msg.setText(mailDto.getBookingMessage());
        javaMailSender.send(msg);

    }
}
