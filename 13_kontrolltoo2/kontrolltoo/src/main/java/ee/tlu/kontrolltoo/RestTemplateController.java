package ee.tlu.kontrolltoo;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestTemplateController {
    @GetMapping("saa-inimesed")
    public List<People> getPeople(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Info> response = restTemplate.exchange("https://reqres.in/api/users?page=2", HttpMethod.GET,null , Info.class);
        Info info = response.getBody();
        ArrayList<People> people = info.getData();
        return people;
        //return Arrays.asList(response.getBody().getData());
    }

    @GetMapping("saa-inimeste-email")
    public List<String> getPeopleEmail(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Info> response = restTemplate.exchange("https://reqres.in/api/users?page=2", HttpMethod.GET,null , Info.class);
        Info info = response.getBody();
        ArrayList<People> people = info.getData();
        List<String> emails = new ArrayList<>();
        for (People p : people){
            emails.add(p.email);
        }
        return emails;
        //return Arrays.asList(response.getBody().getData());
    }

    @GetMapping("saa-kalleim")
    public Produkt getPriciest(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produkt[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET,null , Produkt[].class);
        Produkt priciest = response.getBody()[0];
        for (Produkt p : response.getBody()){
            if (p.price > priciest.price){
                priciest = p;
            }
        }
        return priciest;
    }

    @GetMapping("saa-odavaim")
    public Produkt getCheapest(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produkt[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET,null , Produkt[].class);
        Produkt cheapest = response.getBody()[0];
        for (Produkt p : response.getBody()){
            if (p.price < cheapest.price){
                cheapest = p;
            }
        }
        return cheapest;
    }

    @GetMapping("saa-odavaim/{summa}")
    public List<Produkt> getCheaperThan(@PathVariable int summa){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produkt[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET,null , Produkt[].class);
        List<Produkt> produktid = new ArrayList<>();
        for (Produkt p : response.getBody()){
            if (p.price < summa){
                produktid.add(p);
            }
        }
        return produktid;
    }

    @GetMapping("saa-kalleim/{summa}")
    public List<Produkt> getPricierThan(@PathVariable int summa){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produkt[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET,null , Produkt[].class);
        List<Produkt> produktid = new ArrayList<>();
        for (Produkt p : response.getBody()){
            if (p.price > summa){
                produktid.add(p);
            }
        }
        return produktid;
    }

    @GetMapping("saa-vahepealne/{min}/{max}")
    public List<Produkt> getBetween(@PathVariable int min, @PathVariable int max){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produkt[]> response = restTemplate.exchange("https://api.escuelajs.co/api/v1/products", HttpMethod.GET,null , Produkt[].class);
        List<Produkt> produktid = new ArrayList<>();
        for (Produkt p : response.getBody()){
            if (p.price >= min && p.price <= max){
                produktid.add(p);
            }
        }
        return produktid;
    }
}
