/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.entidades.Usuario;
import edu.egg.tourlink.Enumeraciones.Transporte;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class EVT {
    // Atributos
    @Id
    private String legajo_id;
    private String razon_social;
    private String direccion;
    private long telefono;
    private String sitio_web;
    private String horario_atencion;
    private String rrss_facebook;
    private String rrss_instagram;
    private String rrss_linkedin;


    @Enumerated(EnumType.STRING) //Si tiene, no tiene,(o no sabe si tiene) transporte.
    private Transporte transporte;

    @OneToMany
    private List<Tour> tours;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String horario;
   
    @OneToOne
    private Foto foto;
    
    @OneToOne
    private Usuario usuario;
    
    // Constructores
    public EVT() {
    }

    /**
     * @return the legajo_id
     */
    public String getLegajo_id() {
        return legajo_id;
    }

    /**
     * @param legajo_id the legajo_id to set
     */
    public void setLegajo_id(String legajo_id) {
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
     * @return the transporte
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * @param transporte the transporte to set
     */
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    /**
     * @return the tours
     */
    public List<Tour> getTours() {
        return tours;
    }

    /**
     * @param tours the tours to set
     */
    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the foto
     */
    public Foto getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
}
