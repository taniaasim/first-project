package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import com.example.demo.models.Adder;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("whisper") // The URL to which the form submits                     //submitted message just below
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhh...»") String submittedMessage) { // method name
		Whisperer whisperer = new Whisperer(submittedMessage); // this is the message the user submitted (from the parameter)
		String whisp = whisperer.whisper(); // this is the resulting whisper
		
		ModelAndView mv = new ModelAndView("helloworld/message"); // this is the template it's looking for 
		mv.addObject("pageTitle", title); 
		mv.addObject("message", whisp); 
		return mv;
	}
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String submittedMessage) {
		Yeller yeller = new Yeller(submittedMessage); 
		String yelling = yeller.yell();
		
		ModelAndView mv = new ModelAndView("helloworld/message"); // this is the path src/main/resources/templates/HELLOWWORLD/MESSAGE.HTML
		mv.addObject("pageTitle", title); // first title is what is sitting in the message.html file
		mv.addObject("message", yelling); // the name of the string the variable you're using in message.html inside the mustache braces
		return mv;
	}
	 
	
}
