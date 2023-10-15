package com.gestion.ens.Controller;

import com.gestion.ens.dto.BourceDTO;
import com.gestion.ens.dto.req.BourseReq;
import com.gestion.ens.entity.Bource;
import com.gestion.ens.exception.BourceException;
import com.gestion.ens.exception.SourceException;
import com.gestion.ens.service.IEnsService;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bource")
@AllArgsConstructor
@ToString
public class BourceController {

    IEnsService  iEnsService;

    @PostMapping("/create")
    public BourceDTO createBource(@RequestBody BourseReq req) throws BourceException {
        return iEnsService.createBource(req);
    }
    @PutMapping ("/updat")
    public BourceDTO updateBource(@RequestBody BourseReq req) throws BourceException, SourceException {
        return iEnsService.updateBource(req);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletebource(@PathVariable(value = "id")Long id) throws BourceException {
        return iEnsService.deleteBource(id);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<String> getbource(@RequestParam Long id) throws BourceException {
        return iEnsService.getBourceByid(id);
    }
    @GetMapping("/getAll")
    public List<Bource> getAllbource() throws BourceException {
        return iEnsService.getAllBource();
    }

}
