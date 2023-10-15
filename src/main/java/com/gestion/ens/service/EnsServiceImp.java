package com.gestion.ens.service;

import com.gestion.ens.dto.BourceDTO;
import com.gestion.ens.dto.DepenceDTO;
import com.gestion.ens.dto.SourceDTO;
import com.gestion.ens.dto.req.BourseReq;
import com.gestion.ens.dto.req.DepenceReq;
import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.Depence;
import com.gestion.ens.entity.Source;
import com.gestion.ens.entity.TypeDepence;
import com.gestion.ens.exception.BourceException;
import com.gestion.ens.exception.DepenceException;
import com.gestion.ens.exception.SourceException;
import com.gestion.ens.exception.TypeDepenceException;
import com.gestion.ens.mapper.IEnsmapper;
import com.gestion.ens.repository.BourceRepo;
import com.gestion.ens.repository.DepenceRepo;
import com.gestion.ens.repository.SourceRepo;
import com.gestion.ens.repository.TypeDepenceRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@AllArgsConstructor
@Data

public class EnsServiceImp  implements IEnsService{
    BourceRepo bourceRepo;
    SourceRepo sourceRepo;
    IEnsmapper ensMapper;
    DepenceRepo depenceRepo;
    TypeDepenceRepo typeDepenceRepo;




    @Override
    public BourceDTO createBource(BourseReq bourseReq) throws BourceException {
        Optional < Source > source = sourceRepo.findById(bourseReq.getSourceId());
        if(source.isPresent()){
            BourceDTO bourceDTO = new BourceDTO();
            bourceDTO.setRefBource(bourseReq.getRefBourse());
            bourceDTO.setMontant(bourseReq.getMontantBourse());
            bourceDTO.setDate(bourseReq.getDateBourse());
            bourceDTO.setSourceDTO(ensMapper.fromSource(source.get()));
            Bource bource = bourceRepo.save(ensMapper.fromBourseDTO(bourceDTO));
            return ensMapper.fromBourse(bource);
        }else {
            throw new BourceException("source n'esxiste pas");
        }

    }

    @Override
    public BourceDTO updateBource(BourseReq bourseReq) throws BourceException, SourceException {
        Optional<Bource> bource = bourceRepo.findById(bourseReq.getId());
        if (bource == null) {
            throw new BourceException("bource n'existe pas");
        } else {
            Optional<Source> source = sourceRepo.findById(bourseReq.getSourceId());
            if (source.isPresent()) {
                BourceDTO bourceDTO = new BourceDTO();
                bourceDTO.setId(bourseReq.getId());
                bourceDTO.setRefBource(bourseReq.getRefBourse());
                bourceDTO.setMontant(bourseReq.getMontantBourse());
                bourceDTO.setDate(bourseReq.getDateBourse());
                bourceDTO.setSourceDTO(ensMapper.fromSource(source.get()));
                Bource save = bourceRepo.save(ensMapper.fromBourseDTO(bourceDTO));
                return ensMapper.fromBourse(save);

            }else

            throw new SourceException("bource n'existe pas");
        }
    }

    @Override
    public ResponseEntity<String> deleteBource(Long id) {
        if (bourceRepo.findById(id).isPresent()) {
            bourceRepo.deleteById(id);
            return ResponseEntity.ok("Suppression réussie !"); // 200 OK avec message personnalisé
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bource avec id=" + id + " n'existe pas !"); // 404 Not Found avec message personnalisé
        }
    };


