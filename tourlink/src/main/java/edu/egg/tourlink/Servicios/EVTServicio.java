
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Foto;
import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import java.io.IOException;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class EVTServicio {
    @Autowired
    private FotoServicio fotoServicio;
    
    @Autowired
    private EvtRepositorio  evtRepositorio;
   
    
    
    public void registrar (MultipartFile archivo,String legajo_id,String razon_social,String direccion,long telefono,String email,String clave) throws ErrorServicio, IOException{
        
        validar(legajo_id,razon_social,direccion,email,clave);
        
        EVT evt = new EVT();
        evt.setLegajo_id(legajo_id);
        evt.setRazon_social(razon_social);
        evt.setDireccion(direccion);
        evt.setTelefono(telefono);
        
        Foto foto = fotoServicio.guardar(archivo);
        evt.setFoto(foto);
            
        evtRepositorio.save(evt);
        
    }
    
    @Transactional
    public void modificar (MultipartFile archivo, String legajo_id, String razon_social, String direccion, long telefono, String email, String clave) throws ErrorServicio {
        validar(legajo_id, razon_social, direccion, email, clave);
        
        Optional <EVT> respuesta = evtRepositorio.findById(legajo_id);
        if (respuesta.isPresent()) {
            EVT evt = respuesta.get();
            evt.setLegajo_id(legajo_id);
            evt.setRazon_social(razon_social);
            evt.setDireccion(direccion);
            evt.setTelefono(telefono);
           
            String idFoto = null;
            if (evt.getFoto() != null){
                idFoto = evt.getFoto().getId();
            }
            Foto foto = fotoServicio.actualizar(idFoto, archivo);
            evt.setFoto(foto);
            
            evtRepositorio.save(evt);
        } else {
            throw new ErrorServicio(" No se encontro la EVT solicitada");
        }
    }
    
    @Transactional
    public void eliminarEVT (String legajo_id) throws ErrorServicio{
        Optional<EVT> respuesta = evtRepositorio.findById(legajo_id);
        if (respuesta.isPresent()){
            EVT evt = respuesta.get();
            evtRepositorio.delete(evt);
            //evtRepositorio.save(evt); No es necesario guardar despues de eliminarlo
        }else {
            throw new ErrorServicio(" No se encontro la EVT solicitada");
        }
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
