package edu.egg.tourlink.servicios;

import edu.egg.tourlink.Entidades.Idioma;
import edu.egg.tourlink.Enumeraciones.Nivel_idioma;
import edu.egg.tourlink.Enumeraciones.Tipo_idioma;
import edu.egg.tourlink.Repositorios.IdiomaRepositorio;
import edu.egg.tourlink.Errores.ErrorServicio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IdiomaServicio {

@Autowired
private IdiomaRepositorio idiomaRepositorio;
    
@Transactional
//Metodo para agregar un idioma
public void agregarIdioma(Nivel_idioma nivel_idioma, Tipo_idioma tipo_idioma) throws ErrorServicio{
    
    validar(nivel_idioma,tipo_idioma);
    
    Idioma idioma = new Idioma();
    
    idioma.setNivel_idioma(nivel_idioma);
    idioma.setTipo_idioma(tipo_idioma);
    
    idiomaRepositorio.save(idioma);
}
//Metodo para validar Nivel y Tipo de idioma 
public void validar(Nivel_idioma nivel_idioma, Tipo_idioma tipo_idioma) throws ErrorServicio {
        if (nivel_idioma == null) {
            throw new ErrorServicio("El Nivel del Idioma no puede ser nulo.");
        }
        if (tipo_idioma == null) {
            throw new ErrorServicio("El Tipo del Idioma no puede ser nulo.");
        }

}

}