package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Calificacion;
import edu.egg.tourlink.Enumeraciones.Puntuacion;

import edu.egg.tourlink.Errores.ErrorServicio;
import edu.egg.tourlink.Repositorios.CalificacionRepositorio;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CalificacionServicio  {

    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    @Transactional
    //Metodo para agregar un idioma
public void agregarCalificacion(String QR) throws ErrorServicio{
    
    Calificacion calificacion = new Calificacion();
    calificacion.setPuntuacion(Puntuacion.P1);
  
    calificacionRepositorio.save(calificacion);
    }
public void validar(Calificacion calificacion) throws ErrorServicio {
        if (calificacion == null) {
            throw new ErrorServicio("La calificacion no puede ser nula.");
        }
}
    

}

