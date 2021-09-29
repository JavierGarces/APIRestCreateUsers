package com.testJAGQ.testBCI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testJAGQ.testBCI.services.ValidationService;

@RestController
@RequestMapping("usuario")
public class RequestController {
	@Autowired
	ValidationService validar;
	
	// Definimos el post
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String guardarUsuario(@RequestBody String inputJson){
		return validar.guardarUsuario(inputJson);
	}
	
}
