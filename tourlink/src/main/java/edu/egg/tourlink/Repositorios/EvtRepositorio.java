

package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.EVT;
import edu.egg.tourlink.Entidades.Guia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EvtRepositorio extends JpaRepository<EVT, String>{
    
    
    @Query("SELECT c FROM EVT c WHERE c.usuario.id = :id")
    public EVT buscarEvt(@Param("id")String id);
    
    
    
    @Query("SELECT c FROM EVT  c")
    public List buscarTodos();
    
  // @Query("SELECT c FROM EVT c WHERE c.email = :email")
 //  public EVT buscarPorMail(@Param("mail")String email);
 //   @Query("SELECT c FROM EVT c WHERE c.clave = :clave")
 //  public EVT buscarPorClave(@Param("clave")String clave);
    
}
