package ee.tlu.kodutoo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TootajapalkController {

    @Autowired
    TootajapalkRepository tootajapalkRepository;


    @GetMapping("tookohad")
    public List<Tootajapalk> getTookohad() {
        return tootajapalkRepository.findAll();
    }

    // --> PathVariable: http://localhost:8080/toidukomponendid/4
    // RequestParam: http://localhost:8080/toidukomponendid?id=4
    @DeleteMapping("tookohad/{id}")
    public List<Tootajapalk> deleteTookoht(@PathVariable String id) {
        tootajapalkRepository.deleteById(id);
        return tootajapalkRepository.findAll();
    }

    @PostMapping("tookohad")
    public List<Tootajapalk> lisaTookoht(@RequestBody Tootajapalk tootajapalk) {
        tootajapalkRepository.save(tootajapalk);
        return tootajapalkRepository.findAll();
    }

}
