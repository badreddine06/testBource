package com.gestion.ens.Controller;

import com.gestion.ens.dto.SourceDTO;
import com.gestion.ens.entity.Source;
import com.gestion.ens.exception.BourceException;
import com.gestion.ens.exception.SourceException;
import com.gestion.ens.service.IEnsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Data
@ToString
@RequestMapping("/source")
public class SourceController {
    IEnsService iEnsService;

    @PostMapping("/create")
    public SourceDTO createSource(@RequestBody String srcreq) throws SourceException {
        return iEnsService.createSource(srcreq);
    }

    @PutMapping("/updatesrc")
    public SourceDTO updateSource(@RequestBody SourceDTO sourceDT) throws SourceException {
        return iEnsService.updateSource(sourceDT);
    }
    @DeleteMapping("/deletsrc/{id}")
    public Object deletesrc(@PathVariable(value = "id") Long id) throws SourceException {
        return iEnsService.deleteSource(id);

    }
    @GetMapping("/getbyid/{id}")
    public Optional<Source> getsource(@PathVariable(value = "id")Long id) throws SourceException {
        return iEnsService.getSource(id);
    }
    @GetMapping("/getAll")
    public List<Source> getAllsource()  {
        return iEnsService.getAllsource();
    }
}
