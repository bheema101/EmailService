package com.hotel.emailService.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.emailService.model.MailDto;
import com.hotel.emailService.service.SendNotification;

@RestController
public class EmailRestService {
	
	@Autowired
	SendNotification sendNotification;
	
	@PostMapping("/sendMail")
	public String sendNotification(@RequestBody MailDto mailDto) {
		sendNotification.sendEmail(mailDto);
		return "successfully send the mail";
	}

}
