
package edu.egg.tourlink.Servicios;

import edu.egg.tourlink.entidades.Tipo_tour;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TipoTourServicio  implements UserDetailsService{
    @PersistenceContext
    private EntityManager em;
    public Tipo_tour buscarPorId(String id){
        return em.find(Tipo_tour.class, id); 
    }
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
