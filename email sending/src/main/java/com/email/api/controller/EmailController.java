package com.email.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.api.DTO.RequestData;
import com.email.api.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/") 
	public String welcome() {
		return "welcome to email api";
	}
	
	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody RequestData requestData) {
		
		System.out.println(requestData);
		
		String message = requestData.getMessage();
		
		String subject = requestData.getSubject();
		
		String to = requestData.getTo();
		
		String from = "kaushikpra1999@gmail.com";
		
//		emailService.sendEmail(message, subject, to, from);
		
		try {
			emailService.sendMessageWithAttachment(message, subject, to, from);
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
			return "Error occured sending the mail";
		}
		
		return "sent successfully";
	}
}
