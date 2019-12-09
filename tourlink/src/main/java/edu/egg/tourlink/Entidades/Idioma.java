
package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Nivel_idioma;
import edu.egg.tourlink.Enumeraciones.Tipo_idioma;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Idioma {
    // Atributos
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Enumerated(EnumType.STRING)
    private Nivel_idioma nivel_idioma;
    @Enumerated(EnumType.STRING)
    private Tipo_idioma tipo_idioma;
    
    // Constructores
    public Idioma(){}

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

    /**
     * @return the nivel_idioma
     */
    public Nivel_idioma getNivel_idioma() {
        return nivel_idioma;
    }

    /**
     * @param nivel_idioma the nivel_idioma to set
     */
    public void setNivel_idioma(Nivel_idioma nivel_idioma) {
        this.nivel_idioma = nivel_idioma;
    }

    /**
     * @return the tipo_idioma
     */
    public Tipo_idioma getTipo_idioma() {
        return tipo_idioma;
    }

    /**
     * @param tipo_idioma the tipo_idioma to set
     */
    public void setTipo_idioma(Tipo_idioma tipo_idioma) {
        this.tipo_idioma = tipo_idioma;
    }
    
    
}
