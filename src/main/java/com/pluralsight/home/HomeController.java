package com.pluralsight.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Value("${appication.version}")
	private String verion;
	
	@GetMapping
	public String index() {
		return verion;
	}
}
