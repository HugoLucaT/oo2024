package ee.tlu.salat.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Job {
    private int id;
    private String url;
    private String jobSlug;
    private String jobTitle;
    private String companyName;
    private String companyLogo;
    private ArrayList<String> jobIndustry;
    private ArrayList<String> jobType;
    private String jobGeo;
    private String jobLevel;
    private String jobExcerpt;
    private String jobDescription;
    private String pubDate;
    private String annualSalaryMin;
    private String annualSalaryMax;
    private String salaryCurrency;
}

