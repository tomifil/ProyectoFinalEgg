
package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Puntuacion;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Calificacion {
    // Atributos
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id; //El id hace referencia al QR_CODE
    private String extracto;
    
    @Enumerated(EnumType.STRING)
    private Puntuacion puntuacion;
    @ManyToOne
    private Tour id_tour;
    
    
    // Constructores

    public Calificacion() {
    }

    public Calificacion(String id, String extracto, Tour id_tour, Puntuacion puntuacion) {
        this.id = id;
        this.extracto = extracto;
        this.id_tour = id_tour;
        this.puntuacion=puntuacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Puntuacion puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Tour getId_tour() {
        return id_tour;
    }

    public void setId_tour(Tour id_tour) {
        this.id_tour = id_tour;
    }
    
}
