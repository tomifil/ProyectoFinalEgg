package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.Entidades.Idioma;
import edu.egg.tourlink.Enumeraciones.Nivel_idioma;
import edu.egg.tourlink.Enumeraciones.Tipo_idioma;
import edu.egg.tourlink.Repositorios.IdiomaRepositorio;
import edu.egg.tourlink.Errores.ErrorServicio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class IdiomaServicio {

    @Autowired
    private IdiomaRepositorio idiomaRepositorio;

    @Transactional
//Metodo para agregar un idioma
    public void agregarIdioma(Nivel_idioma nivel_idioma, Tipo_idioma tipo_idioma) throws ErrorServicio {

        validar(nivel_idioma, tipo_idioma);

        Idioma idioma = new Idioma();

        idioma.setNivel_idioma(nivel_idioma);
        idioma.setTipo_idioma(tipo_idioma);

        idiomaRepositorio.save(idioma);
    }

//Modificar idioma.
    @Transactional
    public void modificarIdioma(long dni, String id, Nivel_idioma nivel_idioma, Tipo_idioma tipo_idioma) throws ErrorServicio {

        validar(nivel_idioma, tipo_idioma);

        Optional<Idioma> respuesta = idiomaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Idioma idioma = respuesta.get();

            idioma.setTipo_idioma(tipo_idioma);
            idioma.setNivel_idioma(nivel_idioma);
            idiomaRepositorio.save(idioma);

        } else {
            throw new ErrorServicio("No existe un idioma con el identificador solicitado");
        }
    }

    //Eliminar idioma
    @Transactional
    public void eliminarIdioma(long dni, String id) throws ErrorServicio {
        Optional<Idioma> respuesta = idiomaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Idioma idioma = respuesta.get();

            idiomaRepositorio.delete(idioma);

        } else {
            throw new ErrorServicio("No se encontro el Idioma solicitado");
        }
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
