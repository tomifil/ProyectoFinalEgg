package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Foto;
import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.errores.ErrorServicio;
import java.io.IOException;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GuiaServicio implements UserDetailsService{
    
    @Autowired
    private GuiaRepositorio guiaRepositorio;
    
    // HACER NOTIFICACION
//    @Autowired
//    private NotificacionServicio notificacionServicio;
    
    private FotoServicio fotoServicio;
 
@Transactional
    public void registrarGuia(MultipartFile archivo, long dni, String nombre, String apellido, String email, String clave) throws ErrorServicio, IOException{
        validar(dni,nombre,apellido,email,clave);
        
        Guia guia = new Guia();
        guia.setDni(dni);
        guia.setNombre(nombre);
        guia.setApellido(apellido);
        guia.setEmail(email);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        guia.setClave(encriptada);
        
        Foto foto= fotoServicio.guardar(archivo);
        guia.setFoto(foto);
        
        guiaRepositorio.save(guia);
    }
    
@Transactional
    public void modificar(MultipartFile archivo, long dni, String nombre, String apellido, String email, String clave) throws ErrorServicio{
        validar(dni,nombre,apellido,email,clave);
        Optional<Guia> respuesta= guiaRepositorio.findById(dni);
        if (respuesta.isPresent()){
            Guia guia = respuesta.get();
            guia.setNombre(nombre);
            guia.setApellido(apellido);
            guia.setEmail(email);
            
            
        }
    }
    
    public void validar(long dni, String nombre, String apellido, String email, String clave) throws ErrorServicio{
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio ("El nombre no puede estar vacío");
        }
        if (apellido == null || apellido.isEmpty()){
            throw new ErrorServicio ("El apellido no puede estar vacío");
        }
        if (email == null || email.isEmpty()){
            throw new ErrorServicio ("El email no puede estar vacío");
        }
        if (clave == null || clave.isEmpty()){
            throw new ErrorServicio ("La clave no puede estar vacío");
        }
    }
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
