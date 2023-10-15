package com.gestion.ens.dto;

import com.gestion.ens.entity.Source;
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
public class BourceDTO {
    private Long id;
    private String refBource;
    private Date date ;
    private double montant ;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private SourceDTO sourceDTO  ;
}
