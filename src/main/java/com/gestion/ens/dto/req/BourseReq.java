package com.gestion.ens.dto.req;

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
public class BourseReq {

        private Long id;
        private String refBourse;
        @Temporal (TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date dateBourse;
        private Double montantBourse;
        private Long sourceId;
    }

