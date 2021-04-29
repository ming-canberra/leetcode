package medium;

import java.util.ArrayList;
import java.util.List;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        RobotBoundedInCircle thisClass = new RobotBoundedInCircle();
        System.out.println (thisClass.isRobotBounded("234"));
    }
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};

        int dIndex = 0;

        int[] position = new int[]{0, 0};

        for (int i = 0; i < instructions.length(); i++)
        {
            char cChar = instructions.charAt(i);
            if('G' == cChar){
                position[0] += directions[dIndex][0];
                position[1] += directions[dIndex][1];
            }
            else if('R' == cChar){
                dIndex++;
                if (dIndex == 4){
                    dIndex = 0;
                }
            }
            else if('L' == cChar){
                dIndex--;
                if (dIndex == -1){
                    dIndex = 3;
                }
            }
        }

        if (position[0] == 0 && position[1] == 0)
        {
            return true;
        }

        if (dIndex!=0){
            return true;
        }

        return false;
    }
}