package com.gestion.ens.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Depence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String refDepence;
    private Date dateDepence ;
    private double montant ;
    @ManyToOne @JoinColumn (name = "type_depence")
    private TypeDepence typeDepence;
    @ManyToOne @JoinColumn (name = "bource_id")
    private Bource bource;


}
