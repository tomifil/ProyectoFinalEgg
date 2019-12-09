/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Entidades;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aptitud {
    @Id
    private int id_aptitud;
    private String descripcion;
    
    @ManyToOne
    private Guia dni;
    
    
    public Aptitud() {
    }

    public Aptitud(int id_aptitudes, String descripcion) {
        this.id_aptitud = id_aptitudes;
        this.descripcion = descripcion;
    }

    /**
     * @return the id_aptitudes
     */
    public int getId_aptitudes() {
        return id_aptitud;
    }

    /**
     * @param id_aptitudes the id_aptitudes to set
     */
    public void setId_aptitudes(int id_aptitudes) {
        this.id_aptitud = id_aptitudes;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
