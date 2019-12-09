/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.tourlink.Entidades;

import edu.egg.tourlink.Enumeraciones.Puntuacion;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author bird
 */
@Entity
public class Calificacion {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id; //El id hace referencia al QR_CODE
    String extracto;
    
    @ManyToOne
    private Tour id_tour;
    @OneToMany
    private Puntuacion P1,P2,P3,P4,P5;
}
