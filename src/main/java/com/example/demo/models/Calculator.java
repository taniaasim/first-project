package com.example.demo.models;

public class Calculator {
	double input1;
	double input2;
	
	public Calculator(double first, double second) {
		input1 = first;
		input2 = second;
	}
	
	public double add() {
		return input1 + input2;
	}
	
	public double subtract() {
		return input1 - input2;
	}
	
	public double multiply() {
		return input1 * input2;
	}
	
	public double divide() {
		return input1 / input2;
	}
	
	public double mod() {
		return input1 % input2;
	}
	
	public double power() {
		return Math.pow(input1, input2);
	}
	
	public double triange() {
		return (180 - input1 - input2);
	}
	
}
