
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.EVT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EvtRepositorio extends JpaRepository<EVT, String>{
//    @Query("SELECT c FROM EVT c WHERE c.legajo_id = :legajo_id")
//    public EVT buscarPorLegajo(@Param("legajo_id")int legajo_id);
}
