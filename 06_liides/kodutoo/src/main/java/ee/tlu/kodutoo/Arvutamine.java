package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class Arvutamine {
    //List<Integer> numbrid = new ArrayList<>(); // imiteerime andmebaasi

    TootajaRepository tootajaRepository;

    public Arvutamine(TootajaRepository tootajaRepository){
        this.tootajaRepository = tootajaRepository;
    }

    /*@GetMapping("arvud")
    public List<Integer> saaArvud(){
        return numbrid;
    }

    @PostMapping("lisa/{arv}")
    public void lisaArv(@PathVariable int arv){
        numbrid.add(arv);
    }

    @DeleteMapping("kustuta/{index}")
    public void kustutaArv(@PathVariable int index){
        numbrid.remove(index);
    }

    @GetMapping("mitu")
    public int mitu(){
        return numbrid.size();
    }

    @GetMapping("summa")
    public int summa(){
        int summa = 0;
        for (int n: numbrid){
            summa += n;
        }
        return summa;
    }

    @GetMapping("keskmine")
    public int keskmine(){
        int summa = 0;
        for (int n: numbrid){
            summa += n;
        }
        return summa/numbrid.size();
    }*/

    //List<Tootaja> tootajad = new ArrayList<>();

    @GetMapping("tootajad")
    public List<Tootaja> saaTootajad(){
        return tootajaRepository.findAll();
    }

    @PostMapping("tootajad")
    public List<Tootaja> lisaToiduaine(@RequestBody Tootaja tootaja){
        tootajaRepository.save(tootaja);
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

    /*@GetMapping("tootajad/palk")
    public int palk(){
        int palk = 0;

        for (Tootaja t: tootajad){
            palk += t.palk;
        }
        return palk;
    }*/
}
