
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    
     @Query("SELECT c FROM Usuario c WHERE c.email = :email")
    public Usuario buscarPorMail(@Param("email")String email);
    
    @Query("SELECT email FROM Usuario  WHERE email = :email")
    public String buscarMail(@Param("email")String email);
    
    @Query("SELECT c FROM Usuario  c")
    public List buscarTodos();
    
    
}
