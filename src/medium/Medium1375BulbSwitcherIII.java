package medium;

public class Medium1375BulbSwitcherIII {
    class Solution {
        public int numTimesAllBlue(int[] light) {
            int counter = 0;
            int len = light.length;
            boolean[] lightsOn = new boolean[len];

            int blueIdx = -1; // all lights on and before this idx are on
            int rightMostIdx = -1;

            for (int i = 0; i < light.length; i++){
                lightsOn[light[i] - 1] = true;
                if (light[i] - 1 > rightMostIdx){
                    rightMostIdx = light[i] - 1;
                }

                if (light[i] - 1 == blueIdx + 1){

                    // move blueIdx
                    blueIdx++;
                    while(blueIdx < len && lightsOn[blueIdx]){
                        blueIdx++;
                    }
                    blueIdx--;
                }

                if (blueIdx >= rightMostIdx){
                    counter++;
                }


            }

            return counter;
        }
    }
}