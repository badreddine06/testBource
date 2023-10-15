package com.gestion.ens.service;

import com.gestion.ens.dto.BourceDTO;
import com.gestion.ens.dto.DepenceDTO;
import com.gestion.ens.dto.SourceDTO;
import com.gestion.ens.dto.req.BourseReq;
import com.gestion.ens.dto.req.DepenceReq;
import com.gestion.ens.entity.Bource;
import com.gestion.ens.entity.Depence;
import com.gestion.ens.entity.Source;
import com.gestion.ens.exception.BourceException;
import com.gestion.ens.exception.DepenceException;
import com.gestion.ens.exception.SourceException;
import com.gestion.ens.exception.TypeDepenceException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IEnsService {

    BourceDTO createBource(BourseReq bourseReq) throws BourceException;
    BourceDTO updateBource(BourseReq  bourseReq) throws BourceException, SourceException;
    ResponseEntity<String> deleteBource(Long id) throws BourceException;
    ResponseEntity<String> getBourceByid(Long id) throws BourceException;
    List<Bource> getAllBource() throws BourceException;

    SourceDTO createSource (String srcReq) throws SourceException;
    SourceDTO updateSource(SourceDTO sourceDT) throws SourceException;
    Object deleteSource(Long id) throws SourceException;
    Optional<Source> getSource(Long id) throws SourceException;
    List<Source> getAllsource();


    DepenceDTO createDepence (DepenceReq depenceReq ) throws DepenceException, BourceException, TypeDepenceException;
    DepenceDTO updateDepence(DepenceReq depenceReq ) throws DepenceException, BourceException, TypeDepenceException;
    Void deleteDepence(Long id) throws DepenceException;
    Optional<Depence> getDepence(Long id) throws DepenceException;
    List<Depence> getAllDepence();




}
