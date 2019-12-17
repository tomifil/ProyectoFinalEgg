
package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.Repositorios.UsuarioRepositorio;
import edu.egg.tourlink.Servicios.EVTServicio;
import edu.egg.tourlink.Servicios.GuiaServicio;
import edu.egg.tourlink.entidades.Usuario;
import edu.egg.tourlink.enumeraciones.Rol;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @GetMapping({"/", "/home"})
    public String index() {
        return "index.html";
    }

//    Registro de GUÍA
    @Autowired
    GuiaServicio gs;
    
    // Registro de EVT
    @Autowired
    EVTServicio es;
    
    //Login de Guia
    @Autowired
    UsuarioRepositorio usRep;
      
    @Autowired
    GuiaRepositorio guiaRepositorio;
    
    @Autowired
    EvtRepositorio evtRepositorio;

    @PostMapping("/crearGuia")
    public String crearGuia(@RequestParam(required = false, value = "imagen") MultipartFile archivo, @RequestParam(value = "dni") long dni, @RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
            @RequestParam(value = "mail") String mail, @RequestParam(value = "contrasena") String contrasena) throws ErrorServicio, IOException {
        try {
            gs.registrarGuia(archivo, dni, nombre, apellido, mail, contrasena);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";
    }


    @PostMapping("/crearEvt")
    public String crearEVT(@RequestParam(required = false, value = "imagen") MultipartFile archivo, @RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "razon_social") String razon_social, @RequestParam(value = "direccion") String direccion, @RequestParam(value = "telefono") long telefono,
            @RequestParam(value = "email") String email, @RequestParam(value = "contrasena") String clave) throws ErrorServicio, IOException {
        try {
            es.registrarEvt(archivo, legajo_id, razon_social, direccion, telefono, email, clave);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";
    }

   
    @PostMapping("/login")
    public String ingresar(@RequestParam(value = "email") String email, @RequestParam(value = "contrasena") String clave, ModelMap modelo) throws ErrorServicio {
      
        if (usRep.buscarPorMail(email) != null){ 
            Usuario  usuario = usRep.buscarPorMail(email);
            
            if(new BCryptPasswordEncoder().matches(clave, usuario.getClave())){

                
                if (usuario.getRol() == Rol.Guia){
                    Guia guia = guiaRepositorio.buscarGuia(usuario.getId());
                    modelo.put("guia",guia);
                return "editarGuia.html";  
                } else {
                    EVT evt = evtRepositorio.buscarEvt(usuario.getId());
                    modelo.put("evt", evt);
                    return "editarEvt.html";
                }
                
            }
        }
          return "redirect:/home";
    }
}