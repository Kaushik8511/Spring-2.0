package com.email.api.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailService {
	
	public void sendEmail(String message, String subject, String to, String from) throws MessagingException {
		
		//variable for gmail host
		String host = "smtp.gmail.com";
		
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("\n\nproperties: \n" + properties);
		
		
//		set important properties
		//set host
		properties.put("mail.smtp.host", host);
		//set port
		properties.put("mail.smtp.port", "465");
		//set ssl
		properties.put("mail.smtp.ssl.enable", true);
		//set auth to true
		properties.put("mail.smtp.auth", true);
		
//		step-1: to get the session object
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "your password");
			}
		});
		session.setDebug(true);
		
//		step-2: compose the message [text, multimedia]
		MimeMessage myMessage = new MimeMessage(session);
		
		//set from
		myMessage.setFrom(from);
		
		//adding recipient
		myMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		myMessage.setSubject(subject);
		
		//adding message body
		myMessage.setText(message);
		
//			step-3: send message using Transport class
		Transport.send(myMessage);
		
		System.out.println("mail sent successfully");
			
	}
	
	
	//sends message with attachments
	public void sendMessageWithAttachment(String message, String subject, String to, String from) throws MessagingException, IOException {
		//variable for gmail host
		String host = "smtp.gmail.com";
		
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("\n\nproperties: \n" + properties);
		
		
//		set important properties
		//set host
		properties.put("mail.smtp.host", host);
		//set port
		properties.put("mail.smtp.port", "465");
		//set ssl
		properties.put("mail.smtp.ssl.enable", true);
		//set auth to true
		properties.put("mail.smtp.auth", true);
		
//		step-1: to get the session object
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "your password");
			}
		});
		session.setDebug(true);
		
//		step-2: compose the message [text, multimedia]
		MimeMessage myMessage = new MimeMessage(session);
		//set from
		myMessage.setFrom(from);
		
		//adding recipient
		myMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		myMessage.setSubject(subject);
		
		//set the attachment
		//File path
		String path = "D:\\Spring 2.0\\file-uploading\\target\\classes\\static\\image\\01-new.jpg";
		MimeMultipart mimeMultipart = new MimeMultipart();
		
		//for text
		MimeBodyPart textMime = new MimeBodyPart();
		textMime.setText("Please find the attached document and revert back for any queries");
		//for file
		MimeBodyPart fileMime = new MimeBodyPart();
		File file = new File(path);
		fileMime.attachFile(file);
		
		mimeMultipart.addBodyPart(textMime);
		mimeMultipart.addBodyPart(fileMime);
		
		myMessage.setContent(mimeMultipart);
		
		
		//adding message body
		myMessage.setText(message);
		
//			step-3: send message using Transport class
		Transport.send(myMessage);
		
		System.out.println("mail sent successfully");
		
	}
	
}
