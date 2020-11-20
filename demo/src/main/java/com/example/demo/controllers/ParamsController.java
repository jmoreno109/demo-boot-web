package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

	@GetMapping("/listar")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String params(@RequestParam String nombre, @RequestParam String apellido,
			@RequestParam(required = false, defaultValue = "no tiene") String correo, Model model) {

		model.addAttribute("r_nombre", "el nombre es: " + nombre);
		model.addAttribute("r_apellido", "el apellido es: " + apellido);
		model.addAttribute("r_correo", "el correo es: " + correo);
		return "params/ver";

	}

}
