package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Repositorios.CalificacionRepositorio;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CalificacionServicio implements UserDetailsService {

    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
    
}

