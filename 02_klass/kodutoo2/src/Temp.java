//import java.util.Date;

import static java.lang.Math.round;

public class Temp {
    //Date kuupaev = new Date();

    double vihm;

    boolean celsius;

    float temp;

    public Temp(double vihm, boolean celsius, float temp) {
        this.celsius = celsius;
        this.vihm = vihm;
        this.temp = temp;
    }

    public void tempVahetus(){
        if (celsius == true) {
            float vastus = (9/5 * temp) + 32;
            celsius = !celsius;
            temp = round(vastus);
        } else {
            float vastus = (temp - 32) * 5/9;
            celsius = !celsius;
            temp = round(vastus);
        }
    }

    public String sademed() {
        if (vihm == 0){
            return ("Vihma ei sadanud");
        } else {
            return ("Vihma sadas " + vihm + " millimeetrit");
        }
    }
}
