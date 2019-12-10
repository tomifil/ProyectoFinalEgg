/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Entidades;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Aptitud {
    // Atributos
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id_aptitud;
    private String descripcion;
    
    @ManyToOne
    private Guia dni;
    
    // Constructores
    public Aptitud() {
    }

    public Aptitud(String id_aptitud, String descripcion, Guia dni) {
        this.id_aptitud = id_aptitud;
        this.descripcion = descripcion;
        this.dni = dni;
    }

    
    
    // Getter & Setter
    

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

    /**
     * @return the id_aptitud
     */
    public String getId_aptitud() {
        return id_aptitud;
    }

    /**
     * @param id_aptitud the id_aptitud to set
     */
    public void setId_aptitud(String id_aptitud) {
        this.id_aptitud = id_aptitud;
    }

    /**
     * @return the dni
     */
    public Guia getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(Guia dni) {
        this.dni = dni;
    }
    
}
