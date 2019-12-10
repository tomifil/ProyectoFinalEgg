
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Calificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepositorio extends JpaRepository <Calificacion, String>{
    
    @Query ("SELECT c FROM Calificacion c WHERE c.puntuacion= :puntuacion")
    public List<Calificacion> buscarCalificacionPorPuntuacion(@Param("puntuacion") String puntuacion);
    
}
