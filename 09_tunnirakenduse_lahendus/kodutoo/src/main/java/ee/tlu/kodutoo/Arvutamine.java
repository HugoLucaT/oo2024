package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class Arvutamine {

    TootajaRepository tootajaRepository;

    public Arvutamine(TootajaRepository tootajaRepository){
        this.tootajaRepository = tootajaRepository;
    }


    @GetMapping("tootajad")
    public List<Tootaja> saaTootajad(){
        return tootajaRepository.findAll();
    }

    @PostMapping("tootajad")
    public List<Tootaja> lisaToiduaine(@RequestBody Tootaja tootaja){
        tootajaRepository.save(tootaja);
        return tootajaRepository.findAll();
    }


    @DeleteMapping("tootajad/{id}")
    public List<Tootaja> kustutaTootaja(@PathVariable Long id){
        tootajaRepository.deleteById(id);
        return tootajaRepository.findAll();
    }


}
