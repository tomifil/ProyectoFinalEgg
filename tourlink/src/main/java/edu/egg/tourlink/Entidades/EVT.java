/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Transporte;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class EVT {
    @Id
    private int legajo_id;
    private String razon_social;
    private String direccion;
    private long telefono;
    private String sitio_web;
    private String email;
    private String horario_atencion;
    private String rrss_facebook;
    private String rrss_instagram;
    private String rrss_linkedin;

    @ManyToOne
    @Enumerated(EnumType.STRING) //Si tiene, no tiene,(o no sabe si tiene) transporte.
    private Transporte Tiene,NoTiene,NoSabe;

    @OneToMany
    private Tour id_tour;
    @Temporal(TemporalType.TIMESTAMP)
    private Tour fecha;
    @Enumerated(EnumType.STRING)
    private Tour horario;
    
    public EVT() {
    }
    
    
     
    public int getLegajo_id() {
        return legajo_id;
    }

    /**
     * @param legajo_id the legajo_id to set
     */
    public void setLegajo_id(int legajo_id) {
        this.legajo_id = legajo_id;
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the sitio_web
     */
    public String getSitio_web() {
        return sitio_web;
    }

    /**
     * @param sitio_web the sitio_web to set
     */
    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the horario_atencion
     */
    public String getHorario_atencion() {
        return horario_atencion;
    }

    /**
     * @param horario_atencion the horario_atencion to set
     */
    public void setHorario_atencion(String horario_atencion) {
        this.horario_atencion = horario_atencion;
    }

    /**
     * @return the rrss_facebook
     */
    public String getRrss_facebook() {
        return rrss_facebook;
    }

    /**
     * @param rrss_facebook the rrss_facebook to set
     */
    public void setRrss_facebook(String rrss_facebook) {
        this.rrss_facebook = rrss_facebook;
    }

    /**
     * @return the rrss_instagram
     */
    public String getRrss_instagram() {
        return rrss_instagram;
    }

    /**
     * @param rrss_instagram the rrss_instagram to set
     */
    public void setRrss_instagram(String rrss_instagram) {
        this.rrss_instagram = rrss_instagram;
    }

    /**
     * @return the rrss_linkedin
     */
    public String getRrss_linkedin() {
        return rrss_linkedin;
    }

    /**
     * @param rrss_linkedin the rrss_linkedin to set
     */
    public void setRrss_linkedin(String rrss_linkedin) {
        this.rrss_linkedin = rrss_linkedin;
    }

    /**
     * @return the Tiene
     */
    public Transporte getTiene() {
        return Tiene;
    }

    /**
     * @param Tiene the Tiene to set
     */
    public void setTiene(Transporte Tiene) {
        this.Tiene = Tiene;
    }

    /**
     * @return the NoTiene
     */
    public Transporte getNoTiene() {
        return NoTiene;
    }

    /**
     * @param NoTiene the NoTiene to set
     */
    public void setNoTiene(Transporte NoTiene) {
        this.NoTiene = NoTiene;
    }

    /**
     * @return the NoSabe
     */
    public Transporte getNoSabe() {
        return NoSabe;
    }

    /**
     * @param NoSabe the NoSabe to set
     */
    public void setNoSabe(Transporte NoSabe) {
        this.NoSabe = NoSabe;
    }

    /**
     * @return the id_tour
     */
    public Tour getId_tour() {
        return id_tour;
    }

    /**
     * @param id_tour the id_tour to set
     */
    public void setId_tour(Tour id_tour) {
        this.id_tour = id_tour;
    }

    /**
     * @return the fecha
     */
    public Tour getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Tour fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horario
     */
    public Tour getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Tour horario) {
        this.horario = horario;
    }
    
    
}
