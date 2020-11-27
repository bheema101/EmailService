package com.hotel.emailService.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.emailService.service.SendNotification;

@RestController
public class EmailRestService {
	
	@Autowired
	SendNotification sendNotification;
	
	@RequestMapping("/sendMeail")
	public String sendNotification() {
		sendNotification.sendEmail();
		return "successfully send the mail";
	}

}
