
package edu.egg.tourlink.Repositorios;


import edu.egg.tourlink.Entidades.IdiomaGuia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaGuiaRepositorio extends JpaRepository<IdiomaGuia,String> {
    @Query("SELECT c FROM IdiomaGuia c WHERE c.idioma = :idioma")
    public List<IdiomaGuia> buscarIdiomaGuiaPorIdioma(@Param("idioma")String idioma);
}
