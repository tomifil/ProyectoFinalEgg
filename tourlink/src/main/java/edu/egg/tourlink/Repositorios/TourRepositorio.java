
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Tour;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepositorio extends JpaRepository<Tour, String>{
    
//      @Query("Select c FROM Tour c WHERE c.tour.id = :id")
//    public List<Tour> buscarTourPorId(@Param("id") String id);
}
