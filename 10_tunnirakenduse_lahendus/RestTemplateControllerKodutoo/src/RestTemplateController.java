package ee.tlu.salat.controller;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RestTemplateController {
    //https://jsonplaceholder.typicode.com/posts
    @GetMapping("saa-postitused")
    public List<Post> getPosts(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        //1.aadress kuhu, 2. meetod mida teeme, 3. mida kaasa saadame, 4. Mis objekti kujuna
        ResponseEntity<Post[]> response =  restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);



        return List.of(response.getBody());
    }
    @GetMapping("saa-postitused/{kasutaja}")
    public List<Post> getUserPosts(@PathVariable int kasutajaId){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response =  restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);

        List<Post> kasutajapostitused = new ArrayList<>();
        for (Post p : response.getBody()){
            if (p.getUserId() == kasutajaId){
                kasutajapostitused.add(p);
            }
        }

        return kasutajapostitused;
    }


    @GetMapping("omniva")
    public List<Omniva> getOmnivaPMs(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        //1.aadress kuhu, 2. meetod mida teeme, 3. mida kaasa saadame, 4. Mis objekti kujuna
        ResponseEntity<Omniva[]> response =  restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);
        return List.of(response.getBody());
    }

    @GetMapping("omniva/{country}")
    public List<Omniva> getOmnivaPMsByCountry(@PathVariable String country){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        //1.aadress kuhu, 2. meetod mida teeme, 3. mida kaasa saadame, 4. Mis objekti kujuna
        ResponseEntity<Omniva[]> response =  restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);
        List<Omniva> omnivaPakiautomaadid = new ArrayList<>();
        for (Omniva o : response.getBody()){
            if (o.getA0_NAME().equals(country)){
                omnivaPakiautomaadid.add(o);
            }
        }

        return omnivaPakiautomaadid;
    }

    @GetMapping("saa-nordpooli-hinnad")
    public Nordpool getNordpooliHinnad(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        //1.aadress kuhu, 2. meetod mida teeme, 3. mida kaasa saadame, 4. Mis objekti kujuna
        ResponseEntity<Nordpool> response =  restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);
        return response.getBody();
    }

    @GetMapping("saa-nordpooli-hinnad/{country}")
    public List<TimestampPrice> getNordpooliHinnadByCountry(@PathVariable String country){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Nordpool> response =  restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);
        List<TimestampPrice> timeStampPrices = new ArrayList<>();
        if (country.equals("ee")){
            timeStampPrices = response.getBody().getData().getEe();
        } else if (country.equals("lv")){
            timeStampPrices = response.getBody().getData().getLv();
        } else if (country.equals("lt")){
            timeStampPrices = response.getBody().getData().getLt();
        } else if (country.equals("fi")){
            timeStampPrices = response.getBody().getData().getFi();
        }
        return timeStampPrices;
    }
}
