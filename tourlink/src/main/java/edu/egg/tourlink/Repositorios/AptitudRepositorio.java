/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Aptitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudRepositorio extends JpaRepository<Aptitud, String> {
    @Query("SELECT c FROM Aptitud c WHERE c.id_aptitud = :id_aptitud")
    public Aptitud buscarPorId(@Param("id_aptitud")String id_aptitud);
}
