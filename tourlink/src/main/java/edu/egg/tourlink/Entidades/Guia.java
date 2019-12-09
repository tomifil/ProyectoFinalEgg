package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Disponibilidad_dia;
import edu.egg.tourlink.Enumeraciones.Disponibilidad_turno;
import edu.egg.tourlink.Enumeraciones.Estado;
import edu.egg.tourlink.Enumeraciones.Sexo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private String email;
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
    
//    @OneToOne
//    @ManyToOne
    
    
    
}

