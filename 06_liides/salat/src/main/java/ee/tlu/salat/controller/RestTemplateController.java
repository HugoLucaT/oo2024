package ee.tlu.salat.controller;

import ee.tlu.salat.model.Job;
import ee.tlu.salat.model.JobRoot;
import ee.tlu.salat.model.Omniva;
import ee.tlu.salat.model.Post;
import ee.tlu.salat.model.nordpool.Nordpool;
import ee.tlu.salat.model.nordpool.TimestampPrice;
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





    @GetMapping("tookohad")
    public List<Job> saaKoik(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jobicy.com/api/v2/remote-jobs?count=50&geo=estonia&industry=engineering";
        ResponseEntity<JobRoot> response =  restTemplate.exchange(url, HttpMethod.GET, null, JobRoot.class);
        return response.getBody().getJobs();
    }

    @GetMapping("tookohad/{tookoht}")
    public List<Job> saaTookoht(@PathVariable String tookoht){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jobicy.com/api/v2/remote-jobs?count=50&geo=estonia&industry=engineering";
        ResponseEntity<JobRoot> response =  restTemplate.exchange(url, HttpMethod.GET, null, JobRoot.class);
        List<Job> tookohad = new ArrayList<>();
        for (Job j : response.getBody().getJobs()) {
            if (j.getJobTitle().contains(tookoht)) {
                tookohad.add(j);
            }
        }
        return tookohad;
    }

    @GetMapping("tookohad/nimetus")
    public List<String> saaTookoht(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jobicy.com/api/v2/remote-jobs?count=50&geo=estonia&industry=engineering";
        ResponseEntity<JobRoot> response =  restTemplate.exchange(url, HttpMethod.GET, null, JobRoot.class);
        List<String> tookohad = new ArrayList<>();
        for (Job j : response.getBody().getJobs()) {
            tookohad.add(j.getJobTitle());
        }
        return tookohad;
    }

    @GetMapping("tookohad/kirjeldus/{id}")
    public String saaTookoht(@PathVariable int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jobicy.com/api/v2/remote-jobs?count=50&geo=estonia&industry=engineering";
        ResponseEntity<JobRoot> response =  restTemplate.exchange(url, HttpMethod.GET, null, JobRoot.class);
        String tekst = "";
        for (Job j : response.getBody().getJobs()) {
            if (j.getId() == id) {
                tekst = j.getJobDescription();
            }
        }
        return tekst;
    }

    @GetMapping("tookohad/minpalk/{palk}")
    public List<Job> minPalgaOtsing(@PathVariable int palk){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jobicy.com/api/v2/remote-jobs?count=50&geo=estonia&industry=engineering";
        ResponseEntity<JobRoot> response =  restTemplate.exchange(url, HttpMethod.GET, null, JobRoot.class);
        List<Job> tookohad = new ArrayList<>();
        for (Job j : response.getBody().getJobs()) {
            if (j.getAnnualSalaryMin() != null && Integer.valueOf(j.getAnnualSalaryMin()) >= palk) {
                tookohad.add(j);
            }
        }
        return tookohad;
    }

    @GetMapping("tookohad/minpalk")
    public List<Job> minPalk(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jobicy.com/api/v2/remote-jobs?count=50&geo=estonia&industry=engineering";
        ResponseEntity<JobRoot> response =  restTemplate.exchange(url, HttpMethod.GET, null, JobRoot.class);
        List<Job> tookohad = new ArrayList<>();
        for (Job j : response.getBody().getJobs()) {
            if (j.getAnnualSalaryMin() != null) {
                tookohad.add(j);
            }
        }
        return tookohad;
    }
}
