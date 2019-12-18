/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Controladores;

import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Entidades.Idioma;
import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Repositorios.GuiaRepositorio;
import edu.egg.tourlink.Repositorios.TipoTourRepositorio;
import edu.egg.tourlink.Repositorios.TourRepositorio;
import edu.egg.tourlink.Servicios.EVTServicio;
import edu.egg.tourlink.Servicios.GuiaServicio;
import edu.egg.tourlink.Servicios.TourServicio;
import edu.egg.tourlink.entidades.Tipo_tour;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/evt")
public class EvtControlador {

    @Autowired
    GuiaServicio gs;

    @Autowired
    GuiaRepositorio guiaRepositorio;

    @Autowired
    EvtRepositorio evtRepositorio;

    @Autowired
    TourServicio tourServicio;

    @Autowired
    TipoTourRepositorio tipotourRepositorio;

    @Autowired
    TourRepositorio tourRepositorio;

    @Autowired
    EVTServicio es;

    @PostMapping("/buscarGuias")//action hecho
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

    @PostMapping("/crearTour")//action hecho
    public String crearTour(@RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "tipo_tour") Tipo_tour tipo_tour, @RequestParam(value = "idioma") Idioma idioma, /*List<Calificacion> calificaciones,*/ @RequestParam(value = "fecha") Date fecha, @RequestParam(value = "horario") String horario) throws ErrorServicio {

        try {
            tourServicio.agregarTour(legajo_id, tipo_tour, idioma, fecha, horario);
        } catch (ErrorServicio e) {
            e.printStackTrace();
            System.out.println("Faltan datos");
        }
        return "editarEvt.html";
    }

    @PostMapping("/modificarTour")
    public String modificarTour(@RequestParam(value = "id") String id, @RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "tipo_tour") Tipo_tour tipo_tour, @RequestParam(value = "idioma") Idioma idioma, /*List<Calificacion> calificaciones,*/ @RequestParam(value = "fecha") Date fecha, @RequestParam(value = "horario") String horario) throws ErrorServicio {

        if (tourRepositorio.findById(id) != null) {
            try {
                tourServicio.modificarTour(legajo_id, id, tipo_tour, idioma, fecha, horario);
            } catch (ErrorServicio e) {
                e.printStackTrace();
                System.out.println("Faltan datos");

            }
        }
        return "editarEvt.html";
    }

    @PostMapping("/eliminarTour")
    public String eliminarTour(@RequestParam(value = "legajo_id") String legajo_id, @RequestParam(value = "id") String id) throws ErrorServicio {

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
