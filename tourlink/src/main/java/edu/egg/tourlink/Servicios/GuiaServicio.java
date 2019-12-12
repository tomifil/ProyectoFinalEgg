package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Foto;
import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.Errores.ErrorServicio;
import java.io.IOException;
import java.util.Date;
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
    
    @Autowired
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
        if (!archivo.isEmpty()){
            Foto foto= fotoServicio.guardar(archivo);
            guia.setFoto(foto);
        }else {
            Foto foto= new Foto();
            guia.setFoto(null);
        }
        
        
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
            
            String encriptada = new BCryptPasswordEncoder().encode(clave);
            guia.setClave(encriptada);
            
            String idFoto = null;
            if (guia.getFoto() != null ) {
                idFoto = guia.getFoto().getId();           
            }
            
            Foto foto = fotoServicio.actualizar(idFoto, archivo);
            guia.setFoto(foto);
            
            guiaRepositorio.save(guia);
        } else {
            throw new ErrorServicio("No se encontró");
        }
    }
@Transactional
    public void deshabilitar(long dni) throws ErrorServicio{
        Optional <Guia> respuesta = guiaRepositorio.findById(dni);
        if(respuesta.isPresent()){
            Guia guia= respuesta.get();           

            guiaRepositorio.save(guia);
        }else{
            throw new ErrorServicio("No se encontró el usuario solicitado");
        } 
    }
@Transactional
    public void habilitar(long dni) throws ErrorServicio{
        Optional <Guia> respuesta = guiaRepositorio.findById(dni);
        if(respuesta.isPresent()){
            Guia usuario = respuesta.get();

            guiaRepositorio.save(usuario);
        }else{
            throw new ErrorServicio("No se encontró el usuario solicitado");
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

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        //Guia guia = guiaRepositorio.buscarPorMail(email);
//        VER PERMISOS
//    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
