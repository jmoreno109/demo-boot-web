package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(@RequestParam Integer value, HttpServletRequest request) {
		request.setAttribute("value", value);
		return "forward:/app/calculo";
	}

}
