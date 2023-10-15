package com.gestion.ens.dto.req;

import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.TypeDepence;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
 public class DepenceReq {
    private Long id ;
    private String refDepence;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDepence ;
    private double montant ;

    private Long typeDepenceid;

    private Long bourceid;
}
