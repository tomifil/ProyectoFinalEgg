
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
    Nivel_idioma nivel_idioma;
    @Enumerated(EnumType.STRING)
    Tipo_idioma tipo_idioma;
    
    
}
