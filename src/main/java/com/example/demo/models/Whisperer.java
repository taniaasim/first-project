package com.example.demo.models;

public class Whisperer {
String message;
	
	public Whisperer(String message) {
		this.message = message;
	}
	
	public String whisper() {
		return message.toLowerCase();
	}
	
}
