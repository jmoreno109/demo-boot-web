package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathVariableController {

	@GetMapping("/variable/{id}/{name}")
	public String variable(@PathVariable Integer id, @PathVariable String name, Model model) {
		model.addAttribute("id", "resultado = " + id + " "+name);
		return "params/path";
	}

}
