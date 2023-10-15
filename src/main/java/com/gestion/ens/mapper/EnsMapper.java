package com.gestion.ens.mapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gestion.ens.dto.BourceDTO;
import com.gestion.ens.dto.DepenceDTO;
import com.gestion.ens.dto.SourceDTO;
import com.gestion.ens.dto.TypeDepenceDTO;
import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.Depence;
import com.gestion.ens.entity.Source;
import com.gestion.ens.entity.TypeDepence;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@ToString
public class EnsMapper implements IEnsmapper{

    @Override
    public BourceDTO fromBourse(Bource bource) {
        BourceDTO bourceDTO = new BourceDTO();
        BeanUtils.copyProperties(bource,bourceDTO);
        bourceDTO.setSourceDTO(this.fromSource(bource.getSource()));
        return  bourceDTO;
    }

    @Override
    public Bource fromBourseDTO(BourceDTO bourceDTO) {
       ;Bource bource = new Bource();
        BeanUtils.copyProperties(bourceDTO,bource);
        bource.setSource(this.fromSourceDTO(bourceDTO.getSourceDTO()));
        return  bource;
    }

    @Override
    public DepenceDTO fromDepence(Depence depence) {
        DepenceDTO depenceDTO =new DepenceDTO();
        BeanUtils.copyProperties(depence,depenceDTO);
        depenceDTO.setBourceDTO(this.fromBourse(depence.getBource()));
        depenceDTO.setTypeDepenceDTO(this.fromTypeDepence(depence.getTypeDepence()));
        return depenceDTO;


    }

    @Override
    public Depence fromDepenceDTO(DepenceDTO depenceDTO) {
        Depence depence=new Depence();
        BeanUtils.copyProperties(depenceDTO,depence);
        depence.setBource(this.fromBourseDTO(depenceDTO.getBourceDTO()));
        depence.setTypeDepence(this.fromTypeDepenceDTO(depenceDTO.getTypeDepenceDTO()));
        return depence;
    }

    @Override
    public SourceDTO fromSource(Source source) {
        SourceDTO sourceDTO=new SourceDTO();
        BeanUtils.copyProperties(source,sourceDTO);
        return sourceDTO;
    }

    @Override
    public Source fromSourceDTO(SourceDTO sourceDTO) {
        Source source=new Source();
        BeanUtils.copyProperties(sourceDTO , source);
        return source;
    }

    @Override
    public TypeDepenceDTO fromTypeDepence(TypeDepence typeDepence) {
        TypeDepenceDTO typeDepenceDTO =new TypeDepenceDTO();
        BeanUtils.copyProperties(typeDepence , typeDepenceDTO);
        return typeDepenceDTO;
    }

    @Override
    public TypeDepence fromTypeDepenceDTO(TypeDepenceDTO typeDepenceDTO) {
        TypeDepence typeDepence = new TypeDepence();
        BeanUtils.copyProperties(typeDepenceDTO , typeDepence);
        return typeDepence ;
    }
}
