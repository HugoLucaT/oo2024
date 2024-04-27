package ee.tlu.proovikontrolltoo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@CrossOrigin(origins = "http://localhost:3000")
public class ToodeController {

    @Autowired
    ToodeRepository toodeRepository;

    @GetMapping("tooted")
    public List<Toode> saaTooted(){
        return toodeRepository.findAll();
    }

    @PostMapping("tooted")
    public List<Toode> lisaTooted(@RequestBody Toode toode){
        toodeRepository.save(toode);
        return toodeRepository.findAll();
    }

    @DeleteMapping("tooted/{id}")
    public List<Toode> kustutaTooted(@PathVariable Long id){
        toodeRepository.deleteById(id);
        return toodeRepository.findAll();
    }

    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<Toode> tooteHindVahemik(@PathVariable double min, @PathVariable double max){
        return toodeRepository.findByHindBetween(min, max);
    }

    @GetMapping("max-hinnaga-toode")
    public Toode maxToode(@PathVariable double min, @PathVariable double max){
        return toodeRepository.findFirstByHindNotNullOrderByHindDesc();
    }
}
