
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Guia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiaRepositorio extends JpaRepository<Guia, Long> {
   @Query( "SELECT c FROM Guia c WHERE c.dni = :dni ") 
   public List<Guia> buscarPorGuia (@Param("id") String id);
}
