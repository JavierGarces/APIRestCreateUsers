package com.testJAGQ.testBCI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.testJAGQ.testBCI.models.Usuario;
import com.testJAGQ.testBCI.repository.InformationRepository;

@Service
public class ValidationService {
	@Autowired //d�nde y c�mo se debe realizar la conexi�n (enlace) autom�tica
	InformationRepository infoRepo;
		
	public String guardarUsuario(Usuario user) {
		
		String estado="404 Bad Request";
		String exito = "";
		
		Usuario u = infoRepo.save(user);
		
		if(validarCorreo(u.getEmail())) {
			
			// Si existe un id es porque se cre� el usuario
			if(u.getId()!=null) {
				estado = "201 Created";
				exito = ", " + u.toString();
			}
		}
		else {
			estado = "401 Unauthorized', 'error':'correo ya registrado";
		}
		
		String respuesta = "{'status':'"+estado+"'"+exito+"}";
		
		return respuesta;
	}
	
	private boolean validarCorreo(String correo) {
		// creamos la expresion regular para comparar
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// crea un comparador que har� coincidir la entrada dada con este patr�n
        Matcher comparador = pattern.matcher(correo);
        // mensaje en consola para confirmar
        if (comparador.find() == true)
            System.out.println("El email ingresado es v�lido.");
        else
            System.out.println("El email ingresado es inv�lido.");
        // retornamos el resultado
		return comparador.find();
	}
	
}