    @Override
    public ResponseEntity<String> getBourceByid(Long id) throws BourceException {
        if (bourceRepo.findById(id).isPresent()) {

            return ResponseEntity.ok("llll" + id + "existe  ! \n " +bourceRepo.findById(id).get().toString() );


        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("llll" + id + " n'existe pas !");


    }

    @Override
    public List<Bource> getAllBource() throws BourceException {
      return bourceRepo.findAll();
    }

    @Override
    public SourceDTO createSource(String srcReq) throws SourceException {
        if(srcReq==null){
            throw new SourceException("source invalide !!!!!!!!!!!!!!!");
        }
       SourceDTO sourceDTO=new SourceDTO();
       sourceDTO.setObjSource(srcReq);
       Source source= sourceRepo.save(ensMapper.fromSourceDTO(sourceDTO));
       return ensMapper.fromSource(source);
    }

    @Override
    public SourceDTO updateSource(SourceDTO sourceDT) throws SourceException {
        if(sourceDT==null){
            throw new SourceException("source invalide !!!!!!!!!!!!!!!");
        }else {
            SourceDTO sourceDTO = new SourceDTO();
            sourceDTO.setId(sourceDT.getId());
            sourceDTO.setObjSource(sourceDT.getObjSource());
            Source sour = sourceRepo.save(ensMapper.fromSourceDTO(sourceDTO));
            return ensMapper.fromSource(sour);

        }



    }

    @Override
    public Object deleteSource(Long id) throws SourceException {
        if(sourceRepo.findById(id).isPresent()){
            sourceRepo.deleteById(id);
        }else {
            throw new SourceException("id non valide");
        }
     return null;
    }

    @Override
    public Optional<Source> getSource(Long id) throws SourceException {
        if (sourceRepo.findById(id) == null) {
            throw new SourceException("bource avec id=" + id + "n'existe pas !!!!!!!!!!!!!!!!!!!!");
        }
        else
   return sourceRepo.findById(id);
    }

    @Override
    public List<Source> getAllsource() {
        return sourceRepo.findAll();
    }





    @Override
    public DepenceDTO createDepence(DepenceReq depenceReq) throws DepenceException ,BourceException ,TypeDepenceException{
        Optional < Bource > bource = bourceRepo.findById(depenceReq.getBourceid());
        Optional <TypeDepence> typeDepence = typeDepenceRepo.findById(depenceReq.getTypeDepenceid());
        if(bource.isPresent() && typeDepence.isPresent()) {

            DepenceDTO depenceDTO = new DepenceDTO();
            depenceDTO.setRefDepence(depenceReq.getRefDepence());
            depenceDTO.setDateDepence(depenceReq.getDateDepence());
            depenceDTO.setMontant(depenceReq.getMontant());
            depenceDTO.setBourceDTO(ensMapper.fromBourse(bource.get()));
            depenceDTO.setTypeDepenceDTO(ensMapper.fromTypeDepence(typeDepence.get()));

            Depence save = depenceRepo.save(ensMapper.fromDepenceDTO(depenceDTO));
            return ensMapper.fromDepence(save);

        }
        else {
            throw new DepenceException("er");
        }

    }

    @Override
    public DepenceDTO updateDepence(DepenceReq depenceReq) throws DepenceException, BourceException, TypeDepenceException {
        Optional<Depence> depence = depenceRepo.findById(depenceReq.getId());
        Optional<Bource> bource = bourceRepo.findById(depenceReq.getBourceid());
        Optional<TypeDepence> typeDepence = typeDepenceRepo.findById(depenceReq.getTypeDepenceid());
        if (depence == null) {
            throw new DepenceException("rrr");
        } else if (bource.isPresent() && typeDepence.isPresent()) {

            DepenceDTO depenceDTO = new DepenceDTO();
            depenceDTO.setId(depenceReq.getId());
            depenceDTO.setRefDepence(depenceReq.getRefDepence());
            depenceDTO.setDateDepence(depenceReq.getDateDepence());
            depenceDTO.setMontant(depenceReq.getMontant());
            depenceDTO.setBourceDTO(ensMapper.fromBourse(bource.get()));
            depenceDTO.setTypeDepenceDTO(ensMapper.fromTypeDepence(typeDepence.get()));


            Depence save = depenceRepo.save(ensMapper.fromDepenceDTO(depenceDTO));
            return ensMapper.fromDepence(save);

        } else
            throw new BourceException("h");

    }

    @Override
    public Void deleteDepence(Long id) throws DepenceException {

        if(depenceRepo.findById(id).isPresent()){
            depenceRepo.deleteById(id);
        }else{
            throw new DepenceException("gff");
        }


        return null;
    }

    @Override
    public Optional<Depence> getDepence(Long id) throws DepenceException {
        if (sourceRepo.findById(id) == null) {
            throw new DepenceException("n'existe pas !!!!!!!!!!!!!!!!!!!!");
        }
        else
            return depenceRepo.findById(id);
    }


    @Override
    public List<Depence> getAllDepence() {
        return depenceRepo.findAll();
    }


}
