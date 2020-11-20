package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Usuario;

@Controller
@RequestMapping("/app")
@PropertySource("classpath:config.properties")
public class IndexController {

	@Value("${msg.index}")
	private String msg;

	@Autowired
	private Environment env;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		// model.addAttribute("titulo", msg);
		model.addAttribute("titulo", env.getProperty("msg.index"));
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("pepe");
		usuario.setApellido("santos");
		usuario.setEmail("pepe@correo.com");

		model.addAttribute("titulo", "Perfil del Usuario");
		model.addAttribute("usuario", usuario);

		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Perfil del Usuario");
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("pepe", "santos", "pepe@correo.com"));
		usuarios.add(new Usuario("diego", "santos", "diego@correo.com"));
		usuarios.add(new Usuario("luis", "santos", "luis@correo.com"));
		usuarios.add(new Usuario("antonio", "santos", "antonio@correo.com"));
		return usuarios;
	}

	@GetMapping("/calculo")
	public String calculo(@RequestParam Integer value, Model model) {
		model.addAttribute("value", "El valor es: " + value);
		return "index";
	}

}
