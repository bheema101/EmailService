package com.hotel.emailService.model;

import java.io.Serializable;

public class MailDto implements Serializable{
	
	private String bookingMessage;
	private String toEmailAddress;
	private String mailSubject;

	public String getBookingMessage() {
		return bookingMessage;
		
	}

	public void setBookingMessage(String bookingMessage) {
		this.bookingMessage = bookingMessage;
	}

	public String getToEmailAddress() {
		return toEmailAddress;
	}

	public void setToEmailAddress(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	
	
	
	
}
