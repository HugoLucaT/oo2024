package ee.tlu.salat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class JobRoot {
    private String apiVersion;
    private String documentationUrl;
    private String friendlyNotice;
    private int jobCount;
    private String xRayHash;
    private String clientKey;
    private String lastUpdate;
    private List<Job> jobs;

}
