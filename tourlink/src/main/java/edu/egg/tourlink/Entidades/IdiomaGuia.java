
package edu.egg.tourlink.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class IdiomaGuia {
    // Atributos
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToOne
    Idioma idioma;
    
    // Constructores
    public IdiomaGuia(){}

    public IdiomaGuia(String id, Idioma idioma) {
        this.id = id;
        this.idioma = idioma;
    }
    
    
    // Getter & setter
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
