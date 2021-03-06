/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Idioma;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bird
 */
@Repository
public interface IdiomaRepositorio extends JpaRepository<Idioma,String>{
    
    @Query("SELECT c FROM Idioma c WHERE c.id = :id ")
    public List<Idioma> buscarPorIdioma(@Param("id") String id) ;
    @Query("Select c From Idioma c WHERE c.tipo_idioma LIKE %"+":q"+"%")
    public String buscarPorNombre(@Param("q") String q);    
}
