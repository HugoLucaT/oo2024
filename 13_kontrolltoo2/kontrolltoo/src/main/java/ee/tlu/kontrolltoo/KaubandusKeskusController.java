package ee.tlu.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KaubandusKeskusController {
    @Autowired
    KaubandusKeskusRepository kaubandusKeskusRepository;
    @Autowired
    PoodRepository poodRepository;

    @GetMapping("kaubanduskeskus")
    public List<KaubandusKeskus> getMalls() {
        return kaubandusKeskusRepository.findAll();
    }

    @PostMapping("kaubanduskeskus")
    public List<KaubandusKeskus> postMall(@RequestBody KaubandusKeskus kaubandusKeskus) {
        kaubandusKeskusRepository.save(kaubandusKeskus);
        return kaubandusKeskusRepository.findAll();
    }

    @GetMapping("saa-poed/{kaubanduskeskus}")
    public List<Pood> getShopsFromMall(@PathVariable String kaubanduskeskus){
        List<Pood> poed = new ArrayList<>();
        for (Pood p : poodRepository.findAll()){
            System.out.println(p);
            if (Objects.equals(p.kaubandusKeskus.nimetus, kaubanduskeskus)){
                poed.add(p);
            }
        }
        return poed;
    }

    @GetMapping("saa-poed/{kaubanduskeskus}/{kellaaeg}")
    public List<Pood> getOpenShopsFromMall(@PathVariable String kaubanduskeskus, @PathVariable int kellaaeg){
        List<Pood> poed = new ArrayList<>();
        for (Pood p : poodRepository.findByAvatudLessThanEqualAndSuletudGreaterThan(kellaaeg, kellaaeg)){
            System.out.println(p);
            if (Objects.equals(p.kaubandusKeskus.nimetus, kaubanduskeskus)){
                poed.add(p);
            }
        }
        return poed;
    }

    @GetMapping("koige-rohkem-kulastajaid/{kaubanduskeskus}")
    public Pood getMostVisitorsFromMall(@PathVariable String kaubanduskeskus){
        for (Pood p : poodRepository.findByKulastanudNotNullOrderByKulastanudDesc()){
            if (Objects.equals(p.kaubandusKeskus.nimetus, kaubanduskeskus)){
                return p;
            }
        }
        return null;
    }
}
