package com.gestion.ens.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Bource {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String refBource;
    private Date date ;
    private double montant ;
   @ManyToOne
   @JoinColumn(name = "source_id")
    private Source source ;




}
