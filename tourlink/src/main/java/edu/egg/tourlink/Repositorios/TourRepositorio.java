
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Tour;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepositorio extends JpaRepository<Tour, String>{
    
    @Query("Select c FROM Tour c")
    public List<Tour> buscarTodos();
    
     @Query("Select c From Tour c WHERE c.nombre LIKE %"+":q"+"%")
    public List buscarPorNombre(@Param("q") String q);
    
// buscarPasados @Query("Select c FROM Tour c WHERE fecha<fechaActual")
// buscarConAsignar @Query("Select c FROM Tour c WHERE fecha>fechaActual AND id.guia!=null")
// buscarSinAsignar @Query("Select c FROM Tour c WHERE fecha>fechaActual AND id.guia==null")
}
