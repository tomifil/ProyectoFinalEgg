/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.ErrorServicio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author bird
 */
public class EVTServicio {
    
    public void registrar (MultipartFile archivo,String legajo_id,String razon_social,String direccion,long telefono,String email,String clave) throws ErrorServicio{
        validar(legajo_id,razon_social,direccion,email,clave);
        
        EVT evt = new EVT();
        evt.setLegajo_id(legajo_id);
        evt.setRazon_social(razon_social);
        evt.setDireccion(direccion);
        evt.setEmail(email);
        
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        
    }
    
    public void validar(String legajo_id,String razon_social,String direccion,String email,String clave) throws ErrorServicio{
        
        if (razon_social == null || razon_social.isEmpty()) {
            throw new ErrorServicio("La razon social del usuario no puede ser nula");
        }
        
        if (direccion == null || direccion.isEmpty()) {
            throw new ErrorServicio("La direccion del usuario no puede ser nula");
        }
        
        if (email == null || email.isEmpty()) {
            throw new ErrorServicio("El email del usuario no puede ser nulo");
        }
        
        if (clave == null || clave.isEmpty()) {
            throw new ErrorServicio("La clave del usuario no puede ser nula");
        }
        
        if (legajo_id == null || legajo_id.isEmpty()) {
            throw new ErrorServicio("El legajo del usuario no puede ser nulo");
        }
        
    }
}
