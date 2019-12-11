
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Calificacion;
import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Idioma;
import edu.egg.tourlink.Entidades.Tour;
import edu.egg.tourlink.Enumeraciones.Tipo_tour;
import edu.egg.tourlink.Repositorios.EvtRepositorio;
import edu.egg.tourlink.Repositorios.TourRepositorio;
import edu.egg.tourlink.Errores.ErrorServicio;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class TourServicio {
    @Autowired
    private EvtRepositorio evtRepositorio;
    @Autowired
    private TourRepositorio tourRepositorio;
    
    //Creamos el Tour
    @Transactional
    public void agregarTour(String legajo_id,Tipo_tour tipo_tour, List<Idioma> idiomas, List<Calificacion> calificaciones, Date fecha,String horario) throws ErrorServicio {

        EVT evt = evtRepositorio.findById(legajo_id).get();

       validar(tipo_tour, idiomas, fecha, horario);

        Tour tour = new Tour();
        tour.setTipo_tour(tipo_tour);
        tour.setIdiomas(idiomas);
        tour.setFecha(fecha);
        tour.setCalificaciones(calificaciones);
        tour.setHorario(horario);

        tourRepositorio.save(tour);
    }
    
    public void validar(Tipo_tour tipo_tour, List<Idioma> idiomas,  Date fecha,String horario) throws ErrorServicio {
        if (tipo_tour == null) {
            throw new ErrorServicio("El tipo de tour no puede ser nulo.");
        }
        
        if (idiomas == null) {
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
