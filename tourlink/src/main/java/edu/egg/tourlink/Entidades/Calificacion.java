
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
    String id; //El id hace referencia al QR_CODE
    String extracto;
    
    @Enumerated(EnumType.STRING)
    Puntuacion puntuacion;
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
    
}
