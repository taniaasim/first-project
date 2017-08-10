package com.example.demo.models;

public class Yeller {
String message;
	
	public Yeller(String message) {
		this.message = message;
	}
	
	public String yell() {
		return message.toUpperCase();
	}
	
}
