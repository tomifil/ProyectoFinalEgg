/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Servicios.EVTServicio;
import edu.egg.tourlink.Servicios.GuiaServicio;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
   /*   @Autowired
    EvtRepositorio evtRepositorio;

    @PostMapping("/index.html")
    public String ingresar(@RequestParam(value = "mail") String mail, @RequestParam(value = "contrasena") String clave) throws ErrorServicio {
      try {
            evtRepositorio.buscarPorMail(mail);
            evtRepositorio.buscarPorClave(clave);

        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Usuario o contraseña incorrecta");
        }
        
       
        return "/ingresoevt.html"; 
    }
 */

}
