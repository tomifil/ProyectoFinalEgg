/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class EVT {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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

    /**
     * @return the legajo_id
     */
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
    
    
}
