package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.TwillioService;
@RestController
public class TwillioRestController {
	@Autowired
	TwillioService twillioService;
	
	@Value("${app.twillio.fromPhoneNo}")
	private String from;
	
	@Value("${app.twillio.toPhoneNo}")
	private String to;

	@GetMapping("/sendSmss")
	public String sendSms() {
		
		String body = "Welcome to our speical event where you can help people";
		twillioService.sendSms(to, from, body);
		return "message sent successfully";
		
		
	}
}
