/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.Servicios.EVTServicio;
import edu.egg.tourlink.Servicios.GuiaServicio;
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

    @PostMapping("/crear")
    public String crear(@RequestParam(required = false, value = "imagen") MultipartFile archivo, @RequestParam(value = "dni") long dni, @RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
            @RequestParam(value = "mail") String mail, @RequestParam(value = "contrasena") String contrasena) throws ErrorServicio, IOException {
        try {
            gs.registrarGuia(archivo, dni, nombre, apellido, mail, contrasena);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";
    }
// Registro de EVT
    @Autowired
    EVTServicio es;

    @PostMapping("/crearEvt")
    public String crearEVT(@RequestParam(required = false, value = "imagen") MultipartFile archivo, @RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "razon_social") String razon_social, @RequestParam(value = "direccion") String direccion, @RequestParam(value = "telefono") long telefono,
            @RequestParam(value = "email") String email, @RequestParam(value = "contrasena") String clave) throws ErrorServicio, IOException {
        try {
            es.registrar(archivo, legajo_id, razon_social, direccion, telefono, email, clave);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";
    }

//Login de EVT
/*      @Autowired
    EvtRepositorio evtRep;

    @PostMapping("/")
    public String ingresarEvt(@RequestParam(value = "mail") String mail, @RequestParam(value = "contrasena") String clave) throws ErrorServicio {
      
        if (evtRep.buscarPorMail(mail) != null) { 
            EVT evt = evtRep.buscarPorMail(mail);
            
            if(evt.getClave().equals(clave)){
                return "/editarEvt.html";
            }
        }
          return "index.html";
    }
*/
    //Login de Guia
      @Autowired
      GuiaRepositorio guiaRep;

    @GetMapping("/login")
    public String ingresarGuia(@RequestParam(value = "email") String email, @RequestParam(value = "contrasena") String clave, ModelMap modelo) throws ErrorServicio {
      
        if (guiaRep.buscarPorMail(email) != null){ 
            Guia  guia = guiaRep.buscarPorMail(email);
            
            if(new BCryptPasswordEncoder().matches(clave, guia.getUsuario().getClave())){
                modelo.put("guia",guia);
                return "/editarGuia.html";
            }
        }
          return "redirect:/loginGuia";
    }
}
