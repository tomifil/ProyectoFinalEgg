package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Tipo_idioma;
import edu.egg.tourlink.entidades.Tipo_tour;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Tour {
    // Atributos
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombre;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String horario;

    @OneToOne
    private Tipo_tour tipo_tour;
    
    @OneToOne
    private Guia guia;
    
    @OneToOne
    private EVT evt;
    
    @Enumerated(EnumType.STRING)
    private Tipo_idioma tipo_idioma;
    
    @OneToMany
    private List<Calificacion> calificaciones;
    
    // Constructores
    public Tour() {
    }

    // Getter & Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Tipo_tour getTipo_tour() {
        return tipo_tour;
    }

    public void setTipo_tour(Tipo_tour tipo_tour) {
        this.tipo_tour = tipo_tour;
    }

    public Tipo_idioma getTipo_idioma() {
        return tipo_idioma;
    }

    public void setTipo_idioma(Tipo_idioma tipo_idioma) {
        this.tipo_idioma = tipo_idioma;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the guia
     */
    public Guia getGuia() {
        return guia;
    }

    /**
     * @param guia the guia to set
     */
    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    /**
     * @return the evt
     */
    public EVT getEvt() {
        return evt;
    }

    /**
     * @param evt the evt to set
     */
    public void setEvt(EVT evt) {
        this.evt = evt;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
