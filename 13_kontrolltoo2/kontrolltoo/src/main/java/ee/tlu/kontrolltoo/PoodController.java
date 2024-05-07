package ee.tlu.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PoodController {
    @Autowired
    PoodRepository poodRepository;

    @GetMapping("poed")
    public List<Pood> getShops() {
        return poodRepository.findAll();
    }

    @PostMapping("poed")
    public List<Pood> postShop(@RequestBody Pood pood) {
        System.out.println(pood.suletud);
        for (Pood p: poodRepository.findAll()){
            if (Objects.equals(p.kaubandusKeskus.nimetus, pood.kaubandusKeskus.nimetus)){
                if (pood.suletud < p.suletud + 2){
                    poodRepository.save(pood);
                    System.out.println(pood.suletud);
                    System.out.println(p.suletud);
                    return poodRepository.findAll();
                }
            }
        }

        return poodRepository.findAll();
    }

    @DeleteMapping("poed/{id}")
    public List<Pood> deleteShop(@PathVariable Long id) {
        poodRepository.deleteById(id);
        return poodRepository.findAll();
    }

    @GetMapping("poed-lahti/{kellaaeg}")
    public List<Pood> tooteHindVahemik(@PathVariable int kellaaeg){
        return poodRepository.findByAvatudLessThanEqualAndSuletudGreaterThan(kellaaeg, kellaaeg);
    }

    @GetMapping("koige-rohkem-kulastajaid")
    public Pood largestShop() {
        return poodRepository.findFirstByKulastanudNotNullOrderByKulastanudDesc();
    }


    @GetMapping("lisavisiit/{id}")
    public List<Pood> addVisit(@PathVariable Long id) {
        for (Pood p : poodRepository.findAll()){
            if (p.id == id){
                p.kulastanud ++;
                poodRepository.save(p);
                return poodRepository.findAll();
            }
        }
        return poodRepository.findAll();
    }

    /*@GetMapping("lisavisiit/{id}")
    public List<Pood> addVisit(@PathVariable Long id) {
        Pood pood = poodRepository.getById(id);
        pood.kulastanud ++;
        poodRepository.save(pood);
        return poodRepository.findAll();
    }*/
}
