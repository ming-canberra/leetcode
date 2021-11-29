package medium;

import java.util.*;

public class Medium1344AngleBetweenHandsofaClock {
    class Solution {
        public double angleClock(int hour, int minutes) {
            if (hour == 12){
                hour = 0;
            }
            double degreesPerHour = (double)30;
            double degreesPerMin = (double)6;
            double degreeM = degreesPerMin * minutes;
            double degreeH = degreesPerHour * hour + degreeM / 360 * degreesPerHour;
            if (Math.abs(degreeH - degreeM) <= 180){
                return Math.abs(degreeH - degreeM);
            }
            else{
                return 360 - Math.abs(degreeH - degreeM);
            }
        }
    }
}