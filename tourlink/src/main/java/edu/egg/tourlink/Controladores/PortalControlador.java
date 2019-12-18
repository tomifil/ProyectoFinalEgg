package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Entidades.Idioma;
import edu.egg.tourlink.Enumeraciones.Tipo_idioma;
import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.Repositorios.TipoTourRepositorio;
import edu.egg.tourlink.Repositorios.TourRepositorio;
import edu.egg.tourlink.Repositorios.UsuarioRepositorio;
import edu.egg.tourlink.Servicios.EVTServicio;
import edu.egg.tourlink.Servicios.GuiaServicio;
import edu.egg.tourlink.Servicios.TourServicio;
import edu.egg.tourlink.entidades.Tipo_tour;
import edu.egg.tourlink.entidades.Usuario;
import edu.egg.tourlink.enumeraciones.Rol;
import java.io.IOException;


import java.util.Date;

import java.util.List;
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
    
    @GetMapping("/verGuias")
    public String guias() {
        return "verGuias.html";
    }
    @GetMapping("/editarEvt")
    public String editarEvt() {
        return "editarEvt.html";
    }
    
    
    

//    Registro de GUÍA
    @Autowired
    GuiaServicio gs;
    
     @Autowired
     TourServicio tourServicio;
     
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
    
    @Autowired
    TourRepositorio tourRepositorio;

    @Autowired
    TipoTourRepositorio tipotourRepositorio;
    
    @PostMapping("/crearGuia")
    public String crearGuia(@RequestParam(required = false, value = "imagen") MultipartFile archivo, @RequestParam(value = "dni") long dni, @RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
            @RequestParam(value = "mail") String mail, @RequestParam(value = "contrasena") String contrasena) throws ErrorServicio, IOException {
        if(!mail.equals(usRep.buscarMail(mail))){
            try {
            gs.registrarGuia(archivo, dni, nombre, apellido, mail, contrasena);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";
        }
        else {
            return"index.html";
        }
    }


    @PostMapping("/crearEvt")
    public String crearEVT(@RequestParam(required = false, value = "imagen") MultipartFile archivo, @RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "razon_social") String razon_social, @RequestParam(value = "direccion") String direccion, @RequestParam(value = "telefono") long telefono,
            @RequestParam(value = "email") String mail, @RequestParam(value = "contrasena") String clave) throws ErrorServicio, IOException {
        if(!mail.equals(usRep.buscarMail(mail))){
        try {
            es.registrarEvt(archivo, legajo_id, razon_social, direccion, telefono, mail, clave);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";    
        }
        else{
            return"index.html";
        }
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
    

    @PostMapping("/buscarGuias")
    public String listadoGuias(@RequestParam(required = false) String q, @RequestParam(required = false) String error, ModelMap modelo) {
        List<Guia> guias;
        if (q != null && !q.isEmpty()) {
            guias = guiaRepositorio.buscarPorNombre(q);
        } else {
            guias = guiaRepositorio.buscarTodos();
        }
        
        modelo.put("q", q);
        modelo.put("guias", guias);
        modelo.put("error", error);

        return "verGuias.html";
    }
    
    @PostMapping("/buscarTipoTour")
    public String listadoTipoTour(@RequestParam(required = false) String q, @RequestParam(required = false) String error, ModelMap modelo) {
        List<Tipo_tour> tipo_tour;
        tipo_tour = guiaRepositorio.buscarTodos();       
//        modelo.put("q", q);
        modelo.put("tipo_tour", tipo_tour);
        modelo.put("error", error);

        return "editarEvt.html";
    }

    
        @PostMapping("/crearTour")
    public String crearTour(@RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "tipo_tour") Tipo_tour tipo_tour, @RequestParam(value = "idioma") Tipo_idioma tipo_idioma, /List<Calificacion> calificaciones,/ @RequestParam(value = "fecha") Date fecha, @RequestParam(value = "horario") String horario) throws ErrorServicio {

        try {
            tourServicio.agregarTour(legajo_id, tipo_tour, tipo_idioma, fecha, horario);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "editarEvt.html";
    }

    @PostMapping("/modificarTour")
    public String modificarTour(@RequestParam(value = "id") String id, @RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "tipo_tour") Tipo_tour tipo_tour, @RequestParam(value = "idioma") Tipo_idioma tipo_idioma, /List<Calificacion> calificaciones,/ @RequestParam(value = "fecha") Date fecha, @RequestParam(value = "horario") String horario) throws ErrorServicio {

        if (tourRepositorio.findById(id) != null) {
            try {
                tourServicio.modificarTour(legajo_id, id, tipo_tour, tipo_idioma, fecha, horario);
            } catch (ErrorServicio e) {
                e.printStackTrace();
                System.out.println("Faltan datos");

            }
        }
        return "editarEvt.html";
    }
   
    @PostMapping("/eliminarTour")
    public String eliminarTour( @RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "id") String id) throws ErrorServicio {

        if (tourRepositorio.findById(id) != null) {
            try {
                tourServicio.eliminarTour(legajo_id, id);
            } catch (ErrorServicio e) {
                e.printStackTrace();
                System.out.println("Datos Incorrectos");

            }
        }
        return "editarEvt.html";
    }

}