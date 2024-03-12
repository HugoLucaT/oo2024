package ee.tlu.salat;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ToiduaineEntityController {
    List<ToiduaineEntity> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained(){
        return toiduained;
    }

    @GetMapping("toiduaine/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }

    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(@PathVariable String nimi, @PathVariable int valk, @PathVariable int rasv, @PathVariable int sysivesik){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }


    //localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=10&rasv=10&sysivesik=10
    @PutMapping("toiduained/{index}")
    public List<ToiduaineEntity> muudaToiduaine(@RequestParam int index, @RequestParam String nimi, @RequestParam int valk, @RequestParam int rasv, @RequestParam int sysivesik){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.set(index, toiduaine);


        return toiduained;
    }

    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi){
        return "Tere " + nimi;
    }

    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2){
        return arv1 * arv2;
    }
}
