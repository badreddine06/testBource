package com.gestion.ens.dto;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DepenceDTO {
    private Long id ;
    private String refDepence;
    private Date dateDepence ;
    private double montant ;
    @ManyToOne
    @JoinColumn(name = "type_depence")
    private TypeDepenceDTO typeDepenceDTO;
    @ManyToOne @JoinColumn (name = "bource_id")
    private BourceDTO bourceDTO;
}
