
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Guia;
import edu.egg.tourlink.Entidades.Idioma;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiaRepositorio extends JpaRepository<Guia, Long> {
    
    @Query("SELECT c FROM Guia c WHERE c.usuario.email = :email")
    public Guia buscarPorMail(@Param("email")String email);
    
//    @Query("SELECT c FROM Guia c WHERE c.clave = :clave")
 //   public Guia buscarPorClave(@Param("clave")String clave);

/*    public Optional<Guia> findById(String id);
   //Buscar por idioma
   public List<Guia>findByIdioma(List<Idioma> idiomas);
   //Buscar por Direccion0
   public List<Guia>findByDireccion(String direccion);
   //Buscar por Estado
   public List<Guia>findByEstado(String estado);
   //Buscar por tipo de tour
   public List<Guia>findByTipoTour(String tipo_tour);
   //Buscar por tipo de tour
   public List<Guia>findByDisponibilidadDia(String tipo_tour);
   //Buscar por tipo de tour
   */
   //public List<Guia>findByTipoTour(String tipo_tour);
//   public List<Guia>findByTipoTour(String tipo_tour);

   
   
}
