package com.email.api.DTO;

public class RequestData {

	private String message;
	
	private String subject;
	
	private String to;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "RequestData [message=" + message + ", subject=" + subject + ", to=" + to + "]";
	}
	
}
