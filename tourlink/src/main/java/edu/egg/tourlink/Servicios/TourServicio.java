
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Calificacion;
import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Idioma;
import edu.egg.tourlink.Entidades.Tour;
import edu.egg.tourlink.entidades.Tipo_tour;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Repositorios.TourRepositorio;
import edu.egg.tourlink.Errores.ErrorServicio;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TourServicio {
    @Autowired
    private EvtRepositorio evtRepositorio;
    @Autowired
    private TourRepositorio tourRepositorio;
    
    //Creamos el Tour (chequear calificaciones, si va o no. )
    @Transactional
    public void agregarTour(String legajo_id,Tipo_tour tipo_tour, Idioma idioma, /*List<Calificacion> calificaciones,*/ Date fecha,String horario) throws ErrorServicio {

        EVT evt = evtRepositorio.findById(legajo_id).get();

       validar(tipo_tour, idioma, fecha, horario);

        Tour tour = new Tour();
        tour.setTipo_tour(tipo_tour);
        tour.setIdioma(idioma);
        tour.setFecha(fecha);
        /*tour.setCalificaciones(calificaciones);*/
        tour.setHorario(horario);

        tourRepositorio.save(tour);
    }
    //Modificar tour.
         @Transactional
    public void modificarTour(String legajo_id, String id, Tipo_tour tipo_tour, Idioma idioma,/* List<Calificacion> calificaciones,*/ Date fecha,String horario) throws ErrorServicio {

        validar(tipo_tour, idioma, fecha, horario);

        Optional<Tour> respuesta = tourRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Tour tour = respuesta.get();
      
                /*tour.setCalificaciones(calificaciones);*/
                tour.setFecha(fecha);
                tour.setHorario(horario);
                tour.setIdioma(idioma);
                tour.setTipo_tour(tipo_tour);
                
                tourRepositorio.save(tour);

        } else {
            throw new ErrorServicio("No existe una tour con el identificador solicitado");
        }
    }
//Eliminar Tour
     @Transactional
    public void eliminarTour(String legajo_id, String id) throws ErrorServicio {
        Optional<Tour> respuesta = tourRepositorio.findById(id);
        
        if (respuesta.isPresent()) {
            Tour tour = respuesta.get();
            
                tourRepositorio.delete(tour);
                               
            

            } else {
                throw new ErrorServicio("No se encontro el Tour solicitada");
            }
        }
    
    
        
    public void validar(Tipo_tour tipo_tour, Idioma idioma,  Date fecha,String horario) throws ErrorServicio {
        if (tipo_tour == null) {
            throw new ErrorServicio("El tipo de tour no puede ser nulo.");
        }
        
        if (idioma == null) {
            throw new ErrorServicio("Los idiomas del tour no puede ser nulo.");
        }
        if (horario == null || horario.isEmpty()) {
            throw new ErrorServicio("El horario del tour no puede ser nulo o vacio.");
        }
        if (fecha == null ) {
            throw new ErrorServicio("La fecha del tour no puede ser nulo.");
        }
    }
    
}