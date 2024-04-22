package ee.tlu.salat.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ToiduaineController {
    List<String> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    @GetMapping("toiduained")
    public List<String> saaToiduained(){
        return toiduained;
    }

    @GetMapping("toiduaine/{index}")
    public String saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }

    //PostMappingut ei saa brauser teha
    //localhost:8080/toiduained/Kartul POST
    @PostMapping("toiduained/{toiduaine}")
    public List<String> lisaToiduaine(@PathVariable String toiduaine){
        toiduained.add(toiduaine);
        return toiduained;
    }

    //DeleteMappingut ei saa brauser teha
    //localhost:8080/toiduained/0 Delete
    @DeleteMapping("toiduained/{index}")
    public List<String> kustutaToiduaine(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }

    //PutMappingut ei saa brauser teha
    @PutMapping("toiduained/{index}")
    public List<String> muudaToiduaine(@PathVariable int index, @PathVariable String newValue){
        toiduained.set(index, newValue);
        return toiduained;
    }

    // localhost:8080/tere
    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi){
        return "Tere " + nimi;
    }

    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2){
        return arv1 * arv2;
    }
}
