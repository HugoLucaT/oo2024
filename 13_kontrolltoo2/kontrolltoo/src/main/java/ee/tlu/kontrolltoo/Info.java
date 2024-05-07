package ee.tlu.kontrolltoo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Info {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<People> data;
    public Support support;
}
