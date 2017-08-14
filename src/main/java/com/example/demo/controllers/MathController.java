package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Calculator;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller //annotation
@RequestMapping("/math")
public class MathController {

	// http://localhost:8080/math/adder POST
	@PostMapping("adder")
	//HOMEWORK: you have to go back home and you have to get rid of the result 
	public String addTwoNumbers(@RequestParam(name="left") double first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
	@PostMapping("calculator")
	public String makeCalculation(@RequestParam(name="left") double first, @RequestParam(name="right") double second, String operator, Model model) {
		double result = 0;
		Calculator calc = new Calculator(first, second);
		if (operator.equals("add")) {
			result = calc.add();
		} else if (operator.equals("subtract")){
			result = calc.subtract();
		} else if (operator.equals("multiply")) {
			result = calc.multiply();
		} else if (operator.equals("divide")) {
			result = calc.divide();
		} else if (operator.equals("mod")) {
			result = calc.mod();
		} else if (operator.equals("power")) {
			result = calc.power();
		} else if (operator.equals("triangle")) {
			result = calc.triange();
		} else {
			return "helloworld/calculator";
		}
		model.addAttribute("calcd", result);
		return "helloworld/calculation"; 
	}
	
	@GetMapping("adder")
	public String adder() {
		return "helloworld/adder";
	} 
	
	@GetMapping("calculator")
	public String calculator() {
		return "helloworld/calculator"; 
	}
}
