package com.testJAGQ.testBCI.services;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.testJAGQ.testBCI.models.Telefono;
import com.testJAGQ.testBCI.models.Usuario;
import com.testJAGQ.testBCI.repository.InformationRepository;

@Service
public class ValidationService {
	@Autowired //dónde y cómo se debe realizar la conexión (enlace) automática
	InformationRepository infoRepo;
		
	public String guardarUsuario(String inputJson) {
		
		String estado;
		String exito = "";
		// cambiamos el json a usuario
		Usuario u = cambiarJSON(inputJson);
		// si es nulo el json no es correcto
		if(u==null)
			estado = "404 Bad Request";
		else {
			// validamos el correo
			if(validarCorreo(u.getEmail())) {
				System.out.println("intentando guardar en bdd");
				u = infoRepo.save(u);
				// Si existe un id es porque se creó el usuario
				if(u.getId()!=null) {
					estado = "201 Created";
					exito = ", " + u.toString();
				}
				// si no se crea el usuario es porque ya existe
				else
					estado = "200 Ok";
			}
			else {
				estado = "401 Unauthorized\", \"error\":\"correo ya registrado";
			}
		}
		// generamos la respuesta de salida
		String respuesta = "{\"status\":\""+estado+"\""+exito+"}";
		
		return respuesta;
	}
	
	private boolean validarCorreo(String correo) {
		// creamos la expresion regular para comparar
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// crea un comparador que hará coincidir la entrada dada con este patrón
        Matcher comparador = pattern.matcher(correo);
        
        // mensaje en consola para confirmar
        if (comparador.find() == true)
            System.out.println("El email ingresado es válido.");
        else
            System.out.println("El email ingresado es inválido.");
        
        // retornamos el resultado
		return comparador.find();
	}
	
	
	private Usuario cambiarJSON(String inputJson) {
		// declaramos el usuario
		Usuario user = null;
		try {
			user = new Usuario();
			
			// manejamos el string como json
			JSONObject jsonbject = new JSONObject(inputJson);
			
			// agregamos los valores del json al usuario
			user.setName(jsonbject.getString("name"));
			user.setEmail(jsonbject.getString("email"));
			user.setPassword(jsonbject.getString("password"));
			
			// obtenemos el array de telefonos
			JSONArray array = new JSONArray(jsonbject.getString("phones"));
			
			// si existen telefonos los incorporamos
			if(array.length()>0) {
				// creamos una lista con los telefonos
				List<Telefono> phones = new ArrayList<Telefono>();
				
				for(int i=0; i < array.length(); i++)   
				{
					Telefono t = new Telefono();
					JSONObject object = array.getJSONObject(i);
					
					t.setNumber((short) object.getInt("number"));
					t.setCitycode((short) object.getInt("citycode"));
					t.setContrycode((short) object.getInt("contrycode"));
					
					phones.add(t);
				}  
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
