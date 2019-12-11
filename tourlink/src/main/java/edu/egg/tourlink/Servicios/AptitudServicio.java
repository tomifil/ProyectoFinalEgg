/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Aptitud;

import edu.egg.tourlink.Repositorios.AptitudRepositorio;
import edu.egg.tourlink.Errores.ErrorServicio;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AptitudServicio implements UserDetailsService {

    @Autowired
    private AptitudRepositorio aptitudRepositorio;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void agregarDescripcion(String descripcion, String dni, String email, String clave) throws ErrorServicio {

        validar(dni, email, clave);

        Aptitud aptitud = new Aptitud();
        aptitud.setDescripcion(descripcion);

        aptitudRepositorio.save(aptitud);

    }

    public void modificarDescripcion(String dni, String descripcion, String email, String clave) throws ErrorServicio {
        validar(dni, email, clave);

        Optional<Aptitud> respuesta = aptitudRepositorio.findById("uuid");
        if (respuesta.isPresent()) {
            Aptitud aptitud = respuesta.get();
            aptitud.setDescripcion(descripcion);

            aptitudRepositorio.save(aptitud);
        }
    }

    public void eliminarDescripcion(String descripcion, String dni, String email, String clave) throws ErrorServicio {

        validar(dni, email, clave);

        Optional<Aptitud> respuesta = aptitudRepositorio.findById("uuid");
        if (respuesta.isPresent()) {
            Aptitud aptitud = respuesta.get();
            aptitud.setDescripcion(descripcion);

            aptitudRepositorio.delete(aptitud);
        }
    }

    private void validar(String dni, String email, String clave) throws ErrorServicio {

        if (dni == null || dni.isEmpty()) {
            throw new ErrorServicio("El DNI no puede ser nulo.");
        }

        if (email == null || email.isEmpty()) {
            throw new ErrorServicio("El e-mail de usuario no puede ser nulo.");
        }

        if (clave == null || clave.isEmpty() || clave.length() < 6) {
            throw new ErrorServicio("La clave de usuario no puede ser menor a 6 caracteres o números");
        }
    }
}
