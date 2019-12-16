
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Repositorios.UsuarioRepositorio;
import edu.egg.tourlink.entidades.Usuario;
import edu.egg.tourlink.enumeraciones.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicio {
       @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Transactional
    public Usuario registrarUsuario(String email, String clave, Rol rol) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(encriptada);
        usuario.getClave();
        usuario.setRol(rol);
        
        usuarioRepositorio.save(usuario);
                
        return usuario;    
        
    }
    
}
