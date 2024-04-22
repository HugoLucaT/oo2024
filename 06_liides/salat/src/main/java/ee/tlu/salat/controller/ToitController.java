package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Toit;
import ee.tlu.salat.repository.ToitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ToitController {

    @Autowired
    ToitRepository toitRepository;

    public ToitController(ToitRepository toitRepository) {
        this.toitRepository = toitRepository;
    }

    @GetMapping("toit")
    public List<Toit> getToidud(){
        return toitRepository.findAll();
    }

    @DeleteMapping("toit/{id}")
    public List<Toit> deleteToit(@PathVariable Long id){
        toitRepository.deleteById(id);
        return toitRepository.findAll();
    }

    @PostMapping("toit")
    public List<Toit> addToit(@RequestBody Toit toit){
        toitRepository.save(toit);
        return toitRepository.findAll();
    }

    /*function lisaToit(){
    const lisatavToit = {
                "toidukomponendid": [tkNimiRef.current.value],
                "baaspalk": palkRef.current.value
    }
        fetch("http://localhost:8080/tookohad", {
                "method": "POST",
                "body": JSON.stringify(lisatavTK),
                "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
                setTookohad(json);
    })*/
}
