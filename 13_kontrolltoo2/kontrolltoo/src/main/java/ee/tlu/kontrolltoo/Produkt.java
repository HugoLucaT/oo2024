package ee.tlu.kontrolltoo;

import java.util.ArrayList;
import java.util.Date;

public class Produkt {
    public int id;
    public String title;
    public int price;
    public String description;
    public ArrayList<String> images;
    public Date creationAt;
    public Date updatedAt;
    public Kategooria category;
}
