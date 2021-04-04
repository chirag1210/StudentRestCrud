package com.chirag.angularspringapp.model;

public class Message {

	private String type;
	private String message;
	

	public Message() {
		super();
		
	}

	public Message(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
