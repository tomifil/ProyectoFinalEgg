
package edu.egg.tourlink.Repositorios;

import edu.egg.tourlink.Entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepositorio extends JpaRepository<Foto,String> {
    
}
