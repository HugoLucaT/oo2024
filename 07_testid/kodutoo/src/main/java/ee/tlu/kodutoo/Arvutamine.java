package ee.tlu.kodutoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Arvutamine {
    //List<Integer> numbrid = new ArrayList<>(); // imiteerime andmebaasi

    @Autowired
    TestRepository tootajaRepository;


    @GetMapping("tootajad")
    public List<Tootaja> saaTootajad(){
        return tootajaRepository.findAll();
    }

    @PostMapping("lisatootaja/{nimi}/{tookoht}/{palk}")
    public List<Tootaja> lisaTootaja(@PathVariable String nimi, @PathVariable String tookoht, @PathVariable int palk){
        Tootaja uusTootaja = new Tootaja(nimi, tookoht, palk);
        tootajaRepository.save(uusTootaja);
        return tootajaRepository.findAll();
    }

    @DeleteMapping("tootajad/{nimi}")
    public List<Tootaja> kustutaTootaja(@PathVariable String nimi){
        tootajaRepository.deleteById(nimi);
        return tootajaRepository.findAll();
    }

    @PutMapping("tootajad/{index}/{nimi}/{tookoht}/{palk}")
    public List<Tootaja> muudaTootaja(@PathVariable int index, @PathVariable String nimi, @PathVariable String tookoht, @PathVariable int palk){
        Tootaja uusTootaja = new Tootaja(nimi, tookoht, palk);
        tootajaRepository.save(uusTootaja);
        return tootajaRepository.findAll();
    }
}