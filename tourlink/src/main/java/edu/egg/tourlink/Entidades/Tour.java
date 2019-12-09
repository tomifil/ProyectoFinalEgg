package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Tipo_tour;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Tour {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String horario;

    @Enumerated(EnumType.STRING)
    private Tipo_tour tipo_tour;
    
    
    public Tour(int id, Date fecha, String horario) {
        this.id = id;
        this.fecha = fecha;
        this.horario = horario;
    }
    @OneToMany
    private Idioma idioma;
    
    @OneToMany
    private Calificacion calificacion;
    

    public Tour() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
