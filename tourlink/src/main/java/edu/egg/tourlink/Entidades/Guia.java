package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.entidades.Usuario;
import edu.egg.tourlink.Enumeraciones.Disponibilidad_dia;
import edu.egg.tourlink.Enumeraciones.Disponibilidad_turno;
import edu.egg.tourlink.Enumeraciones.Estado;
import edu.egg.tourlink.Enumeraciones.Sexo;
import edu.egg.tourlink.entidades.Tipo_tour;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Guia {

    // Atributos

    @Id
    private long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private long telefono;
    private String educacion;
    private String experiencia;
    private String extracto;
    private String rrss_facebook;
    private String rrss_instagram;
    private String rrss_linkedin;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @Enumerated(EnumType.STRING)  // F, M, Otro
    private Sexo sexo;
    @Enumerated(EnumType.STRING)  // lun, mar, mier, jue, vie, sab, dom
    private Disponibilidad_dia disponibilidad_dia;
    @Enumerated(EnumType.STRING)  // HD Mañana, HD Tarde, FD
    private Disponibilidad_turno disponibilidad_turno;
    @Enumerated(EnumType.STRING)  // Activo o inactivo
    private Estado estado;
    
    @OneToMany
    private List<Aptitud> aptitudes;
    //Agregamos idioma(May,Fran)
    @OneToMany
    private List<Idioma> idiomas;
    //Agregamos tipo tour
    @OneToMany
    private List<Tipo_tour> tipo_tour;

    @OneToOne
    private Foto foto;
    
    @OneToOne
    private Usuario usuario;

    // Constructores
    public Guia() {
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public String getRrss_facebook() {
        return rrss_facebook;
    }

    public void setRrss_facebook(String rrss_facebook) {
        this.rrss_facebook = rrss_facebook;
    }

    public String getRrss_instagram() {
        return rrss_instagram;
    }

    public void setRrss_instagram(String rrss_instagram) {
        this.rrss_instagram = rrss_instagram;
    }

    public String getRrss_linkedin() {
        return rrss_linkedin;
    }

    public void setRrss_linkedin(String rrss_linkedin) {
        this.rrss_linkedin = rrss_linkedin;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Disponibilidad_dia getDisponibilidad_dia() {
        return disponibilidad_dia;
    }

    public void setDisponibilidad_dia(Disponibilidad_dia disponibilidad_dia) {
        this.disponibilidad_dia = disponibilidad_dia;
    }

    public Disponibilidad_turno getDisponibilidad_turno() {
        return disponibilidad_turno;
    }

    public void setDisponibilidad_turno(Disponibilidad_turno disponibilidad_turno) {
        this.disponibilidad_turno = disponibilidad_turno;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Aptitud> getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(List<Aptitud> aptitudes) {
        this.aptitudes = aptitudes;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public List<Tipo_tour> getTipo_tour() {
        return tipo_tour;
    }

    public void setTipo_tour(List<Tipo_tour> tipo_tour) {
        this.tipo_tour = tipo_tour;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
