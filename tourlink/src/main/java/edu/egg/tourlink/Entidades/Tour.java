package edu.egg.tourlink.Entidades;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String horario;

    @OneToOne
    private Tipo_tour tipo_tour;
    
    @OneToMany
    private List<Idioma> idiomas;
    
    @OneToMany
    private List<Calificacion> calificaciones;
    
    // Constructores
    public Tour() {
    }

    public Tour(String id, Date fecha, String horario, Tipo_tour tipo_tour, List<Idioma> idiomas, List<Calificacion> calificaciones) {
        this.id = id;
        this.fecha = fecha;
        this.horario = horario;
        this.tipo_tour = tipo_tour;
        this.idiomas = idiomas;
        this.calificaciones = calificaciones;
    }
    

    // Getter & Setter
    

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

    /**
     * @return the tipo_tour
     */
    public Tipo_tour getTipo_tour() {
        return tipo_tour;
    }

    /**
     * @param tipo_tour the tipo_tour to set
     */
    public void setTipo_tour(Tipo_tour tipo_tour) {
        this.tipo_tour = tipo_tour;
    }

    /**
     * @return the idiomas
     */
    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    /**
     * @param idiomas the idiomas to set
     */
    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    /**
     * @return the calificaciones
     */
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    

}
