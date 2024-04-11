package ee.tlu.salat;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ToiduaineEntityController {

    ToiduaineRepository toiduaineRepository;

    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
    }

    //List<ToiduaineEntity> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained(){
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduaine/{nimi}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi){
        return toiduaineRepository.findById(nimi).get();
    }

    /*@PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(@PathVariable String nimi, @PathVariable int valk, @PathVariable int rasv, @PathVariable int sysivesik){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }*/

    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity){
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100){
            return toiduaineRepository.findAll();
        }
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi){
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }


    //localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=10&rasv=10&sysivesik=10
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(@RequestParam int index, @RequestParam String nimi, @RequestParam int valk, @RequestParam int rasv, @RequestParam int sysivesik){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine); //hibrenate kontrollib kas element on juba andmebaasis
        return toiduaineRepository.findAll();
    }

    /*@GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi){
        return "Tere " + nimi;
    }

    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2){
        return arv1 * arv2;
    }*/

    @GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk){
        return toiduaineRepository.findAllByValkGreaterThan(minValk);
    }

    @GetMapping("toiduained-sysivesik/{min}/{max}")
    public List<ToiduaineEntity> toiduainedSysivesik(@PathVariable int min, @PathVariable int max){
        return toiduaineRepository.findAllBySysivesikBetween(min, max);
    }
}
