/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Errores.ErrorServicio;
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
    @GetMapping("index")
    public String index(){
        return "index.html";
    }
    
//    Registro de cliente
    @Autowired
    GuiaServicio gs;
    
    @PostMapping("/crear")
    public String crear( @RequestParam(value="dni") long dni,@RequestParam(value="nombre") String nombre, @RequestParam(value="apellido") String apellido, 
            @RequestParam(value="mail") String mail,@RequestParam(value="contrasena") String contrasena)throws ErrorServicio, IOException{
        try {
            gs.registrarGuia(null, dni, nombre, apellido, mail, contrasena);
        }catch (ErrorServicio e){
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "index.html";
    }
}
