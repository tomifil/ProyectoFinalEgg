
package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Entidades.Tour;
import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.Repositorios.TourRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/guia")
public class GuiaControlador {
    
        @Autowired
    GuiaRepositorio guiaRepositorio;
        
        @Autowired
        TourRepositorio tourRepositorio;
        
        @PostMapping("/verToursAsignados")
    public String listadoTours(@RequestParam(required = false) String q, @RequestParam(required = false) String error, ModelMap modelo) {
       
        List<Tour> tour;
        if (q != null && !q.isEmpty()) {
            tour = tourRepositorio.buscarPorNombre(q);
        } else {
            tour = tourRepositorio.buscarTodos();
        }

        modelo.put("q", q);
        modelo.put("tour", tour);
        modelo.put("error", error);

        return "verGuias.html";
    }
    
    
}
