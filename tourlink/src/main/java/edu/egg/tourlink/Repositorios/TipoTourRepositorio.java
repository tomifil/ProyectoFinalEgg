
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.entidades.Tipo_tour;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTourRepositorio extends JpaRepository<Tipo_tour, String>{
    @Query("Select c From Tipo_tour c WHERE c.nombre LIKE %"+":q"+"%")
    public String buscarPorNombre(@Param("q") String q);
    @Query("SELECT c FROM Tipo_tour  c")
    public List buscarTodos();
}
