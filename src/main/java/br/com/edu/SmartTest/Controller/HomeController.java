package br.com.edu.SmartTest.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping({"/Home"})
	public String teste() {
		return "Bem vindo";
	}
	
}
