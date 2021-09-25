package com.testJAGQ.testBCI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testJAGQ.testBCI.models.Usuario;
import com.testJAGQ.testBCI.services.ValidationService;

@RestController
@RequestMapping("/usuario")
public class RequestController {
	@Autowired
	ValidationService validar;
	
	// Definimos el post
	@PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public String guardarUsuario(@RequestBody Usuario user){
		
		return validar.guardarUsuario(user);
	}
	
}
