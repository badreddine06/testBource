package com.gestion.ens.mapper;

import com.gestion.ens.dto.BourceDTO;
import com.gestion.ens.dto.DepenceDTO;
import com.gestion.ens.dto.SourceDTO;
import com.gestion.ens.dto.TypeDepenceDTO;
import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.Depence;
import com.gestion.ens.entity.Source;
import com.gestion.ens.entity.TypeDepence;

public interface IEnsmapper {
    BourceDTO fromBourse(Bource bourse);
    Bource fromBourseDTO(BourceDTO bourseDTO);

    DepenceDTO fromDepence(Depence depence);
    Depence fromDepenceDTO(DepenceDTO depenceDTO);

    SourceDTO fromSource(Source source);
    Source fromSourceDTO(SourceDTO sourceDTO);

    TypeDepenceDTO fromTypeDepence(TypeDepence typeDepence);
    TypeDepence fromTypeDepenceDTO(TypeDepenceDTO typeDepenceDTO);
}
