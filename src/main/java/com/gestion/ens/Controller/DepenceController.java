package com.gestion.ens.Controller;

import com.gestion.ens.dto.DepenceDTO;

import com.gestion.ens.dto.req.DepenceReq;
import com.gestion.ens.entity.Depence;
import com.gestion.ens.exception.BourceException;
import com.gestion.ens.exception.DepenceException;
import com.gestion.ens.exception.TypeDepenceException;
import com.gestion.ens.service.IEnsService;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/depence")
@AllArgsConstructor
@ToString


public class DepenceController {

    IEnsService iEnsService;
    @PostMapping("/create")
    public DepenceDTO createDepence(@RequestBody  DepenceReq depenceReq) throws DepenceException, BourceException, TypeDepenceException {
        return iEnsService.createDepence(depenceReq);
    }
    @PutMapping("/update")
    public DepenceDTO updateDepence(@RequestBody  DepenceReq depenceReq) throws DepenceException, BourceException, TypeDepenceException {
        return iEnsService.updateDepence(depenceReq);
    }
    @DeleteMapping("/delete/{id}")
    public Void deleteDepence(@PathVariable (value = "id") Long id) throws  DepenceException {
        return iEnsService.deleteDepence(id);
    }
    @GetMapping("/getbyid/{id}")
    public Optional<Depence> getDepence(@PathVariable(value = "id")Long id) throws DepenceException {
        return iEnsService.getDepence(id);
    }
    @GetMapping("/getAll")
    public List<Depence> getAllDepence() {
        return iEnsService.getAllDepence();
    }

}
