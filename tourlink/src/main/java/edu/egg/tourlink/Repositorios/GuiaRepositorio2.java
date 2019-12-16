//package edu.egg.tourlink.Repositorios;
//
//import edu.egg.tourlink.Entidades.Guia;
//import edu.egg.tourlink.Entidades.Idioma;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface GuiaRepositorio2 extends JpaRepository<Guia, String> {
//   
//    @Query("SELECT c FROM Guia c WHERE c.email = :email")
//    public Guia buscarPorMail(@Param("email")String email);
//    
//    @Query("SELECT c FROM Guia c WHERE c.clave = :clave")
//    public Guia buscarPorClave(@Param("clave")String clave);
//}